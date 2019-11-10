package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
			grupos.add(new Grupo(1, "Carboidratos"));
			alimentos.add(new Alimento("Pão", "gramas", grupos.get(0)));
				
		} catch (DadoIncompletoException e) {
			// Do nothing
		}
				
		Refeicao refeicao = new Refeicao(nome, grupos, alimentos);
		
		assertEquals(nome, refeicao.getNome());
		assertEquals(alimentos, refeicao.getAlimentos());
		assertEquals(grupos, refeicao.getGrupos());
		
		final String novoNome = "Jantar";
		refeicao.setNome(novoNome);
		assertEquals(novoNome, refeicao.getNome());
		assertNotEquals(nome, refeicao.getNome());
		
		
		List<Grupo> novoGrupos = new ArrayList<Grupo>();
		List<Alimento> novoAlimentos = new ArrayList<Alimento>();
		
		try {
			novoGrupos.add(new Grupo(1, "Carnes"));
			novoAlimentos.add(new Alimento("Frango", "gramas", novoGrupos.get(0)));
				
		} catch (DadoIncompletoException e) {
			// Do nothing
		}
		
		refeicao.setGrupos(novoGrupos);
		refeicao.setAlimentos(novoAlimentos);
		
		assertEquals(novoGrupos, refeicao.getGrupos());
		assertNotEquals(grupos, refeicao.getGrupos());
		
		assertEquals(novoAlimentos, refeicao.getAlimentos());
		assertNotEquals(alimentos, refeicao.getAlimentos());
			
	}

}
