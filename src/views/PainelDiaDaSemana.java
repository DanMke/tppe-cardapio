package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import controllers.GrupoController;
import exceptions.DadoIncompletoException;
import models.Grupo;

import java.awt.Color;

@SuppressWarnings("serial")
public class PainelDiaDaSemana extends JPanel implements ActionListener {

	private JLabel lblDia;
	private JPanel panelAdicionar;
	private FlowLayout flowLayout;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnAdicionar;
	private JPanel panelAdicionados;
	private List<Grupo> listaGrupos;

	public PainelDiaDaSemana(String dia) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(100, 100, 450, 300);
		setSize(new Dimension(300, 400));
		
		criarComponentes(dia);
		adicionarComponentes();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void criarComponentes(String dia) {
		lblDia = new JLabel(dia);
		lblDia.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		listaGrupos = new ArrayList();
		
		panelAdicionar = new JPanel();
		flowLayout = (FlowLayout) panelAdicionar.getLayout();
//		flowLayout.setVgap(10);
//		flowLayout.setHgap(50);
		panelAdicionar.setMaximumSize(new Dimension(300, 300));
		
		comboBox = new JComboBox(GrupoController.getNomesGrupos());
		
		btnAdicionar = new JButton("+");
		btnAdicionar.addActionListener(this);
		panelAdicionados = new JPanel();
		
	}

	private void adicionarComponentes() {
		add(lblDia);
		add(panelAdicionar);
		panelAdicionar.add(comboBox);
		panelAdicionar.add(btnAdicionar);		
		add(panelAdicionados);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String nomeGrupo = comboBox.getSelectedItem().toString();
		try {
			listaGrupos.add(GrupoController.obterGrupo(nomeGrupo));
		} catch (DadoIncompletoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		panelAdicionados.add(new JLabel(nomeGrupo));
		panelAdicionados.validate();
		panelAdicionados.repaint();		
	}

}
