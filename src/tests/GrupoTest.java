package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;
import models.Alimento;
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
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void testDadoVazioIdGrupo() throws DadoIncompletoException, DadoVazioException {

    	Integer id = 1;
    	String nome = "Verde"; 
    	
    	thrown.expect(DadoVazioException.class);
        thrown.expectMessage("Campo id não pode ser vazio");
    	
    	Grupo grupo = new Grupo(id, nome);
    	
        grupo.setId(null);
        
    }
    
    @Test
    public void testDadoVazioNomeGrupo() throws DadoIncompletoException, DadoVazioException {

    	Integer id = 2;
    	String nome = "Carboidrato"; 
    	
    	thrown.expect(DadoVazioException.class);
        thrown.expectMessage("Campo nome não pode ser vazio");
    	
    	Grupo grupo = new Grupo(id, nome);
    	
        grupo.setNome("");
        
    }

}
