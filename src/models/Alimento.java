package models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;

public class Alimento {
	
	private String nome;
	private String medida;
	private Grupo grupo;
	
	public static List<Alimento> alimentos = new ArrayList<>();
	
	public Alimento(String nome, String medida, Grupo grupo) throws DadoIncompletoException {
		verificaDados(nome, medida, grupo);
		
		this.nome = nome;
		this.medida = medida;
		this.grupo = grupo;
		
		this.salvarNaLista();
	}
	
	
	private void salvarNaLista() {
		boolean canSave = true;
		
		for(Alimento a : alimentos) {
			if (this.nome.equals(a.nome)) {
				canSave = false;
			}
		}
		
		if (canSave) {			
			alimentos.add(this);
			this.grupo.alimentos.add(this);
		} else {
			System.out.println("Este elemento já existe na base!");
		}
		
	}


	public static void escrever() {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("alimentos.txt"));
			
			for(Alimento a : alimentos) {
				String nomeGrupo = a.getGrupo().getNome();
				
				String s = a.nome + "%" + a.medida + "%" + nomeGrupo + "\n";
				os.write(s.getBytes());
			}
		
			os.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void carregar() {
		
		Scanner scanner = null;
		File file = new File("alimentos.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			
			scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				var partes = s.split("%");
				
				Grupo g = Grupo.obterGrupo(partes[2]);
				
				new Alimento(partes[0], partes[1], g);
				
			}
			
			scanner.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		catch (DadoIncompletoException e) {
			e.printStackTrace();
		}
	}
	
	public static Alimento editarNomeAlimento (String nomeAtual, String novoNome) throws DadoVazioException {
		
		for (Alimento al: alimentos) {
			if(al.getNome() == nomeAtual) {
				al.setNome(novoNome);
				
				return al;
			}
		}
		
		return null;
		
	}
	
	public static Alimento editarPorcaoAlimento (String nomeAlimento, String medida) throws DadoVazioException {
		
		for (Alimento al: alimentos) {
			if(al.getNome() == nomeAlimento) {
				al.setMedida(medida);
				
				return al;
			}
		}
		
		return null;
		
	}
	
	
	public static Alimento editarGrupoAlimento (String nomeAlimento, String nomeNovoGrupo) throws DadoIncompletoException, DadoVazioException {
		
		for (Alimento al: alimentos) {
			if(al.getNome() == nomeAlimento) {
				Grupo g = Grupo.obterGrupo(nomeNovoGrupo);
				
				al.setGrupo(g);
				
				return al;
			}
		}
		
		return null;
		
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
