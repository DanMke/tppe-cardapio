package application;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;

public class Program {

	public static void main(String[] args) throws DadoIncompletoException {
		Grupo.carregar();
		Grupo g = new Grupo(1, "Carboidratos");
		Grupo.escrever();
		
		Alimento.carregar();
		new Alimento("Pão", "gramas", g);
		Alimento.escrever();
		
		for (Alimento i : Alimento.alimentos) {
			System.out.println(i.getNome());
			System.out.println(i.getMedida());
			System.out.println(i.getGrupo().getNome());
		}
		
		for (Grupo i : Grupo.grupos) {
			System.out.println(i.getId());
			System.out.println(i.getNome());
			for (Alimento a : i.alimentos) {
				System.out.println(a.getNome());
			}
		}
	}

}
