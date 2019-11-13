package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controllers.AlimentoController;
import controllers.GrupoController;
import models.Alimento;
import models.Grupo;

@SuppressWarnings("serial")
public class JanelaAlimento extends JPanel {
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
    	
    	criarComponentes();
    	adicionarComponentes();
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void criarComponentes() {
		
		comandoGrupos = new JLabel(getTextoComandoGrupo());
		grupos = new JComboBox(GrupoController.getNomesGrupos());
		comandoNome = new JLabel(getTextoComandoAlimento());
		nome = new JTextField();
		comandoMedida = new JLabel(getTextoComandoMedida());
		medida = new JTextField();
		
		if(!criar) {
			comandoAlimentos = new JLabel("Escolha o alimento que deseja editar");	
			alimentos = new JComboBox(AlimentoController.getNomesAlimentos());
			
			alimentos.addActionListener (new ActionListener () {
			    public void actionPerformed(ActionEvent e) {
			        Alimento alimento = AlimentoController.obterDaLista(
			        		alimentos.getSelectedItem().toString());
			        nome.setText(alimento.getNome());
			        medida.setText(alimento.getMedida());
			        grupos.setSelectedItem(alimento.getGrupo().getNome());
			        
			    }
			});
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

	public String getNome() {
		return nome.getText();
	}

	public String getMedida() {
		return medida.getText();
	}
	
	public String getNomeAtual() {
		return alimentos.getSelectedItem().toString();
	}
	
	public String getNomeGrupo() {
		return grupos.getSelectedItem().toString();
	}
	
	private String getTextoComandoGrupo() {
		if(criar)
			return "Escolha o grupo do alimento";
		else
			return "Escolha o novo grupo do alimento";
		
	}
	
	private String getTextoComandoAlimento() {
		if(criar)
			return "Digite o nome do alimento";
		else
			return "Digite o novo nome do alimento";
	}
	
	private String getTextoComandoMedida() {
		if(criar)
			return "Digite o nome da medida usada por esse alimento";
		else
			return "Digite o novo nome da medida usada por esse alimento";
	}
}