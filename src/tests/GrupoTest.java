package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DadoIncompletoException;
import models.Grupo;

public class GrupoTest {
	
	Grupo g;
	
	@Test
	public void testInstanciacaoGrupo() throws DadoIncompletoException {
		Integer id = 1;
		String nome = "Carboidratos";
		
		g = Grupo.obterGrupo(id, nome);
		assertNotNull(g);
		assertEquals(id, g.getId());
		assertEquals(nome, g.getNome());
	}
	
	@Test (expected = DadoIncompletoException.class)
	public void testInstanciacaoGrupoDadoIncompleto() throws DadoIncompletoException {
		Integer id = 1;
		String nome = "";
		
		g = Grupo.obterGrupo(id, nome);
	}

}
