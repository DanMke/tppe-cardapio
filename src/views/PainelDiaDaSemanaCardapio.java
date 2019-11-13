package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
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
		panelAlimentos.setLayout(new BoxLayout(panelAlimentos, BoxLayout.X_AXIS));
	}

	private void adicionarComponentes() {
		panelAdicionados.add(panelAlimentos);
		add(lblSegunda);
		add(panelAdicionados);
	}
	
	// TODO excluir esse método (não divide em refeições)
	public void setAlimentos(ArrayList<String> alimentos) {
		for(int i = 0; i < alimentos.size(); i++) {
			JLabel label = new JLabel(alimentos.get(i));
			label.setHorizontalAlignment(JLabel.CENTER);
			panelAlimentos.add(label);		
		}		
		panelAdicionados.validate();
		panelAdicionados.repaint();
	}
	
	// TODO dividir panelAlimentos em 2 (para as duas refeições)
	// TODO criar metodo que insere uma lista de alimentos em cada refeição
	// TODO chamar esse metodo em JanelaCardapio enviando a lista (utilizar o atributo 'cardapio')

}
