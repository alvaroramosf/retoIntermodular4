package ClasesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Guerrero;
import clases.Mago;
public class JugableTest {
	  private Mago mago;
	    private Guerrero guerrero;

	    @BeforeEach
	    void setUp() {
	        mago = new Mago("Merlin", 100);
	        guerrero = new Guerrero("Gerald", 150);
	    }

	    @Test
	    void testCurarMago() {
	        mago.setVida(50);
	        mago.curar();
	        assertEquals(70, mago.getVida()); // fuerza inicial 20
	        assertEquals(9, mago.getMagia());
	    }

	    @Test
	    void testCurarGuerrero() {
	        guerrero.setVida(50);
	        guerrero.curar();
	        assertEquals(150, guerrero.getVida());
	        assertEquals(1, guerrero.getPociones());
	    }

	    @Test
	    void testCurarMagoSinMagia() {
	        mago.setVida(50);
	        for (int i = 0; i < 10; i++) mago.curar();
	        int vidaAntes = mago.getVida();
	        mago.curar(); // sin magia, no debería curar
	        assertEquals(vidaAntes, mago.getVida());
	    }

	    @Test
	    void testCurarGuerreroSinPociones() {
	        guerrero.setVida(50);
	        guerrero.curar(); // 1
	        guerrero.setVida(60);
	        guerrero.curar(); // 2
	        int vidaAntes = guerrero.getVida();
	        Guerrero.curar(); // sin pociones
	        assertEquals(vidaAntes, guerrero.getVida());
	    }
}
