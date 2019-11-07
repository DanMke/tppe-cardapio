package controllers;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

public class AlimentoController {
	
	//TODO SALVAR NO BANCO
	public void salvarAlimento(String nome, String medida, String nomeGrupo) throws DadoIncompletoException{
		// TODO Buscar grupo relacionado a esse nome no BD
		Grupo grupo = new Grupo(5, nomeGrupo);
		new Alimento(nome, medida, grupo);
	}

}
