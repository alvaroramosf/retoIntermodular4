package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Juego implements Serializable  {
	
	private static final String[] NOMBRESENEMIGOS = {"Pablo Motos", "Ana Obregon", "La Hijnieta de Ana Obregón"};
	
	private ArrayList<Enemigo>enemigos;
	private Personaje jugador;
	private int nRondas;
	private int ronda;
	
	public Juego() {
		this.enemigos = new ArrayList<>();
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
	
	static String getRandomNombreEnemigo() {
		Random rand = new Random();
		int index = rand.nextInt(NOMBRESENEMIGOS.length);
		return NOMBRESENEMIGOS[index];
	}
	
	public void iniciarJuego() {
		if(this.enemigos.isEmpty()) {
			for (int i = 0; i < nRondas; i++) {
				enemigos.add(new Enemigo());
				enemigos.get(i).iniciarEnemigo(getRandomNombreEnemigo());;
			}
			this.ronda = 0;
		} else {
			 System.out.println("Enemigos no esta vacio");
		}
	}
	
	//Si es void no puede devolver a un enemigo, no entiendo lo que quieres decir en el enunciado
	public Enemigo getSiguiente() {
	    if (ronda < nRondas && !enemigos.isEmpty()) {
	        return enemigos.remove(0);
	    } else {
	        System.out.println("No quedan enemigos");
	        return null;
	    }
	}

	
	
	public boolean terminarRonda() {
	    if (!enemigos.isEmpty()) {
	        return enemigos.get(0).getVida() <= 0;
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
		return enemigos.isEmpty();
	}
	public static void guardarPartida(Juego juego) {
	    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("partida.dat"))) {
	        out.writeObject(juego);
	        System.out.println(" Partida guardada.");
	    } catch (IOException e) {
	        System.out.println(" Error al guardar la partida.");
	    }
	    
	}
	public static Juego cargarPartida() {
	    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("partida.dat"))) {
	        System.out.println("Partida cargada.");
	        return (Juego) in.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("No se pudo cargar la partida.");
	        return null;
	    }
	    
	}
	public static void borrarPartida() {
	    File file = new File("partida.dat");
	    if (file.exists()) file.delete();
	}
}
