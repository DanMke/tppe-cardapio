package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exceptions.DadoIncompletoException;

public class Grupo {
	
	private String nome;

	private static List<Grupo> grupos = new ArrayList<>();
	private List<Alimento> alimentos = new ArrayList<>();
	
	public Grupo(String nome) throws DadoIncompletoException {
		verificaDados(nome);
		
		this.nome = nome;

		if (grupos == null){
			grupos = new LinkedList<Grupo>();
		}
		
	}

	private void verificaDados(String nome) throws DadoIncompletoException {
		if (nome == null || nome.equals("")) {
			StringBuilder builder = criaMensagemErro(nome);
			throw new DadoIncompletoException(builder.toString());
		}
	}

	private StringBuilder criaMensagemErro(String nome) {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("Dados informados para Grupo estão incompletos:\n");
		builder.append(nome == null ? "Nome: " + nome + "\n" : "");
		
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
		return this.alimentos;
	}
	
	public void addAlimento(Alimento alimento) {
		boolean canSave = true;
		
		for (Alimento a : alimento.getGrupo().getAlimentos()) {
			if (alimento.getNome().toLowerCase().equals(a.getNome().toLowerCase())) {
				canSave = false;
			}
		}
		if (canSave) {
			this.alimentos.add(alimento);
		}
	}
	
	public static List<Grupo> getAllGrupos() {
		return grupos;
	}
	
	public static void addGrupo(Grupo grupo) {
		Grupo.grupos.add(grupo);
	}
	
}
