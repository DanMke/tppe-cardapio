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
		new Grupo(4, "Carboidratos");
		new Grupo(5, "Carnes e Ovos");
		new Grupo(6, "Verde");
		
		GrupoController grupoController = new GrupoController();
		String[] nome = {"Carboidratos", "Carnes e Ovos", "Verde"};
		
		assertEquals(grupoController.getNomesGrupos(), nome);
	}
	
	
}
