package views;

import java.awt.Dimension;

import javax.swing.*;

import controllers.GrupoController;

@SuppressWarnings("serial")
public class JanelaAlimento extends JPanel {
	private GrupoController grupoController;
    
	@SuppressWarnings("rawtypes")
	private JComboBox grupos;
	private JTextField nome;
	private JTextField medida;
	private JLabel comandoNome;
	private JLabel comandoGrupos;
	private JLabel comandoMedida;
   
    public JanelaAlimento() {
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
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
	}

	private void adicionarComponentes() {
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