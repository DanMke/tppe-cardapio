package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import models.Alimento;
import models.Cardapio;
import models.Grupo;
import models.Refeicao;

public class CardapioController {
	public static final int NUM_REFEICOES_DIA = 3;
	
	public static void montarCardapio(List<List<Grupo>> gruposInput) throws CardapioInvalidoException, CardapioOverflowException {
		
		Cardapio.clearCardapioSemana();
		
		List<Alimento> alimentosDiaAnterior = new ArrayList<Alimento>();
		
		for (int i = 0; i < Cardapio.DIAS_DA_SEMANA.size(); i++) {
			
			List<Grupo> gruposDia = gruposInput.get(i);
		
			List<Refeicao> refeicoesDia = new ArrayList<Refeicao>();
			List<Alimento> alimentosDiaAtual = new ArrayList<Alimento>();
			Map<String, Integer> frequenciasAlimentos = new LinkedHashMap<String, Integer>();
			
			for (int j = 0; j < NUM_REFEICOES_DIA; j++) {
				
				List<Alimento> alimentosRefeicao = new ArrayList<Alimento>();
				
				for (Grupo g : gruposDia) {
					
					List<Alimento> alimentosGrupo = g.getAlimentos();
					
					List<Integer> indices = new ArrayList<Integer>();
					for(int w = 0; w < alimentosGrupo.size(); w++) {						
						indices.add(w);
					}
					
					Collections.shuffle(indices);
					
					Alimento alimentoSelecionado = null;
					for(Integer indiceAleatorio : indices) {
					
						alimentoSelecionado = alimentosGrupo.get(indiceAleatorio);
						
						if (frequenciasAlimentos.containsKey(alimentoSelecionado.getNome()) == false) {
							frequenciasAlimentos.put(alimentoSelecionado.getNome(), 0);
						}
						
						if (alimentosDiaAnterior.contains(alimentoSelecionado) == false && frequenciasAlimentos.get(alimentoSelecionado.getNome()) < 2) {
							break;
						} else if(indices.indexOf(indiceAleatorio) == indices.size() - 1) {
							throw new CardapioInvalidoException("Não foi possível montar o cardápio");
						}
					}
					
					alimentosRefeicao.add(alimentoSelecionado);
					alimentosDiaAtual.add(alimentoSelecionado);
					
					int valor = frequenciasAlimentos.get(alimentoSelecionado.getNome());
					valor++;
					frequenciasAlimentos.put(alimentoSelecionado.getNome(), valor);
				
				}
				
				refeicoesDia.add(new Refeicao(Cardapio.REFEICOES.get(j), alimentosRefeicao));
			}
			alimentosDiaAnterior.clear();
			alimentosDiaAnterior.addAll(alimentosDiaAtual);
			
			Cardapio.addCardapioDia(new Cardapio(refeicoesDia));			
		}	
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
