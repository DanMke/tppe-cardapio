package views;

import java.awt.Dimension;

import javax.swing.*;

import controllers.GrupoController;

@SuppressWarnings("serial")
public class JanelaCriarAlimento extends JPanel {
	private GrupoController grupoController;
    private JLabel comandoGrupos;
    
	@SuppressWarnings("rawtypes")
	private JComboBox grupos;
	private JLabel comandoNome;
    private JTextField novoNome;
   
    public JanelaCriarAlimento() {
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
		novoNome = new JTextField();		
	}

	private void adicionarComponentes() {
		add(Box.createRigidArea(new Dimension(10,30)));
		add(comandoGrupos);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(grupos);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(comandoNome);
		add(Box.createRigidArea(new Dimension(10,30)));
		add(novoNome);
		add(Box.createRigidArea(new Dimension(10,30)));
		
	}


}