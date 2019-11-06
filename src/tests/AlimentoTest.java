package tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;
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
//		String nome = "Arroz";
//		String medida = "gramas";
//		Grupo grupo = null;
		
		a = Alimento.obterAlimento(null, null, null);
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void testDadoVazioNomeAlimento() throws DadoIncompletoException, DadoVazioException {

    	String nome = "Joberto";
    	String medida = "25 gramas";
    	Grupo grupo = new Grupo(1, "Verde");
    	
        thrown.expect(DadoVazioException.class);
        thrown.expectMessage("Campo nome não pode ser vazio");

       
        Alimento al = new Alimento(nome, medida, grupo);

        al.setNome("");
        
    }
   
    @Test
    public void testDadoVazioMedidaAlimento() throws DadoIncompletoException, DadoVazioException {

    	String nome = "Alana";
    	String medida = "80 gramas";
    	Grupo grupo = new Grupo(2, "Carboidrato");
    	
        thrown.expect(DadoVazioException.class);
        thrown.expectMessage("Campo medida não pode ser vazio");

        
        Alimento al = new Alimento(nome, medida, grupo);

        al.setMedida("");
       
    }
    
    @Test
    public void testDadoVazioGrupoAlimento() throws DadoVazioException, DadoIncompletoException {

    	String nome = "Melanie";
    	String medida = "100 gramas";
    	Grupo grupo = new Grupo(2, "Carboidrato");
    	
        thrown.expect(DadoVazioException.class);
        thrown.expectMessage("Campo grupo não pode ser vazio");

        
        Alimento al = new Alimento(nome, medida, grupo);

        al.setGrupo(null);
       
    }
    

}
