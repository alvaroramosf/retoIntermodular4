package clases;

import java.io.Serializable;
import java.util.Random;

public class Enemigo extends Personaje implements Serializable {

	private static final long serialVersionUID = 1L;

	public Enemigo() {
	};

	// No entiendo por que si la clase guerrero tiene defensa 10 y
	// el enemigo un maximo de ataque de 10 la clase guerreroe es
	// invencible practicamente. Eso o he confundido ataque y fuerza, por que he
	// dado
	// por hecho que son lo mismo.
	public void iniciarEnemigo(String Nombre) {
		Random rand = new Random();
		int min = 20;
		int max = 100;
		this.vida = rand.nextInt(max - min + 1) + min;
		this.vidaInicial = this.vida;
		min = 2;
		max = 10;
		this.ataque = rand.nextInt(max - min + 1) + min;
		min = 1;
		max = 3;
		this.defensa = rand.nextInt(max - min + 1) + min;
		this.nombre = Nombre;

	}

}
