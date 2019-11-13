package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;
import models.Refeicao;

@RunWith(Parameterized.class)
public class RefeicaoTest {
	
	private String nome;
	private List<Alimento> alimentos;
	private Class<? extends Exception> excecaoEsperada;
	
	public RefeicaoTest(String nome, List<Alimento> alimentos, Class<? extends Exception> excecaoEsperada) {
		this.nome = nome;
		this.alimentos = alimentos;
		this.excecaoEsperada = excecaoEsperada;
	}
	
	@Parameters
    public static Iterable<Object[]> data() throws DadoIncompletoException {
        return Arrays.asList(new Object[][] {     
                 { "Almoço", null, DadoIncompletoException.class},
                 { "", null, DadoIncompletoException.class},
                 { "", Arrays.asList(
                		 new Alimento("Pão", "gramas", new Grupo("Carboidratos")), 
                		 new Alimento("Alface", "gramas", new Grupo("Vegetais")), 
                		 new Alimento("Carne moída", "gramas", new Grupo("Carnes e ovos"))
                		 ), 
                	 	DadoIncompletoException.class},
                 { "Almoço", Arrays.asList(
                		 new Alimento("Arroz", "gramas", new Grupo("Carboidratos")), 
                		 new Alimento("Alface", "gramas", new Grupo("Vegetais")), 
                		 new Alimento("Carne moída", "gramas", new Grupo("Carnes e ovos"))
                		 ), 
                	 	null},
                 { "Desjejum", Arrays.asList(
                		 new Alimento("Pão", "gramas", new Grupo("Carboidratos")), 
                		 new Alimento("Manteiga", "gramas", new Grupo("Gorduras")), 
                		 new Alimento("Carne moída", "gramas", new Grupo("Carnes e ovos"))
                		 ), 
                	 	null}
           });
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void test() throws DadoIncompletoException {
    	Refeicao refeicao;
    	
    	if (excecaoEsperada != null) {
            thrown.expect(excecaoEsperada);
        }
    	
    	refeicao = new Refeicao(nome, alimentos);
    	
    	assertNotNull(refeicao);
    	assertEquals(nome, refeicao.getNome());
    	assertEquals(alimentos, refeicao.getAlimentos());
    	
    }
    
    @Test
    public void testSetNome() throws DadoIncompletoException {
    	if (excecaoEsperada != null) {
    		thrown.expect(excecaoEsperada);
    	}
    	
    	Refeicao refeicao = new Refeicao("Desjejum", alimentos);
    	
    	refeicao.setNome(nome);
        
        assertNotNull(refeicao);
        assertEquals(nome, refeicao.getNome());
        
    }
    
    @Test
    public void testSetAlimentos() throws DadoIncompletoException {
    	
    	if (excecaoEsperada != null) {
    		thrown.expect(excecaoEsperada);
    	}
    	
    	Refeicao refeicao = new Refeicao(nome, Arrays.asList(
        		new Alimento("Arroz integral", "gramas", new Grupo("Carboidratos")), 
        		new Alimento("Couve", "gramas", new Grupo("Vegetais")), 
        		new Alimento("Patinho", "gramas", new Grupo("Carnes e ovos"))
        		));
    	
        if (alimentos != null) 
        	refeicao.setAlimentos(alimentos);
        else
        	refeicao.setAlimentos(null);
        
        assertNotNull(refeicao);
        assertEquals(alimentos, refeicao.getAlimentos());
        
    }
    
}
