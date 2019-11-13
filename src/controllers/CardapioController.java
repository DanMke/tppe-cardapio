package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Cardapio;
import models.Grupo;
import models.Refeicao;

public class CardapioController {

	public final static int NUM_REFEICOES_DIA = 2;
	
	public static void montarCardapio(List<List<Grupo>> gruposInput) throws CardapioInvalidoException, CardapioOverflowException, DadoIncompletoException {
		new MontagemCardapio().computar(gruposInput);
	}
	
	public static void escrever() {
		
		OutputStream os = null;
		String s = "";
		try {
			os = new FileOutputStream(new File("cardapio.txt"));
			
			for (Cardapio cardapio : Cardapio.getCardapioSemana()) {
				s = cardapio.getDia() + "\n";
				os.write(s.getBytes());
				for (Refeicao refeicao : cardapio.getRefeicoesDia()) {
					s = refeicao.getNome() + "\n";
					os.write(s.getBytes());
					for (Alimento a : refeicao.getAlimentos()) {
						s = a.getNome() + "%" + a.getMedida() + "%" + a.getGrupo().getNome() + "\n";
						os.write(s.getBytes());
					}
				}
				
			}
		
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
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
	
	public static List<Alimento> getAlimentosRefeicaoDia(String refeicao, String dia) {
		for (Cardapio cardapio : Cardapio.getCardapioSemana()) {
			if(cardapio.getDia().equals(dia)) {
				for (Refeicao ref : cardapio.getRefeicoesDia()) {
					if (ref.getNome().equals(refeicao)) 
						return ref.getAlimentos();
				}
			}
		}
		return null;
	}
}
