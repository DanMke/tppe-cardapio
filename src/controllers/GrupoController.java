package controllers;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import exceptions.DadoIncompletoException;
import models.Grupo;

public class GrupoController {

	public static String[] getNomesGrupos() {
				
		List<String> nomeGruposAux = new ArrayList<String>();
		
		for(int i = 0; i < Grupo.getAllGrupos().size(); i++) {
			nomeGruposAux.add(Grupo.getAllGrupos().get(i).getNome());
		}
		
		String[] nomeGrupos = new String[nomeGruposAux.size()];
		nomeGrupos = nomeGruposAux.toArray(nomeGrupos);
		
		
		Arrays.sort(nomeGrupos);
		
		for(String g : nomeGrupos) {
			System.out.println(g);
		}
		System.out.print("\n\n\n\n");
		
//		 return nomeGrupostoArray(new type[collection.size()]);
		return nomeGrupos; 
	}
	
	///////////////////////////////////
	
	public static void carregar() {
		
		Scanner scanner = null;
		File file = new File("grupos.txt");
				
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				new Grupo(s);
			}
			
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DadoIncompletoException e) {
			e.printStackTrace();
		}
	}
	
	public static void escrever() {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("grupos.txt"));
			
			for(Grupo g : Grupo.getAllGrupos()) {
				String s = g.getNome() + "\n";
				os.write(s.getBytes());
			}
		
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Grupo obterDaLista(String nome) {
		
		for (Grupo g : Grupo.getAllGrupos()) {
			if (nome.equals(g.getNome())) {
				return g;
			}
		}
		
		return null;
	}
	
	public static Grupo obterGrupo(String nome) throws DadoIncompletoException {
		
		Grupo g = obterDaLista(nome);
		if (g == null) {
			g = new Grupo(nome);
			salvarNaLista(g);
		}
		
		return g;
	}
	
	public static void editarGrupo(String nome, String novoNome) throws DadoIncompletoException {
		
		for (Grupo g: Grupo.getAllGrupos()) {
			if(g.getNome() == nome) {
				g.setNome(novoNome);
				break;
			}
		}
		
	}
	
	public static void salvarNaLista(Grupo grupo) throws DadoIncompletoException {
		boolean canSave = true;
		
		for(Grupo g : Grupo.getAllGrupos()) {
			if (grupo.getNome().toLowerCase().equals(g.getNome().toLowerCase())) {
				canSave = false;
			}
		}
		
		if (canSave) {		
			Grupo.addGrupo(grupo);
		} else {
			System.out.println("Este elemento já existe na base!");
		}
	}
	
	public static void salvarGrupo(String nome) throws DadoIncompletoException {
		Grupo grupo = new Grupo(nome);
		salvarNaLista(grupo);
	}
	
}

