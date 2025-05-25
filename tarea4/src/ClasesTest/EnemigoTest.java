package ClasesTest;

import clases.Enemigo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemigoTest {
	@Test
	void IniciarEneimgosTest() {
		Enemigo enemigo = new enemigo();
		enemigo.iniciarEnemigo("cthulhu");
		assertNotNull(enemigo.getNombre());
		assertTrue(enemigo.getVida() >= 20 && enemigo.getVida() <= 100);
		assertTrue(enemigo.getAtaque() >= 2 && enemigo.getAtaque() <= 10);
		assertTrue(enemigo.getDefensa() >= 1 && enemigo.getDefensa() <= 3);
	}
}
