package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.DadoIncompletoException;
import junit.framework.Assert;
import models.Alimento;
import models.Grupo;
import controllers.AlimentoController;

public class AlimentoControllerTest {
	
	@Test
	public void testEditarAlimento() throws DadoIncompletoException{
		
		String nome = "Macarrão";
		String novoNome = "Frango";
		String medida = "10 g";
		Grupo gp = new Grupo(2, "Massa");
		Grupo gp2 = new Grupo(3, "Carnes e Ovos");
		
		AlimentoController controller = new AlimentoController();
		
		new Alimento(nome, medida, gp);
		Alimento al2 = controller.editarAlimento(nome, novoNome, medida, gp2.getNome());
		
		assertEquals(novoNome, al2.getNome());
		assertEquals(medida, al2.getMedida());
		assertEquals(gp2.getNome(), al2.getGrupo().getNome());
		
	}
	
	@Test
	public void testEditarAlimento2() throws DadoIncompletoException {
		
		String nome = "Brocolis";
		String novoNome = "Arroz";
		String medida = "30 g";
		String novaMedida = "10 g";
		Grupo gp = new Grupo(4, "Vegetais");
		Grupo gp2 = new Grupo(5, "Carboidratos");
		
		AlimentoController controller = new AlimentoController();
		
		new Alimento(nome, medida, gp);
		Alimento al2 = controller.editarAlimento(nome, novoNome, novaMedida, gp2.getNome());
		
		assertEquals(novoNome, al2.getNome());
		assertEquals(novaMedida, al2.getMedida());
		assertEquals(gp2.getNome(), al2.getGrupo().getNome());
		
	}

}
