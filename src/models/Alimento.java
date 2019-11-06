package models;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;

public class Alimento {
	
	private String nome;
	private String medida;
	private Grupo grupo;
	
	public Alimento(String nome, String medida, Grupo grupo) throws DadoIncompletoException {
		verificaDados(nome, medida, grupo);
		
		this.nome = nome;
		this.medida = medida;
		this.grupo = grupo;
	}
	
	public static Alimento obterAlimento(String nome, String medida, Grupo grupo) throws DadoIncompletoException {
		Alimento a = new Alimento(nome, medida, grupo);
		return a;
	}
	
	private void verificaDados(String nome, String medida, Grupo grupo) throws DadoIncompletoException {
		if (nome == null || nome.equals("") || medida == null || medida.equals("") || grupo == null) {
			StringBuilder builder = criaMensagemErro(nome, medida, grupo);
			throw new DadoIncompletoException(builder.toString());
		}
	}

	private StringBuilder criaMensagemErro(String nome, String medida, Grupo grupo) {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("Dados informados para Grupo estão incompletos:\n");
		builder.append(nome == null ? "Nome: " + nome + "\n" : "");
		builder.append(medida == null ? "Medida: " + medida + "\n" : "");
		builder.append(grupo == null ? "Grupo: " + grupo + "\n" : "");
		
		return builder;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws DadoVazioException {
		
		if(nome.equals("") || nome == null) {
			throw new DadoVazioException("Campo nome não pode ser vazio");
		}
		
		this.nome = nome;
	}
	
	public String getMedida() {
		return medida;
	}
	
	public void setMedida(String medida) throws DadoVazioException {
		
		if(medida.equals("") || medida == null) {
			throw new DadoVazioException("Campo medida não pode ser vazio");
		}
		
		this.medida = medida;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) throws DadoVazioException {
		
		if(grupo == null) {
			throw new DadoVazioException("Campo grupo não pode ser vazio");
		}
	
		this.grupo = grupo;
	}
	

}
