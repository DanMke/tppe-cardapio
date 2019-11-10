package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.junit.Test;

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
				
		return new Refeicao(nome, grupos, alimentos);
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
	
	@Test (expected = CardapioOverflowException.class)
	public void testeUltrapassarMaximoCardapios() {
		

		List<Refeicao> refeicoes = new ArrayList<Refeicao>();
		refeicoes.add(obterRefeicao());
		
		for (int i = 0; i < Cardapio.DIAS_DA_SEMANA.size(); i++) {
			Cardapio.addCardapioDia(new Cardapio(refeicoes));
		}
		
		assertEquals(Cardapio.getCardapioSemana().size(), Cardapio.DIAS_DA_SEMANA.size());
		
		Cardapio.addCardapioDia(new Cardapio(refeicoes));
		
	}
	
	
}
