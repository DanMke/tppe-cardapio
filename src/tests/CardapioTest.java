package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import org.junit.Test;

import controllers.CardapioController;
import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Cardapio;
import models.Grupo;
import models.Refeicao;

public class CardapioTest {
	
	private static Integer total_alimentos = 0;
	private static Integer total_grupos = 0;
	
	Refeicao obterRefeicao() throws DadoIncompletoException {
		
		Random r = new Random();
		
		String nome = Cardapio.REFEICOES.get(r.nextInt(Cardapio.REFEICOES.size()));
		
		List<Grupo> grupos = new ArrayList<Grupo>();
		List<Alimento> alimentos = new ArrayList<Alimento>();
		
		grupos.add(new Grupo(total_grupos.toString()));
		total_grupos++;
		
		alimentos.add(new Alimento(
				total_alimentos.toString(),
				total_alimentos.toString(), 
				grupos.get(grupos.size() - 1
		)));
		total_alimentos++;
				
		return new Refeicao(nome, alimentos);
	}

	@Test
	public void testeInstanciacaoCardapio() throws DadoIncompletoException {
		
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		for (int i = 0; i < 12; i++) {
			refeicoes.add(obterRefeicao());
		}
		
		Cardapio c = new Cardapio("Segunda", refeicoes);
		assertEquals(refeicoes, c.getRefeicoesDia());
	}
	
	@Test
	public void testeMontarCardapio() throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
		Grupo g1 = new Grupo("Carboidratos");
		Grupo g2 = new Grupo("Verduras e Legumes");
		Grupo g3 = new Grupo("Frutas");
		Grupo g4 = new Grupo("Leite e derivados");
		Grupo g5 = new Grupo("Carnes e Ovos");
		Grupo g6 = new Grupo("Leguminosas e oleaginosas");
		Grupo g7 = new Grupo("Óleos e Gorduras");
		Grupo g8 = new Grupo("Açúcares e Doces");
		
		new Alimento("Pão", "gramas", g1);
		new Alimento("Arroz", "gramas", g1);
		new Alimento("Macarrão", "gramas", g1);
		new Alimento("Abóbora", "gramas", g2);
		new Alimento("Couve", "gramas", g2);
		new Alimento("Couve-flor", "gramas", g2);
		new Alimento("Alface", "gramas", g2);
		new Alimento("Abacaxi", "gramas", g3);
		new Alimento("Maçã", "gramas", g3);
		new Alimento("Laranja", "gramas", g3);
		new Alimento("Manteiga", "gramas", g4);
		new Alimento("Iogurte", "gramas", g4);
		new Alimento("Requeijão", "gramas", g4);
		new Alimento("Queijo", "gramas", g4);
		new Alimento("Carne de Sol", "gramas", g5);
		new Alimento("Carne moída", "gramas", g5);
		new Alimento("Cupim", "gramas", g5);
		new Alimento("Ovo", "gramas", g5);
		new Alimento("Feijão", "gramas", g6);
		new Alimento("Lentilha", "gramas", g6);
		new Alimento("Ervilha", "gramas", g6);
		new Alimento("Óleo de milho", "gramas", g7);
		new Alimento("Óleo de soja", "gramas", g7);
		new Alimento("Óleo de girassol", "gramas", g7);
		new Alimento("Azeites", "gramas", g7);
		new Alimento("Açúcar de cana", "gramas", g8);
		new Alimento("Açúcar mascavo", "gramas", g8);
		
		List<Grupo> d1 = Arrays.asList(g1, g2, g3);
		List<Grupo> d2 = Arrays.asList(g4, g5, g6);
		List<Grupo> d3 = Arrays.asList(g7, g8, g1);
		List<List<Grupo>> list = new ArrayList<List<Grupo>>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d2);
		list.add(d1);
		list.add(d2);
		list.add(d3);

		CardapioController.montarCardapio(list);
		
		assertEquals(Cardapio.getCardapioSemana().get(0).getRefeicoesDia().get(0).getAlimentos().get(0).getGrupo(), g1);
		assertEquals(Cardapio.getCardapioSemana().get(0).getRefeicoesDia().get(0).getAlimentos().get(1).getGrupo(), g2);
		assertEquals(Cardapio.getCardapioSemana().get(0).getRefeicoesDia().get(0).getAlimentos().get(2).getGrupo(), g3);
	}
	
	@Test
	public void testeMontarCardapio2() throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
		Grupo g1 = new Grupo("Carboidratos");
		Grupo g2 = new Grupo("Verduras e Legumes");
		Grupo g3 = new Grupo("Frutas");
		Grupo g4 = new Grupo("Leite e derivados");
		Grupo g5 = new Grupo("Carnes e Ovos");
		Grupo g6 = new Grupo("Leguminosas e oleaginosas");
		Grupo g7 = new Grupo("Óleos e Gorduras");
		Grupo g8 = new Grupo("Açúcares e Doces");
		
		new Alimento("Pão", "gramas", g1);
		new Alimento("Arroz", "gramas", g1);
		new Alimento("Macarrão", "gramas", g1);
		new Alimento("Abóbora", "gramas", g2);
		new Alimento("Couve", "gramas", g2);
		new Alimento("Couve-flor", "gramas", g2);
		new Alimento("Alface", "gramas", g2);
		new Alimento("Abacaxi", "gramas", g3);
		new Alimento("Maçã", "gramas", g3);
		new Alimento("Laranja", "gramas", g3);
		new Alimento("Manteiga", "gramas", g4);
		new Alimento("Iogurte", "gramas", g4);
		new Alimento("Requeijão", "gramas", g4);
		new Alimento("Queijo", "gramas", g4);
		new Alimento("Carne de Sol", "gramas", g5);
		new Alimento("Carne moída", "gramas", g5);
		new Alimento("Cupim", "gramas", g5);
		new Alimento("Ovo", "gramas", g5);
		new Alimento("Feijão", "gramas", g6);
		new Alimento("Lentilha", "gramas", g6);
		new Alimento("Ervilha", "gramas", g6);
		new Alimento("Óleo de milho", "gramas", g7);
		new Alimento("Óleo de soja", "gramas", g7);
		new Alimento("Óleo de girassol", "gramas", g7);
		new Alimento("Azeites", "gramas", g7);
		new Alimento("Açúcar de cana", "gramas", g8);
		new Alimento("Açúcar mascavo", "gramas", g8);
		
		List<Grupo> d1 = Arrays.asList(g1, g2, g3);
		List<Grupo> d2 = Arrays.asList(g4, g5, g6);
		List<Grupo> d3 = Arrays.asList(g7, g8, g1);
		List<List<Grupo>> list = new ArrayList<List<Grupo>>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d2);
		list.add(d1);
		list.add(d2);
		list.add(d3);

		CardapioController.montarCardapio(list);
		
		assertEquals(Cardapio.getCardapioSemana().get(6).getRefeicoesDia().get(0).getAlimentos().get(0).getGrupo(), g7);
		assertEquals(Cardapio.getCardapioSemana().get(6).getRefeicoesDia().get(0).getAlimentos().get(1).getGrupo(), g8);
		assertEquals(Cardapio.getCardapioSemana().get(6).getRefeicoesDia().get(0).getAlimentos().get(2).getGrupo(), g1);
	}
	
	@Test
	public void testeMontarCardapio3() throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
		Grupo g1 = new Grupo("Carboidratos");
		Grupo g2 = new Grupo("Verduras e Legumes");
		Grupo g3 = new Grupo("Frutas");
		Grupo g4 = new Grupo("Leite e derivados");
		Grupo g5 = new Grupo("Carnes e Ovos");
		Grupo g6 = new Grupo("Leguminosas e oleaginosas");
		Grupo g7 = new Grupo("Óleos e Gorduras");
		Grupo g8 = new Grupo("Açúcares e Doces");
		
		new Alimento("Pão", "gramas", g1);
		new Alimento("Arroz", "gramas", g1);
		new Alimento("Macarrão", "gramas", g1);
		new Alimento("Abóbora", "gramas", g2);
		new Alimento("Couve", "gramas", g2);
		new Alimento("Couve-flor", "gramas", g2);
		new Alimento("Alface", "gramas", g2);
		new Alimento("Abacaxi", "gramas", g3);
		new Alimento("Maçã", "gramas", g3);
		new Alimento("Laranja", "gramas", g3);
		new Alimento("Manteiga", "gramas", g4);
		new Alimento("Iogurte", "gramas", g4);
		new Alimento("Requeijão", "gramas", g4);
		new Alimento("Queijo", "gramas", g4);
		new Alimento("Carne de Sol", "gramas", g5);
		new Alimento("Carne moída", "gramas", g5);
		new Alimento("Cupim", "gramas", g5);
		new Alimento("Ovo", "gramas", g5);
		new Alimento("Feijão", "gramas", g6);
		new Alimento("Lentilha", "gramas", g6);
		new Alimento("Ervilha", "gramas", g6);
		new Alimento("Óleo de milho", "gramas", g7);
		new Alimento("Óleo de soja", "gramas", g7);
		new Alimento("Óleo de girassol", "gramas", g7);
		new Alimento("Azeites", "gramas", g7);
		new Alimento("Açúcar de cana", "gramas", g8);
		new Alimento("Açúcar mascavo", "gramas", g8);
		
		List<Grupo> d1 = Arrays.asList(g1, g2, g3);
		List<Grupo> d2 = Arrays.asList(g4, g5, g6);
		List<Grupo> d3 = Arrays.asList(g7, g8, g1);
		List<List<Grupo>> list = new ArrayList<List<Grupo>>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d2);
		list.add(d1);
		list.add(d2);
		list.add(d3);

		CardapioController.montarCardapio(list);
		
		assertEquals(Cardapio.getCardapioSemana().get(3).getRefeicoesDia().get(0).getAlimentos().get(0).getGrupo(), g4);
		assertEquals(Cardapio.getCardapioSemana().get(3).getRefeicoesDia().get(0).getAlimentos().get(1).getGrupo(), g5);
		assertEquals(Cardapio.getCardapioSemana().get(3).getRefeicoesDia().get(0).getAlimentos().get(2).getGrupo(), g6);
	}
	
	@Test (expected = CardapioInvalidoException.class)
	public void testeExcecaoCardapio() throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
		Grupo g1 = new Grupo("Carboidratos");
		Grupo g2 = new Grupo("Verduras e Legumes");
		Grupo g3 = new Grupo("Frutas");
		
		new Alimento("Pão", "gramas", g1);
		new Alimento("Abóbora", "gramas", g2);
		new Alimento("Couve", "gramas", g2);
		new Alimento("Couve-flor", "gramas", g2);
		new Alimento("Alface", "gramas", g2);
		new Alimento("Abacaxi", "gramas", g3);
		new Alimento("Maçã", "gramas", g3);
		new Alimento("Laranja", "gramas", g3);
		
		List<Grupo> d1 = Arrays.asList(g1, g2, g3);
		List<List<Grupo>> listaGruposSemana = new ArrayList<List<Grupo>>();
		listaGruposSemana.add(d1);
		listaGruposSemana.add(d1);
		listaGruposSemana.add(d1);
		listaGruposSemana.add(d1);
		listaGruposSemana.add(d1);
		listaGruposSemana.add(d1);
		listaGruposSemana.add(d1);

		CardapioController.montarCardapio(listaGruposSemana);
	}
	
	@Test (expected = CardapioOverflowException.class)
	public void testeUltrapassarMaximoCardapios() throws CardapioOverflowException, DadoIncompletoException {
		

		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		refeicoes.add(obterRefeicao());
		
		for (int i = 0; i < Cardapio.DIAS_DA_SEMANA.size(); i++) {
			Cardapio.addCardapioDia(new Cardapio(Cardapio.DIAS_DA_SEMANA.get(i), refeicoes));
		}
		
		assertEquals(Cardapio.getCardapioSemana().size(), Cardapio.DIAS_DA_SEMANA.size());
		
		Cardapio.addCardapioDia(new Cardapio("DiaInexistente", refeicoes));
		
	}
	
	
}
