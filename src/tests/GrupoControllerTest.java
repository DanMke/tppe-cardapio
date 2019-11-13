package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.GrupoController;
import exceptions.DadoIncompletoException;

public class GrupoControllerTest {
	
	@Test
	public void testRecuperarGrupos() throws DadoIncompletoException {
		GrupoController.salvarGrupo("Carboidratos");
		GrupoController.salvarGrupo("Carnes e Ovos");
		GrupoController.salvarGrupo("Verde");
		
		String[] nome = {"Carboidratos", "Carnes e Ovos", "Verde"};
		
		assertArrayEquals(GrupoController.getNomesGrupos(), nome);
	}
	
	
}
