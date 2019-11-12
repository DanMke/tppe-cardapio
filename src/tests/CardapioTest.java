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
	
	Refeicao obterRefeicao() {
		
		Random r = new Random();
		
		String nome = Cardapio.REFEICOES.get(r.nextInt(Cardapio.REFEICOES.size()));
		
		List<Grupo> grupos = new ArrayList<Grupo>();
		List<Alimento> alimentos = new ArrayList<Alimento>();
		
		try {
			grupos.add(Grupo.obterGrupo(total_grupos.toString()));
			total_grupos++;
			
			alimentos.add(Alimento.obterAlimento(
					total_alimentos.toString(),
					total_alimentos.toString(), 
					grupos.get(grupos.size() - 1
			)));
			total_alimentos++;
			
		} catch (DadoIncompletoException e) {
			// Do nothing
		}
				
		return new Refeicao(nome, alimentos);
	}

	@Test
	public void testeInstanciacaoCardapio() {
		
		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		for (int i = 0; i < 12; i++) {
			refeicoes.add(obterRefeicao());
		}
		
		Cardapio c = new Cardapio(refeicoes);
		assertEquals(refeicoes, c.getRefeicoesDia());
	}
	
	@Test
	public void testeMontarCardapio() throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
		Grupo g1 = Grupo.obterGrupo("Carboidratos");
		Grupo g2 = Grupo.obterGrupo("Verduras e Legumes");
		Grupo g3 = Grupo.obterGrupo("Frutas");
		Grupo g4 = Grupo.obterGrupo("Leite e derivados");
		Grupo g5 = Grupo.obterGrupo("Carnes e Ovos");
		Grupo g6 = Grupo.obterGrupo("Leguminosas e oleaginosas");
		Grupo g7 = Grupo.obterGrupo("Óleos e Gorduras");
		Grupo g8 = Grupo.obterGrupo("Açúcares e Doces");
		
        Alimento.obterAlimento("Pão", "gramas", g1);
		Alimento.obterAlimento("Arroz", "gramas", g1);
		Alimento.obterAlimento("Macarrão", "gramas", g1);
		Alimento.obterAlimento("Abóbora", "gramas", g2);
		Alimento.obterAlimento("Couve", "gramas", g2);
		Alimento.obterAlimento("Couve-flor", "gramas", g2);
		Alimento.obterAlimento("Alface", "gramas", g2);
		Alimento.obterAlimento("Abacaxi", "gramas", g3);
		Alimento.obterAlimento("Maçã", "gramas", g3);
		Alimento.obterAlimento("Laranja", "gramas", g3);
		Alimento.obterAlimento("Manteiga", "gramas", g4);
		Alimento.obterAlimento("Iogurte", "gramas", g4);
		Alimento.obterAlimento("Requeijão", "gramas", g4);
		Alimento.obterAlimento("Queijo", "gramas", g4);
		Alimento.obterAlimento("Carne de Sol", "gramas", g5);
		Alimento.obterAlimento("Carne moída", "gramas", g5);
		Alimento.obterAlimento("Cupim", "gramas", g5);
		Alimento.obterAlimento("Ovo", "gramas", g5);
		Alimento.obterAlimento("Feijão", "gramas", g6);
		Alimento.obterAlimento("Lentilha", "gramas", g6);
		Alimento.obterAlimento("Ervilha", "gramas", g6);
		Alimento.obterAlimento("Óleo de milho", "gramas", g7);
		Alimento.obterAlimento("Óleo de soja", "gramas", g7);
		Alimento.obterAlimento("Óleo de girassol", "gramas", g7);
		Alimento.obterAlimento("Azeites", "gramas", g7);
		Alimento.obterAlimento("Açúcar de cana", "gramas", g8);
		Alimento.obterAlimento("Açúcar mascavo", "gramas", g8);
		
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
	
	@Test (expected = CardapioOverflowException.class)
	public void testeUltrapassarMaximoCardapios() throws CardapioOverflowException {
		

		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		refeicoes.add(obterRefeicao());
		
		for (int i = 0; i < Cardapio.DIAS_DA_SEMANA.size(); i++) {
			Cardapio.addCardapioDia(new Cardapio(refeicoes));
		}
		
		assertEquals(Cardapio.getCardapioSemana().size(), Cardapio.DIAS_DA_SEMANA.size());
		
		Cardapio.addCardapioDia(new Cardapio(refeicoes));
		
	}
	
	
}
