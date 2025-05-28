package ClasesTest;
import clases.Personaje;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Personaje;
public class PersonajeTest {
	@Test
    void ConstructoresySettersTest() {
        Personaje personaje = new Personaje("Test", 100, 10, 5); // ES ABSTRACTA !!!!!!!!!!
        assertEquals("Test", personaje.getNombre());
        assertEquals(100, personaje.getVida());
        assertEquals(10, personaje.getAtaque());
        assertEquals(5, personaje.getDefensa());
    }

    @Test
    void AtacarTest() {
        Personaje atacante = new Personaje("A", 100, 20, 5);
        Personaje defensor = new Personaje("D", 100, 5, 10);
        atacante.atacar(defensor);
        assertEquals(90, defensor.getVida()); // 20 - 10
    }

    @Test
    void ResetycurarTest() {
        Personaje personaje = new Personaje("Test", 100, 10, 5);
        personaje.setVida(50);
        personaje.resetear();
        assertEquals(100, personaje.getVida());
    }

    @Test
    void MuertoTest() {
        Personaje personaje = new Personaje("Des", 0, 10, 5);
        assertTrue(personaje.muerto());
    }

    @Test
    void toStringTest() {
        Personaje personaje = new Personaje("Manolo", 80, 10, 5);
        assertEquals("Manolo => Vida: 80/80", personaje.toString());
    }
}
