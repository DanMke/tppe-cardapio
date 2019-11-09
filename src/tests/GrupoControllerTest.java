package tests;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Test;

import controllers.GrupoController;
import models.Grupo;

public class GrupoControllerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testRecuperarGrupos() {
		
		GrupoController grupoController = new GrupoController();
		String[] nome = {"Carboidratos", "Vegetais", "Fibras"};
		
		
		assertEquals(grupoController.getNomesGrupos(), nome);
	}
	
	
}
