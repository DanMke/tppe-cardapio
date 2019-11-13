package models;

import java.util.List;

import exceptions.DadoIncompletoException;

public class Refeicao {
	
	private List<Alimento> alimentos;
	private String nome;
	
	public Refeicao(String nome, List<Alimento> alimentos) throws DadoIncompletoException {
		verificaDados(nome, alimentos);
		this.nome = nome;
		this.alimentos = alimentos;
	}
	
	private void verificaDados(String nome, List<Alimento> alimentos) throws DadoIncompletoException {
		if (nome == null || nome.equals("") || alimentos == null) {
			StringBuilder builder = criaMensagemErro(nome, alimentos);
			throw new DadoIncompletoException(builder.toString());
		}
	}

	private StringBuilder criaMensagemErro(String nome, List<Alimento> alimentos) {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("Dados informados para Grupo estão incompletos:\n");
		builder.append(nome == null || nome == "" ? "Nome: " + nome + "\n" : "");
		builder.append(alimentos == null ? "Alimentos: " + alimentos + "\n" : "");
		
		return builder;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws DadoIncompletoException {
		if(nome == null || nome.equals("")) {
			throw new  DadoIncompletoException("Campo nome não pode ser vazio");
		}
		this.nome = nome;
	}
	
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	
	public void setAlimentos(List<Alimento> alimentos) throws DadoIncompletoException {
		if(alimentos == null) {
			throw new DadoIncompletoException("Campo alimentos não pode ser vazio");
		}
		this.alimentos = alimentos;
	}

}
