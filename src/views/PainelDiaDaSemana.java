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
import java.awt.GridLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PainelDiaDaSemana extends JPanel {

	private JLabel lblDia;
	@SuppressWarnings("rawtypes")
	private JComboBox grupo1;
	@SuppressWarnings("rawtypes")
	private JComboBox grupo2;
	@SuppressWarnings("rawtypes")
	private JComboBox grupo3;
	
	public PainelDiaDaSemana(String dia) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(100, 100, 450, 300);
		
		criarComponentes(dia);
		adicionarComponentes();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void criarComponentes(String dia) {
		lblDia = new JLabel(dia);
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		
		grupo1 = new JComboBox(GrupoController.getNomesGrupos());
		grupo2 = new JComboBox(GrupoController.getNomesGrupos());
		grupo3 = new JComboBox(GrupoController.getNomesGrupos());

	}

	private void adicionarComponentes() {
		setLayout(new GridLayout(5, 1, 15, 10));
		add(lblDia);
		add(grupo1);
		add(grupo2);
		add(grupo3);

	}

	public List<Grupo> getListaGrupos() {
		
		List<Grupo> grupos = new ArrayList<>();
		
		grupos.add(GrupoController.obterDaLista(grupo1.getSelectedItem().toString()));
		grupos.add(GrupoController.obterDaLista(grupo2.getSelectedItem().toString()));
		grupos.add(GrupoController.obterDaLista(grupo3.getSelectedItem().toString()));
		
		return grupos;
		
	}	

}
