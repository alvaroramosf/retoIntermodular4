package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Juego implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private static final String[] NOMBRESENEMIGOS = {"Pablo Motos", "Ana Obregon", "La Hijnieta de Ana Obregón"};
	
	private ArrayList<Enemigo>enemigos;
	private Personaje jugador;
	private int nRondas;
	private int ronda;
	
	public Juego() {
		this.setEnemigos(new ArrayList<>());
	}
	
	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}

	public void setnRondas(int nRondas) {
		this.nRondas = nRondas;
	}
	
	public void setRonda(int ronda) {
		this.ronda = ronda;
	}
	
	public Personaje getJugador() {
		return this.jugador;
	}
	
	public int getnRondas() {
		return this.nRondas;
	}
	
	public int getRonda() {
		return this.ronda;
	}
	
	public static String getRandomNombreEnemigo() {
		Random rand = new Random();
		int index = rand.nextInt(NOMBRESENEMIGOS.length);
		return NOMBRESENEMIGOS[index];
	}
	
	public void iniciarJuego() {
		if(this.getEnemigos().isEmpty()) {
			for (int i = 0; i < nRondas; i++) {
				getEnemigos().add(new Enemigo());
				getEnemigos().get(i).iniciarEnemigo(getRandomNombreEnemigo());;
			}
			this.ronda = 0;
		} else {
			 System.out.println("Enemigos no esta vacio");
		}
	}
	
	//Si es void no puede devolver a un enemigo, no entiendo lo que quieres decir en el enunciado
	public Enemigo getSiguiente() {
	    if (ronda < nRondas && !getEnemigos().isEmpty()) {
	        return getEnemigos().remove(0);
	    } else {
	        System.out.println("No quedan enemigos");
	        return null;
	    }
	}

	
	
	public boolean terminarRonda() {
	    if (!getEnemigos().isEmpty()) {
	        return getEnemigos().get(0).getVida() <= 0;
	    }
	    return false;
	}

	public void nuevoGuerrero(String nombre) {
		Random rand = new Random();
		int min = 100;
		int max = 200;
		int vida = rand.nextInt(max- min + 1) + min;
		jugador = new Guerrero(nombre, vida);
	}

	public void nuevoMago(String nombre) {
		Random rand = new Random();
		int min = 50;
		int max = 150;
		int vida = rand.nextInt(max - min + 1) + min;
		jugador = new Mago(nombre, vida);
	}

	
	public boolean finalJuego() {
		return getEnemigos().isEmpty();
	}

	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Enemigo> enemigos) {
		this.enemigos = enemigos;
	}

}
