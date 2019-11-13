package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

public class AlimentoController {

	public static void salvarAlimento(String nome, String medida, String nomeGrupo) throws DadoIncompletoException{
		Grupo grupo = new Grupo(nomeGrupo);
		Alimento alimento = new Alimento(nome, medida, grupo);
		salvarNaLista(alimento);
	}
	
	public static Alimento editarAlimento(String nomeAtual, String nome, String medida, String nomeGrupo) throws  DadoIncompletoException{
		
		Grupo novoGrupo = null;
		Alimento novoAlimento = null;
		
		for(Grupo g: Grupo.getAllGrupos()) {
			if(g.getNome() == nomeGrupo) {
				novoGrupo = g;
				break;
			}
		}
		
		for (Alimento al: Alimento.getAllAlimentos()) {
			if(al.getNome() == nomeAtual) {
				al.setNome(nome);
				al.setMedida(medida);
				al.setGrupo(novoGrupo);
				novoAlimento = al;
				break;
			}
		}
		
		return novoAlimento;
	}
	
	//////////////////////////////////////////////////////
	
	public static void salvarNaLista(Alimento alimento) {
		boolean canSave = true;
		
		for(Alimento a : Alimento.getAllAlimentos()) {
			if (alimento.getNome().toLowerCase().equals(a.getNome().toLowerCase())) {
				canSave = false;
			}
		}
		
		if (canSave) {			
			Alimento.addAlimento(alimento);
		} else {
			System.out.println("Este elemento já existe na base!");
		}
		
	}


	public static void escrever() {
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("alimentos.txt"));
			
			for(Alimento a : Alimento.getAllAlimentos()) {
				String nomeGrupo = a.getGrupo().getNome();
				
				String s = a.getNome() + "%" + a.getMedida() + "%" + nomeGrupo + "\n";
				os.write(s.getBytes());
			}
		
			os.close();
			
		} catch (IOException e) {
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
				
				String[] partes = s.split("%");
				
				Grupo g = GrupoController.obterGrupo(partes[2]);
				
				new Alimento(partes[0], partes[1], g);
				
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
	
	public static Alimento obterDaLista(String nome) {
		
		for (Alimento a : Alimento.getAllAlimentos()) {
			if (nome.equals(a.getNome())) {
				return a;
			}
		}
		
		return null;
	}
//	
//	public static Alimento obterGrupo(String nome, String medida, Grupo grupo) throws DadoIncompletoException {
//		
//		Alimento a = obterDaLista(nome, medida, grupo);
//		if (a == null) {
//			a = new Alimento(nome, medida, grupo);
//			salvarNaLista(a);
//		}
//		
//		return a;
//	}
//	
//	public static Alimento obterAlimento(String nome, String medida, Grupo grupo) throws DadoIncompletoException {
//		Alimento a = new Alimento(nome, medida, grupo);
//		return a;
//	}
	
	public static String[] getNomesAlimentos() {
		List<String> nomeAlimentosAux = new ArrayList<String>();
		
		for(int i = 0; i < Alimento.getAllAlimentos().size(); i++) {
			nomeAlimentosAux.add(Alimento.getAllAlimentos().get(i).getNome());
		}
		
		String[] nomeAlimentos = new String[nomeAlimentosAux.size()];
		nomeAlimentos = nomeAlimentosAux.toArray(nomeAlimentos);
		
		Arrays.sort(nomeAlimentos);
		
		return nomeAlimentos; 
	}
}
