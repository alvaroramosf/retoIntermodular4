package ClasesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.Guerrero;

public class GuerreroTest {
	@Test
	void CurarTest() {
		Guerrero guerrero = new Guerrero("Ulises", 100);
		guerrero.setVida(10);
		guerrero.curar();
		assertEquals(100, guerrero.getVida());
	}

	@Test
	void ResetearTest() {
		Guerrero guerrero = new Guerrero("Ulises", 100);
		guerrero.curar();
		guerrero.resetear();
		guerrero.setVida(75);
		guerrero.curar();
		assertEquals(100, guerrero.getVida());
	}

	@Test
	void ToStringTest() {
		Guerrero guerrero = new Guerrero("Ulises", 100);
		assertTrue(guerrero.toString().contains("Pociones"));
	}
}
