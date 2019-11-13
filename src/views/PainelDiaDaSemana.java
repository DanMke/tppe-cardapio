package views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
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
	private List<String> listaGrupos;

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
		
		panelAdicionar = new JPanel();
		flowLayout = (FlowLayout) panelAdicionar.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(50);
		panelAdicionar.setMaximumSize(new Dimension(300, 300));
		
		// TODO fazer método que retorne uma String[] com todos os nomes de grupos
		String[] grupos = {"Carboidrato", "Proteína"};
		comboBox = new JComboBox(grupos);
		
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
		// TODO criar método que envie nome String e retorne o grupo
		String nomeGrupo = comboBox.getSelectedItem().toString();
		//listaGrupos.add(Grupo.getGrupo(nomeGrupo));
		panelAdicionados.add(new JLabel(nomeGrupo));
		panelAdicionados.validate();
		panelAdicionados.repaint();		
	}

}
