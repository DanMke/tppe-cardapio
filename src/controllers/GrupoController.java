package controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import exceptions.DadoIncompletoException;
import models.Grupo;

public class GrupoController {

	public String[] getNomesGrupos() {
				
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
	
	//TODO SALVAR NO BANCO
	public void salvarGrupo(String nome) throws DadoIncompletoException{
		//Grupo grupo = new Grupo(1, nome);

	}
}

