package controllers;

public class EditarAlimentoParameter {
	public String nomeAtual;
	public String nome;
	public String medida;
	public String nomeGrupo;

	public EditarAlimentoParameter(String nomeAtual, String nome, String medida, String nomeGrupo) {
		this.nomeAtual = nomeAtual;
		this.nome = nome;
		this.medida = medida;
		this.nomeGrupo = nomeGrupo;
	}
}