package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Alimento;
import models.Cardapio;
import models.Grupo;
import models.Refeicao;

public class CardapioController {
	public static final int NUM_REFEICOES_DIA = 3;
	
	public static void montarCardapio(List<List<Grupo>> gruposInput) {
		
		Alimento a1 = gruposInput.get(0).get(0).getAlimentos().get(0);
		Alimento a2 = gruposInput.get(0).get(1).getAlimentos().get(0);
		Alimento a3 = gruposInput.get(0).get(2).getAlimentos().get(0);
		
		List<Alimento> alimentos = new ArrayList<Alimento>();
		
		alimentos.add(a1);
		alimentos.add(a2);
		alimentos.add(a3);
		
		
		Refeicao refeicao1 = new Refeicao("Almoço", alimentos);
		Refeicao refeicao2 = new Refeicao("Janta", alimentos);
		
		
		List<Refeicao> refeicoesDia = new ArrayList<Refeicao>();
		
		refeicoesDia.add(refeicao1);
		refeicoesDia.add(refeicao2);
		
		Cardapio.addCardapioDia(new Cardapio(refeicoesDia));
	}
	
	
	public static void imprimeCardapio() {
		for (Cardapio cardapio : Cardapio.getCardapioSemana()) {
			for (Refeicao refeicao : cardapio.getRefeicoesDia()) {
				System.out.println("%%%" + refeicao.getNome() + "%%%");
				for (Alimento alimento : refeicao.getAlimentos()) {
					System.out.println(alimento.getNome());
				}
				System.out.println("---");
			}
			System.out.println("###");
		}
	}
}
