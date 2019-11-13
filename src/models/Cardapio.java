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
	
	private String dia;
	private List<Refeicao> refeicoesDia = new ArrayList<>();
	
	public Cardapio(String dia, List<Refeicao> refeicoesDia) throws DadoIncompletoException {
		verificaDados(dia, refeicoesDia);
		this.dia = dia;
		this.refeicoesDia = refeicoesDia;
	}
	
	private void verificaDados(String dia, List<Refeicao> refeicoesDia) throws DadoIncompletoException {
		if (dia == null || dia.equals("") || refeicoesDia == null) {
			StringBuilder builder = criaMensagemErro(dia, refeicoesDia);
			throw new DadoIncompletoException(builder.toString());
		}
	}

	private StringBuilder criaMensagemErro(String dia, List<Refeicao> refeicoesDia) {
		StringBuilder builder = new StringBuilder(); 
		
		builder.append("Dados informados para Cardapio estão incompletos:\n");
		builder.append(dia == null || dia == "" ? "Dia: " + dia + "\n" : "");
		builder.append(refeicoesDia == null ? "Refeicoes: " + refeicoesDia + "\n" : "");
		
		return builder;
	}
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) throws DadoIncompletoException {
		
		if(dia == null || dia == "") {
			throw new DadoIncompletoException("Campo dia não pode ser vazio");
		}
		
		this.dia = dia;
	}

	public List<Refeicao> getRefeicoesDia() {
		return refeicoesDia;
	}

	public void setRefeicoesDia(List<Refeicao> refeicoesDia) throws DadoIncompletoException {
		
		if(refeicoesDia == null) {
			throw new DadoIncompletoException("Campo refeicoesDia não pode ser vazio");
		}
		
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
