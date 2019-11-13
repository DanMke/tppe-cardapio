package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.DadoIncompletoException;
import models.Grupo;

public class GrupoTest {
	
	Grupo g;
	
	@Test
	public void testInstanciacaoGrupo() throws DadoIncompletoException {
		String nome = "Carboidratos";
		
		g = new Grupo(nome);
		assertNotNull(g);
		assertEquals(nome, g.getNome());
	}
	
	@Test (expected = DadoIncompletoException.class)
	public void testInstanciacaoGrupoDadoIncompleto() throws DadoIncompletoException {
		String nome = "";
		
		g = new Grupo(nome);
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void testDadoVazioNomeGrupo() throws DadoIncompletoException {

    	String nome = "Carboidrato"; 
    	
    	thrown.expect(DadoIncompletoException.class);
        thrown.expectMessage("Campo nome não pode ser vazio");
    	
    	Grupo grupo = new Grupo(nome);
    	
        grupo.setNome("");
        
    }

}
