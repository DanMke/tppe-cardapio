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
import controllers.GrupoController;
import exceptions.DadoIncompletoException;
import models.Grupo;
import java.awt.Component;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class JanelaMenu extends JFrame implements ActionListener {
	private GrupoController grupoController;
	private AlimentoController alimentoController;
	
	private JPanel contentPane;
	private JButton criarGrupo;
	private JButton editarGrupo;
	private JButton criarAlimento;
	private JButton editarAlimento;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaMenu frame = new JanelaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JanelaMenu() {
		setTitle("Montador de cardápio");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		grupoController = new GrupoController();
		alimentoController = new AlimentoController();

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
	}
	
	private void adicionarListeners() {
		criarGrupo.addActionListener(this);
		editarGrupo.addActionListener(this);
		criarAlimento.addActionListener(this);
		editarAlimento.addActionListener(this);
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
		} else {
			editarAlimento();
		}
		
	}

	private void criarGrupo() { 
		String nomeGrupo = JOptionPane.showInputDialog(null, 
				"Digite o nome do grupo",  "Criar Grupo", JOptionPane.PLAIN_MESSAGE);
		
		if (nomeGrupo != null) { // checa se apertou cancelar
			
			try {
				grupoController.salvarGrupo(nomeGrupo);
			} catch (DadoIncompletoException e) {
				JOptionPane.showMessageDialog(null, 
						"Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	
	private void editarGrupo() {
		int resultado = JOptionPane.showConfirmDialog(null, new JanelaEditarGrupo(), 
	               "", JOptionPane.OK_CANCEL_OPTION);
		if (resultado == JOptionPane.OK_OPTION) {
			System.out.println("Ok");
		}
		
	}
	
	private void criarAlimento() {
		// TODO Auto-generated method stub
		
	}
	
	private void editarAlimento() {
		// TODO Auto-generated method stub
		
	}

}

