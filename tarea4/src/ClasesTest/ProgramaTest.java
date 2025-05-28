package ClasesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Guerrero;
import clases.Juego;
import clases.Mago;
import programa.Programa;

public class ProgramaTest {
	@Test
	void testCrearJuegoConMago() {
		Juego juego = Programa.crearJuegoConMago("Merlin", 3); /// WTF !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		assertNotNull(juego.getJugador());
		assertTrue(juego.getJugador() instanceof Mago);
		assertEquals(3, juego.getEnemigos().size());
	}

	@Test
	void testCrearJuegoConGuerrero() {
		Juego juego = Programa.crearJuegoConGuerrero("Conan", 2); /// WTF !!!!!!!!!!!!!!!!!!!!!!!!!!!
		assertNotNull(juego.getJugador());
		assertTrue(juego.getJugador() instanceof Guerrero);
		assertEquals(2, juego.getEnemigos().size());
	}
}
