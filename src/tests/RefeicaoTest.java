package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;
import models.Refeicao;

public class RefeicaoTest {
	
	@Test
	public void testInstanciacaoRefeicao() {
		
		final String nome = "Almoço";
		
		List<Grupo> grupos = new ArrayList<Grupo>();
		List<Alimento> alimentos = new ArrayList<Alimento>();
		
		try {
			grupos.add(new Grupo("Carboidratos"));
			alimentos.add(new Alimento("Pão", "gramas", grupos.get(0)));
				
		} catch (DadoIncompletoException e) {
			// Do nothing
		}
				
		Refeicao refeicao = new Refeicao(nome, alimentos);
		
		assertEquals(nome, refeicao.getNome());
		assertEquals(alimentos, refeicao.getAlimentos());
		
		final String novoNome = "Jantar";
		refeicao.setNome(novoNome);
		assertEquals(novoNome, refeicao.getNome());
		assertNotEquals(nome, refeicao.getNome());
		
		
		List<Grupo> novoGrupos = new ArrayList<Grupo>();
		List<Alimento> novoAlimentos = new ArrayList<Alimento>();
		
		try {
			novoGrupos.add(new Grupo("Carnes"));
			novoAlimentos.add(new Alimento("Frango", "gramas", novoGrupos.get(0)));
				
		} catch (DadoIncompletoException e) {
			// Do nothing
		}
		
		refeicao.setAlimentos(novoAlimentos);
		
		assertEquals(novoAlimentos, refeicao.getAlimentos());
		assertNotEquals(alimentos, refeicao.getAlimentos());
			
	}

}
