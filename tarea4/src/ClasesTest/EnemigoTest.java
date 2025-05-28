package ClasesTest;

import clases.Enemigo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EnemigoTest {
	@Test
	void IniciarEneimgosTest() {
		Enemigo enemigo = new Enemigo();
		enemigo.iniciarEnemigo("cthulhu");
		assertNotNull(enemigo.getNombre());
		assertTrue(enemigo.getVida() >= 20 && enemigo.getVida() <= 100);
		assertTrue(enemigo.getAtaque() >= 2 && enemigo.getAtaque() <= 10);
		assertTrue(enemigo.getDefensa() >= 1 && enemigo.getDefensa() <= 3);
	}
}
