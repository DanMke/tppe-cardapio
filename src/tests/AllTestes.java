package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
		GrupoControllerTest.class,
		AlimentoTest.class,
		GrupoTest.class,
		AlimentoControllerTest.class,
		CardapioTest.class,
		RefeicaoTest.class
	})

public class AllTestes {

}
