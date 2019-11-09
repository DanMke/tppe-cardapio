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
	
	public Alimento editarAlimento(String nomeAtual, String nome, String medida, String nomeGrupo) throws  DadoIncompletoException{
		
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
}
