package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Cardapio;
import models.Grupo;
import models.Refeicao;

public class MontagemCardapio {
	
	List<Alimento> alimentosDiaAnterior;
	List<Grupo> gruposDia;
	List<Refeicao> refeicoesDia;
	List<Alimento> alimentosDiaAtual;
	Map<String, Integer> frequenciasAlimentos;
	List<Alimento> alimentosRefeicao;
	List<Alimento> alimentosGrupo;
	List<Integer> indices;
	Alimento alimentoSelecionado;
	Integer valorParaIncrementar;
	
	public MontagemCardapio() {
		
	}
	
	void computar(List<List<Grupo>> gruposInput) throws CardapioInvalidoException, CardapioOverflowException, DadoIncompletoException {
		Cardapio.clearCardapioSemana();
		
		alimentosDiaAnterior = new ArrayList<Alimento>();
		
		for (int i = 0; i < Cardapio.DIAS_DA_SEMANA.size(); i++) {
			
			gruposDia = gruposInput.get(i);
		
			refeicoesDia = new ArrayList<Refeicao>();
			alimentosDiaAtual = new ArrayList<Alimento>();
			frequenciasAlimentos = new LinkedHashMap<String, Integer>();
			
			for (int j = 0; j < CardapioController.NUM_REFEICOES_DIA; j++) {
				
				alimentosRefeicao = new ArrayList<Alimento>();
				
				for (Grupo g : gruposDia) {
					
					alimentosGrupo = g.getAlimentos();
					
					indices = new ArrayList<Integer>();
					for (int w = 0; w < alimentosGrupo.size(); w++) {						
						indices.add(w);
					}
					
					Collections.shuffle(indices);
					
					alimentoSelecionado = null;
					for (Integer indiceAleatorio : indices) {
					
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
					
					valorParaIncrementar = frequenciasAlimentos.get(alimentoSelecionado.getNome());
					valorParaIncrementar++;
					frequenciasAlimentos.put(alimentoSelecionado.getNome(), valorParaIncrementar);
				
				}
				
				refeicoesDia.add(new Refeicao(Cardapio.REFEICOES.get(j), alimentosRefeicao));
			}
			alimentosDiaAnterior.clear();
			alimentosDiaAnterior.addAll(alimentosDiaAtual);
			
			Cardapio.addCardapioDia(new Cardapio(Cardapio.DIAS_DA_SEMANA.get(i), refeicoesDia));			
		}
	}

}
