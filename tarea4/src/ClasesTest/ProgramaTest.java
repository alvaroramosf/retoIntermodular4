package ClasesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProgramaTest {
	@Test
	void testCrearJuegoConMago() {
		Juego juego = Programa.crearJuegoConMago("Merlin", 3);
		assertNotNull(juego.getJugador());
		assertTrue(juego.getJugador() instanceof Mago);
		assertEquals(3, juego.enemigos.size());
	}

	@Test
	void testCrearJuegoConGuerrero() {
		Juego juego = Programa.crearJuegoConGuerrero("Conan", 2);
		assertNotNull(juego.getJugador());
		assertTrue(juego.getJugador() instanceof Guerrero);
		assertEquals(2, juego.enemigos.size());
	}
}
