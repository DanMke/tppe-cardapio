package models;

import java.util.List;

public class Refeicao {
	
	private List<Alimento> alimentos;
	private String nome;
	
	public Refeicao(String nome, List<Alimento> alimentos) {
		this.nome = nome;
		this.alimentos = alimentos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	
	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

}
