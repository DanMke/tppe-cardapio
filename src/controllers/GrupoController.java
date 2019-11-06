package controllers;

import exceptions.DadoIncompletoException;
import models.Grupo;

public class GrupoController {
	
	public String[] getNomesGrupos() {
		String[] grupos = {"Carboidratos", "Vegetais", "Fibras"};
		return grupos;
	}
	
	//TODO SALVAR NO BANCO
	public void salvarGrupo(String nome) throws DadoIncompletoException{
		Grupo grupo = new Grupo(1, nome);
		
	}
}

