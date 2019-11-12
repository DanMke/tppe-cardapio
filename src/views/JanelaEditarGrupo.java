package views;

import java.awt.Dimension;

import javax.swing.*;

import controllers.GrupoController;

@SuppressWarnings("serial")
public class JanelaEditarGrupo extends JPanel {
    private JLabel comandoGrupos;
	@SuppressWarnings("rawtypes")
	private JComboBox grupos;
	private JLabel comandoNome;
    private JTextField novoNome;
   
    public JanelaEditarGrupo() {
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
    	criarComponentes();
    	adicionarComponentes();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void criarComponentes() {
		comandoGrupos = new JLabel("Escolha o grupo que deseja editar:");
		grupos = new JComboBox(GrupoController.getNomesGrupos());
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
	
	public String getNovoNome() {
		return novoNome.getText();
	}
	
	public String getNomeAtual() {
		return grupos.getSelectedItem().toString();
	}


}