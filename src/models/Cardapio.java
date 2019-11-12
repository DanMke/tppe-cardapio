package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.CardapioOverflowException;

public class Cardapio {
	
	public static final List<String> DIAS_DA_SEMANA = Arrays.asList("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
	public static final List<String> REFEICOES = Arrays.asList("Desjejum", "Almoço", "Jantar");
	
	private static List<Cardapio> cardapioSemana = new ArrayList<>();	
	
	private List<Refeicao> refeicoesDia = new ArrayList<>();
	
	public Cardapio(List<Refeicao> refeicoesDia) {
		this.refeicoesDia = refeicoesDia;
	}
	
	public List<Refeicao> getRefeicoesDia() {
		return refeicoesDia;
	}

	public void setRefeicoesDia(List<Refeicao> refeicoesDia) {
		this.refeicoesDia = refeicoesDia;
	}

	public static void addCardapioDia(Cardapio cardapio) throws CardapioOverflowException {
		if (cardapioSemana.size() + 1 > 7) {
			throw new CardapioOverflowException("Excedido dias da semana");
		}
		cardapioSemana.add(cardapio);	
	}
	
	public static List<Cardapio> getCardapioSemana() {
		return cardapioSemana;
	}
	
	public static void clearCardapioSemana() {
		cardapioSemana.clear();
	}
	
}
