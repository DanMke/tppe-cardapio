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
		// removendo id, pois ela é gerada automaticamente em caso de conflito
		//Integer id = 1;
		String nome = "Carboidratos";
		
		g = Grupo.obterGrupo(nome);
		assertNotNull(g);
		// assertEquals(id, g.getId());
		assertEquals(nome, g.getNome());
	}
	
	@Test (expected = DadoIncompletoException.class)
	public void testInstanciacaoGrupoDadoIncompleto() throws DadoIncompletoException {
		String nome = "";
		
		g = Grupo.obterGrupo(nome);
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void testDadoVazioIdGrupo() throws DadoIncompletoException {

    	Integer id = 1;
    	String nome = "Verde"; 
    	
    	thrown.expect(DadoIncompletoException.class);
        thrown.expectMessage("Campo id não pode ser vazio");
    	
    	Grupo grupo = new Grupo(id, nome);
    	
        grupo.setId(null);
        
    }
    
    @Test
    public void testDadoVazioNomeGrupo() throws DadoIncompletoException {

    	Integer id = 2;
    	String nome = "Carboidrato"; 
    	
    	thrown.expect(DadoIncompletoException.class);
        thrown.expectMessage("Campo nome não pode ser vazio");
    	
    	Grupo grupo = new Grupo(id, nome);
    	
        grupo.setNome("");
        
    }

}
