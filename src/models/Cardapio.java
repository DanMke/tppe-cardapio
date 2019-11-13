package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;

public class Cardapio {
	
	public static final List<String> DIAS_DA_SEMANA = Arrays.asList("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
	public static final List<String> REFEICOES = Arrays.asList("Almoço", "Jantar");
	
	private static List<Cardapio> cardapioSemana = new ArrayList<>();	
	
	private String day;
	private List<Refeicao> refeicoesDia = new ArrayList<>();
	
	public Cardapio(String day, List<Refeicao> refeicoesDia) throws DadoIncompletoException {
		verificaDados(day, refeicoesDia);
		this.day = day;
		this.refeicoesDia = refeicoesDia;
	}
	
	private void verificaDados(String nome, List<Refeicao> refeicoesDia) throws DadoIncompletoException {
		if (nome == null || nome.equals("") || refeicoesDia == null) {
			StringBuilder builder = criaMensagemErro(nome, refeicoesDia);
			throw new DadoIncompletoException(builder.toString());
		}
	}

	private StringBuilder criaMensagemErro(String nome, List<Refeicao> refeicoesDia) {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("Dados informados para Grupo estão incompletos:\n");
		builder.append(nome == null || nome == "" ? "Nome: " + nome + "\n" : "");
		builder.append(refeicoesDia == null ? "Refeicoes: " + refeicoesDia + "\n" : "");
		
		return builder;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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
