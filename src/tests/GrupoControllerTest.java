package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.GrupoController;
import exceptions.DadoIncompletoException;
import models.Grupo;

public class GrupoControllerTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRecuperarGrupos() throws DadoIncompletoException {
		Grupo g1 = new Grupo("Carboidratos");
		Grupo g2 = new Grupo("Carnes e Ovos");
		Grupo g3 = new Grupo("Verde");
		GrupoController.salvarNaLista(g1);
		GrupoController.salvarNaLista(g2);
		GrupoController.salvarNaLista(g3);
		
		GrupoController grupoController = new GrupoController();
		String[] nome = {"Carboidratos", "Carnes e Ovos", "Verde"};
		
		assertEquals(grupoController.getNomesGrupos(), nome);
	}
	
	
}
