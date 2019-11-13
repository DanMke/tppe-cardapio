package views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Cardapio;

public class JanelaCardapio extends JFrame {
	private JPanel contentPane;
	private JPanel primeiraLinha;
	private JPanel segundaLinha;
	private PainelDiaDaSemanaCardapio segunda;
	private PainelDiaDaSemanaCardapio terca;
	private PainelDiaDaSemanaCardapio quarta;
	private PainelDiaDaSemanaCardapio quinta;
	private PainelDiaDaSemanaCardapio sexta;
	private PainelDiaDaSemanaCardapio sabado;
	private PainelDiaDaSemanaCardapio domingo;
	private List<Cardapio> cardapio;
	
    public JanelaCardapio(){
    	cardapio = Cardapio.getCardapioSemana();
    	
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
		domingo = new PainelDiaDaSemanaCardapio("Domingo");
		segunda = new PainelDiaDaSemanaCardapio("Segunda");
		terca = new PainelDiaDaSemanaCardapio("Terça");
		quarta = new PainelDiaDaSemanaCardapio("Quarta");
		quinta = new PainelDiaDaSemanaCardapio("Quinta");
		sexta = new PainelDiaDaSemanaCardapio("Sexta");
		sabado = new PainelDiaDaSemanaCardapio("Sábado");
		
		adicionarElementosCardapio();
	}

	private void adicionarElementosCardapio() {
		// TODO chamar metodos para adicionar lista no panel de refeição aqui
		ArrayList<String> alimentos = new ArrayList<String>();
		alimentos.add("Batata");
		alimentos.add("Arroz");
		alimentos.add("Feijão");
		alimentos.add("Alface");
		alimentos.add("Alface");
		segunda.setAlimentos(alimentos);
		terca.setAlimentos(alimentos);
		quarta.setAlimentos(alimentos);
		quinta.setAlimentos(alimentos);
		sexta.setAlimentos(alimentos);
		sabado.setAlimentos(alimentos);
		domingo.setAlimentos(alimentos);
	}

	private void adicionarComponentes() {
		primeiraLinha.add(segunda);
		primeiraLinha.add(terca);
		primeiraLinha.add(quarta);
		primeiraLinha.add(quinta);
		segundaLinha.add(sexta);
		segundaLinha.add(sabado);
		segundaLinha.add(domingo);
		
	}
	
}
