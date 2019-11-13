package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

@RunWith(Parameterized.class)
public class AlimentoTest {

	private String nome;
	private String medida;
	private String grupo;
	private Class<? extends Exception> excecaoEsperada;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "Brocolis", "10 porcoes", "Vegetais", null},
                 { "Macarrão", "10 gramas", null , DadoIncompletoException.class},
                 { "Lombo", null, "Carnes e Ovos", DadoIncompletoException.class},
                 { null , "1kg", "Vegetais", DadoIncompletoException.class}
           });
    }
    
    public AlimentoTest(
    		String nome, String medida, String grupo, 
    		Class<? extends Exception> excecaoEsperada) {
		this.nome = nome;
		this.medida = medida;
		this.grupo = grupo;
		this.excecaoEsperada = excecaoEsperada;
	}
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testConstrutor() throws DadoIncompletoException {
    	Alimento a;
    	
    	
        if (excecaoEsperada != null) {
            thrown.expect(excecaoEsperada);
        }
        
        if (grupo != null) 
    		a = new Alimento(nome, medida, new Grupo(grupo));
    	else 
    		a = new Alimento(nome, medida, null);

        assertNotNull(a);

    }
    
    @Test
    public void testSet() throws DadoIncompletoException {
    	Alimento a = new Alimento("teste", "teste", new Grupo("teste"));
    	
        if (excecaoEsperada != null) {
            thrown.expect(excecaoEsperada);
        }
        
        if (grupo != null) 
        	a.setGrupo(new Grupo(grupo));
        else
        	a.setGrupo(null);
        
		a.setMedida(medida);
		a.setNome(nome);
		
        assertNotNull(a);

    }

}
