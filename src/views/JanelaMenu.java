package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.AlimentoController;
import controllers.EditarAlimentoParameter;
import controllers.GrupoController;
import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;
import java.awt.Component;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class JanelaMenu extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton criarGrupo;
	private JButton editarGrupo;
	private JButton criarAlimento;
	private JButton editarAlimento;
	private JButton montarCardapio;
	
	public JanelaMenu() {
		setTitle("Montador de cardápio");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		criarBotoes();
		adicionarBotoes();
		adicionarListeners();
		
	}

	private void criarBotoes() {
		criarGrupo = new JButton("Criar grupo");
		criarGrupo.setAlignmentX(Component.CENTER_ALIGNMENT);
		editarGrupo = new JButton("Editar grupo");
		editarGrupo.setAlignmentX(Component.CENTER_ALIGNMENT);
		criarAlimento = new JButton("Criar alimento");
		criarAlimento.setAlignmentX(Component.CENTER_ALIGNMENT);
		editarAlimento = new JButton("Editar alimento");
		editarAlimento.setAlignmentX(Component.CENTER_ALIGNMENT);
		montarCardapio = new JButton("Montar Cardápio");
		montarCardapio.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	private void adicionarBotoes() {
		contentPane.add(Box.createRigidArea(new Dimension(10,30)));
		contentPane.add(criarGrupo);
		contentPane.add(Box.createRigidArea(new Dimension(10,30)));
		contentPane.add(editarGrupo);
		contentPane.add(Box.createRigidArea(new Dimension(10,30)));
		contentPane.add(criarAlimento);
		contentPane.add(Box.createRigidArea(new Dimension(10,30)));
		contentPane.add(editarAlimento);
		contentPane.add(Box.createRigidArea(new Dimension(10,30)));
		contentPane.add(montarCardapio);
	}
	
	private void adicionarListeners() {
		criarGrupo.addActionListener(this);
		editarGrupo.addActionListener(this);
		criarAlimento.addActionListener(this);
		editarAlimento.addActionListener(this);
		montarCardapio.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
		if(source.getText() == "Criar grupo") {
			criarGrupo();
		} else if (source.getText() == "Editar grupo") {
			editarGrupo();
		} else if (source.getText() == "Criar alimento") {
			criarAlimento();
		} else if (source.getText() == "Editar alimento") {
			editarAlimento();
		} else {
			montarCardapio();
		}
		
	}

	private void criarGrupo() {
		String nomeGrupo = JOptionPane.showInputDialog(null, 
				"Digite o nome do grupo",  "Criar Grupo", JOptionPane.PLAIN_MESSAGE);
		
		if (nomeGrupo != null) { // checa se apertou cancelar			
			try {
				GrupoController.salvarGrupo(nomeGrupo);
			} catch (DadoIncompletoException e) {
				JOptionPane.showMessageDialog(null, 
						"Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}
	
	private void editarGrupo() {
		JanelaEditarGrupo janelaEditarGrupo = new JanelaEditarGrupo();
		int resultado = JOptionPane.showConfirmDialog(null, janelaEditarGrupo, 
	               "", JOptionPane.OK_CANCEL_OPTION);
		if (resultado == JOptionPane.OK_OPTION) {
			try {
				GrupoController.editarGrupo(
						janelaEditarGrupo.getNomeAtual(), janelaEditarGrupo.getNovoNome());
			} catch (DadoIncompletoException e) {
				JOptionPane.showMessageDialog(null, 
						"Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private void criarAlimento() {
		JanelaAlimento janela = new JanelaAlimento(true);
		int resultado = JOptionPane.showConfirmDialog(
				null, 
				janela, 
	            "", 
	            JOptionPane.OK_CANCEL_OPTION
	            );		
		
		if (resultado == JOptionPane.OK_OPTION) {			
			try {
				AlimentoController.salvarAlimento(
						janela.getNome(), 
						janela.getMedida(), 
						janela.getNomeGrupo()
				);
			} catch (DadoIncompletoException e) {
				JOptionPane.showMessageDialog(null, 
					"Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	private void editarAlimento() {
		JanelaAlimento janela = new JanelaAlimento(false);
		
		int resultado = JOptionPane.showConfirmDialog(				
							null, 
							janela, 
				            "", 
				            JOptionPane.OK_CANCEL_OPTION            
						);		
		
		if (resultado == JOptionPane.OK_OPTION) {			
			System.out.println("Ok");			
			
			try {
				AlimentoController.editarAlimento(
						new EditarAlimentoParameter(janela.getNomeAtual(), janela.getNome(), janela.getMedida(), janela.getNomeGrupo())
				);
			} catch (DadoIncompletoException e) {
				JOptionPane.showMessageDialog(null, 
					"Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void montarCardapio() {
		JanelaMontarCardapio frameMontarCardapio = new JanelaMontarCardapio();
		frameMontarCardapio.setVisible(true);
	}

}

