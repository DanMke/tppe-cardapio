package views;

import java.awt.Dimension;

import javax.swing.*;

import controllers.AlimentoController;
import controllers.GrupoController;

@SuppressWarnings("serial")
public class JanelaAlimento extends JPanel {
	private GrupoController grupoController;
	private AlimentoController alimentoController;
    
	@SuppressWarnings("rawtypes")
	private JComboBox grupos;
	@SuppressWarnings("rawtypes")
	private JComboBox alimentos;	
	private JTextField nome;
	private JTextField medida;
	private JLabel comandoNome;
	private JLabel comandoGrupos;
	private JLabel comandoMedida;
	private JLabel comandoAlimentos;
	
	private boolean criar;
   
    public JanelaAlimento(boolean criar) {
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
    	this.criar = criar;
    	grupoController = new GrupoController();
    	
    	criarComponentes();
    	adicionarComponentes();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void criarComponentes() {
		
		comandoGrupos = new JLabel("Escolha o grupo do alimento");
		grupos = new JComboBox(grupoController.getNomesGrupos());
		comandoNome = new JLabel("Digite o nome do alimento");
		nome = new JTextField();
		comandoMedida = new JLabel("Digite o nome da medida usada por esse alimento");
		medida = new JTextField();
//		TODO Criar esse método na controller
//		alimentos = new JComboBox(alimentoController.getAlimentos());
		
		if(!criar) {
			comandoAlimentos = new JLabel("Escolha o alimento que deseja editar");	
			String[] listaTemp = {"Feijão", "Arroz", "Batata", "Alface"};
			alimentos = new JComboBox(listaTemp);
		}
	}

	private void adicionarComponentes() {
		if(!criar) {
			add(Box.createRigidArea(new Dimension(10,30)));
			add(comandoAlimentos);
			add(Box.createRigidArea(new Dimension(10,30)));
			add(alimentos);
		}
		add(Box.createRigidArea(new Dimension(10,30)));
		add(comandoGrupos);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(grupos);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(comandoNome);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(nome);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(comandoMedida);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(medida);
		add(Box.createRigidArea(new Dimension(10,30)));
		
	}

	@SuppressWarnings("unchecked")
	public JComboBox<String> getGrupos() {
		return grupos;
	}

	public JTextField getNome() {
		return nome;
	}

	public JTextField getMedida() {
		return medida;
	}
}