package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.DadoIncompletoException;
import models.Grupo;

@RunWith(Parameterized.class)
public class GrupoTest {
	
	private String nome;
	private Class<? extends Exception> excecaoEsperada;
	
	public GrupoTest(String nome, Class<? extends Exception> excecaoEsperada) {
		this.nome = nome;
		this.excecaoEsperada = excecaoEsperada;
	}
	
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "Carboidratos", null},
                 { "Vegetais", null},
                 { "", DadoIncompletoException.class},
                 { null, DadoIncompletoException.class}
           });
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test() throws DadoIncompletoException {
    	Grupo grupo;
    	
    	if (excecaoEsperada != null) {
            thrown.expect(excecaoEsperada);
        }
    	grupo = new Grupo(nome);
    	
    	assertNotNull(grupo);
    	assertEquals(nome, grupo.getNome());
    	
    }
    
    @Test
    public void testSet() throws DadoIncompletoException {
    	Grupo grupo = new Grupo("Carboidratos");
    	
        if (excecaoEsperada != null) {
            thrown.expect(excecaoEsperada);
        }
        
        grupo.setNome(nome);
        
        assertNotNull(grupo);
        assertEquals(nome, grupo.getNome());
        
    }

}
