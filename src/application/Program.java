package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controllers.CardapioController;
import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

public class Program {

	public static void main(String[] args) throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
		Grupo.carregar();
//		Grupo g1 = new Grupo(1, "Carboidratos");
//		Grupo g2 = new Grupo(1, "Verduras e Legumes");
//		Grupo g3 = new Grupo(1, "Frutas");
//		Grupo g4 = new Grupo(1, "Leite e derivados");
//		Grupo g5 = new Grupo(1, "Carnes e Ovos");
//		Grupo g6 = new Grupo(1, "Leguminosas e oleaginosas");
//		Grupo g7 = new Grupo(1, "Óleos e Gorduras");
//		Grupo g8 = new Grupo(1, "Açúcares e Doces");
		Grupo.escrever();
		
		Alimento.carregar();
//		new Alimento("Pão", "gramas", g1);
//		new Alimento("Arroz", "gramas", g1);
//		new Alimento("Macarrão", "gramas", g1);
//		new Alimento("Abóbora", "gramas", g2);
//		new Alimento("Couve", "gramas", g2);
//		new Alimento("Couve-flor", "gramas", g2);
//		new Alimento("Alface", "gramas", g2);
//		new Alimento("Abacaxi", "gramas", g3);
//		new Alimento("Maçã", "gramas", g3);
//		new Alimento("Laranja", "gramas", g3);
//		new Alimento("Manteiga", "gramas", g4);
//		new Alimento("Iogurte", "gramas", g4);
//		new Alimento("Requeijão", "gramas", g4);
//		new Alimento("Queijo", "gramas", g4);
//		new Alimento("Carne de Sol", "gramas", g5);
//		new Alimento("Carne moída", "gramas", g5);
//		new Alimento("Cupim", "gramas", g5);
//		new Alimento("Ovo", "gramas", g5);
//		new Alimento("Feijão", "gramas", g6);
//		new Alimento("Lentilha", "gramas", g6);
//		new Alimento("Ervilha", "gramas", g6);
//		new Alimento("Óleo de milho", "gramas", g7);
//		new Alimento("Óleo de soja", "gramas", g7);
//		new Alimento("Óleo de girassol", "gramas", g7);
//		new Alimento("Azeites", "gramas", g7);
//		new Alimento("Açúcar de cana", "gramas", g8);
//		new Alimento("Açúcar mascavo", "gramas", g8);
		Alimento.escrever();
		
//		for (Alimento i : Alimento.getAllAlimentos()) {
//			System.out.println(i.getNome());
//			System.out.println(i.getMedida());
//			System.out.println(i.getGrupo().getNome());
//		}
//		
//		for (Grupo i : Grupo.getAllGrupos()) {
//			System.out.println(i.getAlimentos().size());
//			System.out.println(i.getId());
//			System.out.println(i.getNome());
//			for (Alimento a : i.getAlimentos()) {
//				System.out.println(a.getNome());
//			}
//		}
		Grupo g1 = Grupo.obterGrupo("Carboidratos");
		Grupo g2 = Grupo.obterGrupo("Verduras e Legumes");
		Grupo g3 = Grupo.obterGrupo("Frutas");
		Grupo g4 = Grupo.obterGrupo("Leite e derivados");
		Grupo g5 = Grupo.obterGrupo("Carnes e Ovos");
		Grupo g6 = Grupo.obterGrupo("Leguminosas e oleaginosas");
		Grupo g7 = Grupo.obterGrupo("Óleos e Gorduras");
		Grupo g8 = Grupo.obterGrupo("Açúcares e Doces");
		
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
		CardapioController.imprimeCardapio();
	}

}