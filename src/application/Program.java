package application;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controllers.AlimentoController;
import controllers.CardapioController;
import controllers.GrupoController;
import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;
import views.JanelaMenu;

public class Program {

	public static void main(String[] args) throws DadoIncompletoException, CardapioInvalidoException, CardapioOverflowException {
//		Grupo g1 = new Grupo(1, "Carboidratos");
//		Grupo g2 = new Grupo(1, "Verduras e Legumes");
//		Grupo g3 = new Grupo(1, "Frutas");
//		Grupo g4 = new Grupo(1, "Leite e derivados");
//		Grupo g5 = new Grupo(1, "Carnes e Ovos");
//		Grupo g6 = new Grupo(1, "Leguminosas e oleaginosas");
//		Grupo g7 = new Grupo(1, "Óleos e Gorduras");
//		Grupo g8 = new Grupo(1, "Açúcares e Doces");
		
		
		GrupoController.carregar();
		Grupo g1 = new Grupo("Carboidratos");
		Grupo g2 = new Grupo("Verduras e Legumes");
		Grupo g3 = new Grupo("Frutas");
		Grupo g4 = new Grupo("Leite e derivados");
		Grupo g5 = new Grupo("Carnes e Ovos");
		Grupo g6 = new Grupo("Leguminosas e oleaginosas");
		Grupo g7 = new Grupo("Óleos e Gorduras");
		Grupo g8 = new Grupo("Açúcares e Doces");
		GrupoController.salvarNaLista(g1);
		GrupoController.salvarNaLista(g2);
		GrupoController.salvarNaLista(g3);
		GrupoController.salvarNaLista(g4);
		GrupoController.salvarNaLista(g5);
		GrupoController.salvarNaLista(g6);
		GrupoController.salvarNaLista(g7);
		GrupoController.salvarNaLista(g8);
		GrupoController.escrever();
		
		AlimentoController.carregar();
		Alimento al1 = new Alimento("Pão", "gramas", g1);
		Alimento al2 = new Alimento("Arroz", "gramas", g1);
		Alimento al3 = new Alimento("Macarrão", "gramas", g1);
		Alimento al4 = new Alimento("Abóbora", "gramas", g2);
		Alimento al5 = new Alimento("Couve", "gramas", g2);
		Alimento al6 = new Alimento("Couve-flor", "gramas", g2);
		Alimento al7 = new Alimento("Alface", "gramas", g2);
		Alimento al8 = new Alimento("Abacaxi", "gramas", g3);
		Alimento al9 = new Alimento("Maçã", "gramas", g3);
		Alimento al10 = new Alimento("Laranja", "gramas", g3);
		Alimento al11 = new Alimento("Manteiga", "gramas", g4);
		Alimento al12 = new Alimento("Iogurte", "gramas", g4);
		Alimento al13 = new Alimento("Requeijão", "gramas", g4);
		Alimento al14 = new Alimento("Queijo", "gramas", g4);
		Alimento al15 = new Alimento("Carne de Sol", "gramas", g5);
		Alimento al16 = new Alimento("Carne moída", "gramas", g5);
		Alimento al17 = new Alimento("Cupim", "gramas", g5);
		Alimento al18 = new Alimento("Ovo", "gramas", g5);
		Alimento al19 = new Alimento("Feijão", "gramas", g6);
		Alimento al20 = new Alimento("Lentilha", "gramas", g6);
		Alimento al21 = new Alimento("Ervilha", "gramas", g6);
		Alimento al22 = new Alimento("Óleo de milho", "gramas", g7);
		Alimento al23 = new Alimento("Óleo de soja", "gramas", g7);
		Alimento al24 = new Alimento("Óleo de girassol", "gramas", g7);
		Alimento al25 = new Alimento("Azeites", "gramas", g7);
		Alimento al26 = new Alimento("Açúcar de cana", "gramas", g8);
		Alimento al27 = new Alimento("Açúcar mascavo", "gramas", g8);
		AlimentoController.salvarNaLista(al1);
		AlimentoController.salvarNaLista(al2);
		AlimentoController.salvarNaLista(al3);
		AlimentoController.salvarNaLista(al4);
		AlimentoController.salvarNaLista(al5);
		AlimentoController.salvarNaLista(al6);
		AlimentoController.salvarNaLista(al7);
		AlimentoController.salvarNaLista(al8);
		AlimentoController.salvarNaLista(al9);
		AlimentoController.salvarNaLista(al10);
		AlimentoController.salvarNaLista(al11);
		AlimentoController.salvarNaLista(al12);
		AlimentoController.salvarNaLista(al13);
		AlimentoController.salvarNaLista(al14);
		AlimentoController.salvarNaLista(al15);
		AlimentoController.salvarNaLista(al16);
		AlimentoController.salvarNaLista(al17);
		AlimentoController.salvarNaLista(al18);
		AlimentoController.salvarNaLista(al19);
		AlimentoController.salvarNaLista(al20);
		AlimentoController.salvarNaLista(al21);
		AlimentoController.salvarNaLista(al22);
		AlimentoController.salvarNaLista(al23);
		AlimentoController.salvarNaLista(al24);
		AlimentoController.salvarNaLista(al25);
		AlimentoController.salvarNaLista(al26);
		AlimentoController.salvarNaLista(al27);
		AlimentoController.escrever();
		
//		for (Alimento i : Alimento.getAllAlimentos()) {
//			System.out.println(i.getNome());
//			System.out.println(i.getMedida());
//			System.out.println(i.getGrupo().getNome());
//		}
		
//		for (Grupo i : Grupo.getAllGrupos()) {
//			System.out.println(i.getAlimentos().size());
//			System.out.println(i.getNome());
//			for (Alimento a : i.getAlimentos()) {
//				System.out.println(a.getNome());
//			}
//		}
		
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
		
		CardapioController.escrever();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMenu frame = new JanelaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}