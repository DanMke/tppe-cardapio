package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.DadoIncompletoException;
import exceptions.DadoVazioException;
import junit.framework.Assert;
import models.Alimento;
import models.Grupo;
import controllers.AlimentoController;

public class AlimentoControllerTest {
	
	@Test
	public void testEditarAlimento() throws DadoIncompletoException, DadoVazioException {
		
		String nome = "Macarrão";
		String medida = "10 g";
		Grupo gp = new Grupo(2, "Massa");
		
		AlimentoController controller = new AlimentoController();
		
		Alimento al = new Alimento(nome, medida, gp);
		Alimento al2 = controller.editarAlimento(nome, medida, gp.getNome());
		
		assertEquals(al, al2);
	}

}
