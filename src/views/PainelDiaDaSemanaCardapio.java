package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.border.LineBorder;

import controllers.CardapioController;
import models.Alimento;
import models.Cardapio;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PainelDiaDaSemanaCardapio extends JPanel{

	private JLabel lblDia;
	private JPanel panelAlmoco;
	private JPanel panelJantar;
	private JLabel lblAlmoco;
	private JLabel lblJantar;
	private String dia;

	public PainelDiaDaSemanaCardapio(String dia) {
		this.dia = dia;
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(100, 100, 450, 300);setSize(new Dimension(300, 400));
		
		criarComponentes();
		adicionarComponentes();
		pegarAlmoco();
		pegarJantar();
		
	}

	private void criarComponentes() {
		lblDia = new JLabel(dia);
		lblDia.setForeground(Color.RED);
		lblDia.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelAlmoco = new JPanel();
		lblAlmoco = new JLabel("Almoço");
		lblAlmoco.setForeground(Color.BLUE);
		lblAlmoco.setHorizontalAlignment(SwingConstants.CENTER);
		panelJantar = new JPanel();
		lblJantar = new JLabel("Jantar");
		lblJantar.setForeground(Color.BLUE);
		lblJantar.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void adicionarComponentes() {
		add(lblDia);
		add(panelAlmoco);
		add(panelJantar);
		panelAlmoco.setLayout(new GridLayout(4, 1, 0, 5));
		panelAlmoco.add(lblAlmoco);
		panelJantar.setLayout(new GridLayout(4, 1, 0, 5));
		panelJantar.add(lblJantar);
	}
	
	private void pegarJantar() {
		List<Alimento> alimentos = CardapioController.getAlimentosRefeicaoDia(Cardapio.REFEICOES.get(1), dia);
		
		for (Alimento alimento : alimentos) {
			JLabel lblAlimento = new JLabel(alimento.getNome());
			lblAlimento.setHorizontalAlignment(SwingConstants.CENTER);
			panelJantar.add(lblAlimento);
		}
	}

	private void pegarAlmoco() {
		List<Alimento> alimentos = CardapioController.getAlimentosRefeicaoDia(Cardapio.REFEICOES.get(0), dia);
		
		for (Alimento alimento : alimentos) {
			JLabel lblAlimento = new JLabel(alimento.getNome());
			lblAlimento.setHorizontalAlignment(SwingConstants.CENTER);
			panelAlmoco.add(lblAlimento);
		}
		
	}
	

}
