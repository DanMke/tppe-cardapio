package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class PainelDiaDaSemanaCardapio extends JPanel{

	private JLabel lblSegunda;
	private JPanel panelAdicionados;
	private JPanel panelAlimentos;

	public PainelDiaDaSemanaCardapio(String dia) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(100, 100, 450, 300);setSize(new Dimension(300, 400));
		
		criarComponentes(dia);
		adicionarComponentes();
		
	}
	
	private void criarComponentes(String dia) {
		lblSegunda = new JLabel(dia);
		lblSegunda.setAlignmentX(Component.CENTER_ALIGNMENT);		
		panelAdicionados = new JPanel();
		panelAlimentos = new JPanel();
		panelAlimentos.setLayout(new BoxLayout(panelAlimentos, BoxLayout.Y_AXIS));
	}

	private void adicionarComponentes() {
		panelAdicionados.add(panelAlimentos);
		add(lblSegunda);
		add(panelAdicionados);
	}

	public void setAlimentos(ArrayList<String> alimentos) {
		for(int i = 0; i < alimentos.size(); i++) {
			JLabel label = new JLabel(alimentos.get(i));
			label.setHorizontalAlignment(JLabel.CENTER);
			panelAlimentos.add(label);		
		}		
		panelAdicionados.validate();
		panelAdicionados.repaint();
	}

}
