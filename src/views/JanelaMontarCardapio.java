package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CardapioController;
import exceptions.CardapioInvalidoException;
import exceptions.CardapioOverflowException;
import exceptions.DadoIncompletoException;
import models.Grupo;

@SuppressWarnings("serial")
public class JanelaMontarCardapio extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JPanel primeiraLinha;
	private JPanel segundaLinha;
	private PainelDiaDaSemana segunda;
	private PainelDiaDaSemana terca;
	private PainelDiaDaSemana quarta;
	private PainelDiaDaSemana quinta;
	private PainelDiaDaSemana sexta;
	private PainelDiaDaSemana sabado;
	private PainelDiaDaSemana domingo;
	private JButton btnNext;
	JanelaCardapio frameJanelaCardapio;
	
    public JanelaMontarCardapio() {
    	setExtendedState(MAXIMIZED_BOTH);
    	setBounds(100, 100, 450, 300);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
    	
		criarPaineis();
    	criarComponentes();
    	adicionarComponentes();
    }

	private void criarPaineis() {
		primeiraLinha = new JPanel();
		primeiraLinha.setLayout(new BoxLayout(primeiraLinha, BoxLayout.X_AXIS));
		
		segundaLinha = new JPanel();
		segundaLinha.setLayout(new BoxLayout(segundaLinha, BoxLayout.X_AXIS));
		
		contentPane.add(primeiraLinha);
		contentPane.add(segundaLinha);
	}

	private void criarComponentes() {
		segunda = new PainelDiaDaSemana("Segunda");
		terca = new PainelDiaDaSemana("Terça");
		quarta = new PainelDiaDaSemana("Quarta");
		quinta = new PainelDiaDaSemana("Quinta");
		sexta = new PainelDiaDaSemana("Sexta");
		sabado = new PainelDiaDaSemana("Sábado");
		domingo = new PainelDiaDaSemana("Domingo");
		
		btnNext = new JButton("Ver cardápio");
		btnNext.addActionListener(this);
	}

	private void adicionarComponentes() {
		domingo.add(btnNext);
		primeiraLinha.add(segunda);
		primeiraLinha.add(terca);
		primeiraLinha.add(quarta);
		primeiraLinha.add(quinta);
		segundaLinha.add(sexta);
		segundaLinha.add(sabado);
		segundaLinha.add(domingo);
	}
	
	private List<List<Grupo>> getListaGrupo() {
		List<List<Grupo>> semana = new ArrayList<List<Grupo>>();
		semana.add(domingo.getListaGrupos());
		semana.add(segunda.getListaGrupos());
		semana.add(terca.getListaGrupos());
		semana.add(quarta.getListaGrupos());
		semana.add(quinta.getListaGrupos());
		semana.add(sexta.getListaGrupos());
		semana.add(sabado.getListaGrupos());
		
		return semana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			CardapioController.montarCardapio(getListaGrupo());
			frameJanelaCardapio = new JanelaCardapio();
			frameJanelaCardapio.setVisible(true);
			this.setVisible(false);
		} catch (CardapioInvalidoException e1) {
			JOptionPane.showMessageDialog(null, 
					"Não foi possível montar o cardápio", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (CardapioOverflowException e1) {
			JOptionPane.showMessageDialog(null, 
					"Dias estourados (7)", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (DadoIncompletoException e1) {
			JOptionPane.showMessageDialog(null, 
					"Dados incompletos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	
	}
}
