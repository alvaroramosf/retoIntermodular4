package ClasesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clases.Enemigo;
import clases.Guerrero;
import clases.Juego;
import clases.Mago;

public class JuegoTest {
	@Test
	void CrearJuegoyEnemigoTest() {
		Juego juego = new Juego();
		juego.setnRondas(4);
		juego.iniciarJuego();
		assertEquals(3, juego.iniciarJuego());
	}

	@Test
	void MagiyGuerreroTets() {
		Juego juego = new Juego();
		juego.nuevoMago("Houdini");
		assertTrue(juego.getJugador() instanceof Mago);

		juego.nuevoGuerrero("Aragon");
		assertTrue(juego.getJugador() instanceof Guerrero);
	}

	@Test
	void TerminarRondaTest() {
		Juego juego = new Juego();
		juego.setRonda(1);
		juego.iniciarJuego();
		Enemigo enemigo = juego.getSiguiente();
		enemigo.setVida(0);

		assertTrue(juego.terminarRonda());
		assertTrue(juego.finalJuego());
	}

	@Test
	void NombreAleatorioTest() {
		String nombre = Juego.getRandomNombreEnemigo();
		assertNotNull("nombre");

	}

}
