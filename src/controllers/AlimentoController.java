package controllers;

public class AlimentoController {
	
	//TODO SALVAR NO BANCO
	public void salvarAlimento(String nome, String medida) throws DadoIncompletoException{
		Grupo grupo = new Grupo(5, "Qualquer um");
		new Alimento(nome, medida, grupo);
	}

}
.util.HashMap;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

public class AlimentoController {
	

}
