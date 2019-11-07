package controllers;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;
import models.Alimento;
import models.Grupo;

public class AlimentoController {

	//TODO SALVAR NO BANCO
	public void salvarAlimento(String nome, String medida, String nomeGrupo) throws DadoIncompletoException{
		// TODO Buscar grupo relacionado a esse nome no BD
		Grupo grupo = new Grupo(5, nomeGrupo);
		new Alimento(nome, medida, grupo);
	}
	
	public Alimento editarAlimento(String nome, String medida, String nomeGrupo) throws DadoVazioException, DadoIncompletoException{
		Alimento alimentoTemp = new Alimento("Não Editado", "G", new Grupo(8, nomeGrupo));
		// TODO Buscar Alimento no BD
		// TODO editar objeto no BD
		// TODO buscar grupo com esse nome
		alimentoTemp.setGrupo(new Grupo(4, nomeGrupo));
		alimentoTemp.setMedida(medida);
		alimentoTemp.setNome(nome);
		
		return alimentoTemp;
	}
}
