package clases;

import java.io.Serializable;

public class Mago extends Personaje implements Jugable , Serializable{
	private static final long serialVersionUID = 1L; //Para el warning;
	private static final int FUERZA_MAGIA = 20;
	private static final int FUERZA_SIN_MAGIA = 5;
	private static final int DEFENSA = 5;
	private static final int MAGIA = 10;
	
	private int magia;
	
	public Mago(String nombre, int vida) {
		super(nombre, vida, FUERZA_MAGIA, DEFENSA);
		magia = MAGIA;
	}

	@Override 
	public void atacar(Personaje otro) {
		int fuerza_ataque;
		if(magia>0) {
			fuerza_ataque = FUERZA_MAGIA;
			magia --;
		} else {
			fuerza_ataque = FUERZA_SIN_MAGIA;
		}
		int daño = (fuerza_ataque - otro.getDefensa()) < 0 ? 0 : (fuerza_ataque - otro.getDefensa());
	    otro.setVida(otro.getVida() - daño);
	}



	@Override
	public void curar() {
		if (magia > 0) {
			this.vida += this.ataque;
			if (this.vida > this.vidaInicial) {
				this.vida = this.vidaInicial;
			}
			magia--;
		}
	}



	@Override
	public void resetear() {
		this.magia = MAGIA;
	}
	
	@Override
	public String toString() {
		return this.nombre + ": vida: " +this.vida + "/" + this.vidaInicial + "; Magia:" + this.magia;
	}
}
