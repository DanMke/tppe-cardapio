package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

public class AlimentoTest {

	Alimento a;
	
	@Test
	public void testInstanciacaoAlimento() throws DadoIncompletoException {

		Grupo grupo = Grupo.obterGrupo(1, "Carboidratos");
		
		String nome = "Arroz";
		String medida = "gramas";
		
		a = Alimento.obterAlimento(nome, medida, grupo);
		assertNotNull(a);
		assertEquals(nome, a.getNome());
		assertEquals(medida, a.getMedida());
		assertEquals(grupo, a.getGrupo());
	}
	
	@Test (expected = DadoIncompletoException.class)
	public void testInstanciacaoAlimentoDadoIncompleto() throws DadoIncompletoException {
		String nome = "Arroz";
		String medida = "gramas";
		Grupo grupo = null;
		
		a = Alimento.obterAlimento(nome, medida, grupo);
	}

}
