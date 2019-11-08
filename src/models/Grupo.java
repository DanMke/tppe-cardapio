package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;

public class Grupo {
	
	private Integer id;
	private String nome;

	public static List<Grupo> grupos = new ArrayList<>();
	public static List<Alimento> alimentos = new ArrayList<>();
	
	public Grupo(Integer id, String nome) throws DadoIncompletoException {
		verificaDados(id, nome);
		
		this.id = id;
		this.nome = nome;

		if (this.grupos == null){

			this.grupos = new LinkedList<Grupo>();
		}
		
		this.salvarNaLista();
	}
	
	public static void escrever() {
	
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("grupos.txt"));
			
			for(Grupo g : grupos) {
				String s = g.id + "%" + g.nome + "\n";
				os.write(s.getBytes());
			}
		
			os.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void carregar() {
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("grupos.txt"));
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				var partes = s.split("%");
				
				new Grupo(Integer.parseInt(partes[0].trim()), partes[1]);
			}
			
			scanner.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DadoIncompletoException e) {
			e.printStackTrace();
		}
	}

	private void salvarNaLista(){

		for(Grupo g : grupos) {
			if (this.id == g.id) {
				this.id += 1;
			}
		}

		grupos.add(this);
	}
	
	private static Grupo obterDaLista(String nome) {
		
		for (Grupo g : Grupo.grupos) {
			if (nome.equals(g.nome)) {
				return g;
			}
		}
		
		return null;
	}
	
	public static void editarGrupo(Integer id, String novoNome) {
		
		for (Grupo g: grupos) {
			if( g.id == id) {
				g.nome = novoNome;
				break;
			}
		}
		
	}
	
	public static Grupo obterGrupo(String nome) throws DadoIncompletoException {
		
		Grupo g = obterDaLista(nome);
		if (g == null) {
			g = new Grupo(1, nome);
		}
		
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
		
		if(id == null) {
			throw new  DadoVazioException("Campo id não pode ser vazio");
		}
		
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws DadoVazioException {
		
		if(nome == null || nome.equals("")) {
			throw new  DadoVazioException("Campo nome não pode ser vazio");
		}
		
		this.nome = nome;
	}

}
