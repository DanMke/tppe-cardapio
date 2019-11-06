package models;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;

public class Grupo {
	
	private Integer id;
	private String nome;
	
	public Grupo(Integer id, String nome) throws DadoIncompletoException {
		verificaDados(id, nome);
		
		this.id = id;
		this.nome = nome;
	}
	
	public static Grupo obterGrupo(Integer id, String nome) throws DadoIncompletoException {
		Grupo g = new Grupo(id, nome);
		return g;
	}
	
	private void verificaDados(Integer id, String nome) throws DadoIncompletoException {
		if (id == null || nome == null || nome.equals("")) {
			StringBuilder builder = criaMensagemErro(id, nome);
			throw new DadoIncompletoException(builder.toString());
		}
	}

	private StringBuilder criaMensagemErro(Integer id, String nome) {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("Dados informados para Grupo estão incompletos:\n");
		builder.append(id == null ? "Id: " + id + "\n" : "");
		builder.append(nome == null ? "Nome: " + nome + "\n" : "");
		
		return builder;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) throws DadoVazioException {
		
		if(id.equals(null)) {
			throw new  DadoVazioException("Campo id não pode ser vazio");
		}
		
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws DadoVazioException {
		
		if(nome.equals(null) || nome.equals("")) {
			throw new  DadoVazioException("Campo id não pode ser vazio");
		}
		
		this.nome = nome;
	}

}
