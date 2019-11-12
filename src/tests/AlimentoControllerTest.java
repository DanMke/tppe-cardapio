package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;
import controllers.AlimentoController;
import controllers.GrupoController;

public class AlimentoControllerTest {
	
	@Test
	public void testEditarAlimento() throws DadoIncompletoException{
		
		String nome = "Macarrão";
		String novoNome = "Frango";
		String medida = "10 g";
		Grupo gp = new Grupo("Massa");
		GrupoController.salvarNaLista(gp);
		Grupo gp2 = new Grupo("Carnes e Ovos");
		GrupoController.salvarNaLista(gp2);
		
		AlimentoController controller = new AlimentoController();
		
		Alimento al1 = new Alimento(nome, medida, gp);
		AlimentoController.salvarNaLista(al1);
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
		Grupo gp = new Grupo("Vegetais");
		Grupo gp2 = new Grupo("Carboidratos");
		
		AlimentoController controller = new AlimentoController();
		
		Alimento al1 = new Alimento(nome, medida, gp);
		AlimentoController.salvarNaLista(al1);
		Alimento al2 = controller.editarAlimento(nome, novoNome, novaMedida, gp2.getNome());
		
		assertEquals(novoNome, al2.getNome());
		assertEquals(novaMedida, al2.getMedida());
		assertEquals(gp2.getNome(), al2.getGrupo().getNome());
		
	}

}
