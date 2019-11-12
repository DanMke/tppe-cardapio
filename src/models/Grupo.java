package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exceptions.DadoIncompletoException;

public class Grupo {
	
	private Integer id;
	private String nome;

	private static List<Grupo> grupos = new ArrayList<>();
	private List<Alimento> alimentos = new ArrayList<>();
	
	public Grupo(Integer id, String nome) throws DadoIncompletoException {
		verificaDados(id, nome);
		
		this.id = id;
		this.nome = nome;

		if (grupos == null){
			grupos = new LinkedList<Grupo>();
		}
		
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

	public void setId(Integer id) throws DadoIncompletoException {
		
		if(id == null) {
			throw new  DadoIncompletoException("Campo id não pode ser vazio");
		}
		
		this.id = id;
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
		this.alimentos.add(alimento);
	}
	
	public static List<Grupo> getAllGrupos() {
		return grupos;
	}
	
	public static void addGrupo(Grupo grupo) {
		Grupo.grupos.add(grupo);
	}
	
}
