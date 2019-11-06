package views;

import java.awt.Dimension;

import javax.swing.*;

import controllers.GrupoController;

@SuppressWarnings("serial")
public class JanelaEditarGrupo extends JPanel {
	private GrupoController controller;
    private JLabel comandoGrupos;
	@SuppressWarnings("rawtypes")
	private JComboBox grupos;
	private JLabel comandoNome;
    private JTextField novoNome;
   
    public JanelaEditarGrupo() {
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
    	controller = new GrupoController();
    	
    	criarComponentes();
    	adicionarComponentes();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void criarComponentes() {
		comandoGrupos = new JLabel("Escolha o grupo que deseja editar:");
		grupos = new JComboBox(controller.getNomesGrupos());
		comandoNome = new JLabel("Digite o novo nome");
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