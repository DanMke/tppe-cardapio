package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class PainelDiaDaSemanaCardapio extends JPanel{

	private JLabel lblSegunda;
	private JPanel panelAdicionar;
	private FlowLayout flowLayout;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnAdicionar;
	private JPanel panelAdicionados;
	private ArrayList<String> alimentos;

	public PainelDiaDaSemanaCardapio(String dia) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(100, 100, 450, 300);setSize(new Dimension(300, 400));
		
		alimentos = new ArrayList<String>();
		
		criarComponentes(dia);
		adicionarComponentes();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void criarComponentes(String dia) {
		lblSegunda = new JLabel(dia);
		lblSegunda.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panelAdicionar = new JPanel();
		panelAdicionar.setMaximumSize(new Dimension(300, 300));				

		flowLayout = (FlowLayout) panelAdicionar.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(50);
		
		panelAdicionados = new JPanel();
		
	}

	private void adicionarComponentes() {
		add(lblSegunda);
		add(panelAdicionar);
//		add(panelAdicionados);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		panelAdicionados.add(new JLabel("Grupo"));
//		panelAdicionados.validate();
//		panelAdicionados.repaint();
//		
//	}

}
