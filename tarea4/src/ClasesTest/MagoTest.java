package ClasesTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Mago;
import clases.Personaje;

public class MagoTest {
	@Test
	void ataqueMagicoTest() {
		Mago mago=new Mago("Merlin",100);
		Personaje enemigo=new Personaje("Vampiro",100,4,0); // ES ABSTRACTA !!!!!!!!!!!!!!!!!!!!!
		
		for(int i=0;i<10;i++) {
			mago.atacar(enemigo);
		}
		assertEquals(100-(20*10),enemigo.getVida());
		assertEquals(0,mago.getAtaque()==5 ? 0 :1);
	}
	@Test
	void ResetearTest(){
		Mago mago= new Mago("Merlin",100);
		for(int i=0;i <10;i++) mago.atacar(new Personaje("Muñeco",100,0,0));
		mago.resetear();
		assertEquals(100,mago.getVida());
		assertEquals(20,mago.getAtaque());
	}
	@Test
	void toStringTest(){
		Mago mago=new Mago("Merlin",100);
		String string=mago.toString();
		assertTrue(string.contains("Magia"));
	}
}
