package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exceptions.DadoIncompletoException;
import models.Alimento;
import models.Grupo;
import controllers.AlimentoController;
import controllers.EditarAlimentoParameter;
import controllers.GrupoController;

@RunWith(Parameterized.class)
public class AlimentoControllerTest {
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "Vegetais", "Brocolis", "10 porcoes", "Carnes e Ovos", "Bisteca", "30 gramas"},
                 { "Massa", "Macarrão", "10 gramas", "Carboidrato", "Arroz", "5 gramas"},
                 { "Verde", "Couve", "20 gramas", "Carnes e Ovos", "Costela", "7 gramas"}
           });
    }
    
    private Grupo gp;
    private String newNomeGrupo;
    private String newMedida;
    private String newNomeAlimento;
    private Alimento newAlimento;
    
    
    public AlimentoControllerTest(String oldNomeGrupo, String oldNomeAlimento, String oldMedida, String newNomeGrupo, String newNomeAlimento, String newMedida ) throws DadoIncompletoException {
    	
    	GrupoController.salvarGrupo(oldNomeGrupo);
    	this.gp = GrupoController.obterGrupo(oldNomeGrupo);
    	
    	GrupoController.salvarGrupo(newNomeGrupo);
    	
    	AlimentoController.salvarAlimento(oldNomeAlimento, oldMedida, gp.getNome());
    	
    	this.newNomeAlimento = newNomeAlimento;
    	this.newMedida = newMedida;
    	this.newNomeGrupo = newNomeGrupo;
    	
    	this.newAlimento = AlimentoController.editarAlimento(new EditarAlimentoParameter(oldNomeAlimento, newNomeAlimento, newMedida, newNomeGrupo));
    }
    
    @Test
    public void testeEditarNomeAlimento() {
    	assertEquals(this.newNomeAlimento, this.newAlimento.getNome());
    }
    
    @Test
    public void testeEditarMedidaAlimento() {
    	assertEquals(this.newMedida, this.newAlimento.getMedida());
    }
    
    @Test
    public void testeEditarGrupoAlimento() {
    	assertEquals(this.newNomeGrupo, this.newAlimento.getGrupo().getNome());
    }
	
}
