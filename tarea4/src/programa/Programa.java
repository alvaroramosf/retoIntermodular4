package programa;

import java.io.Serializable;
import java.util.Scanner;
//import clases.Personaje; DA WARRNING
import clases.Juego;
import clases.Enemigo;
//import clases.Guerrero;
//import clases.Mago;
import clases.Jugable;
import ioPuntuacion.ioPuntuacion;


public class Programa implements Serializable  {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean jugarDeNuevo = true;

		while (jugarDeNuevo) {
			Juego juego = new Juego();
			
			String[] mejorPuntuacion = ioPuntuacion.leerPuntuacion();
			if (mejorPuntuacion != null) {
				System.out.println("Mejor puntuación: " + mejorPuntuacion[0] + " ~ " + mejorPuntuacion[1]);
				System.out.println("¿Deseas cargar una partida guardada? (s/n)");
				String cargar = entrada.nextLine();
				Juego Juego = null;

				if (cargar.equalsIgnoreCase("s")) {
				    Juego = cargarPartida();
				}

				if (juego == null) {
				    juego = new Juego();
				    
				}
			}
			
			System.out.println("Bienvenido al juego:");
			System.out.print("¿Cuántas rondas quieres jugar? ");
			int nRondas = entrada.nextInt();
			entrada.nextLine();
			juego.setnRondas(nRondas);
			System.out.print("Introduce tu nombre: ");
			String nombre = entrada.nextLine();
			System.out.println("Elige tu clase:");
			System.out.println("1. Mago");
			System.out.println("2. Guerrero");
			System.out.print("Elige (1, 2): ");
			int clase = entrada.nextInt();
			

			if (clase == 1) {
				juego.nuevoMago(nombre);
			} else {
				juego.nuevoGuerrero(nombre);
			}

			juego.iniciarJuego();

			while (!juego.finalJuego()) {
				juego.setRonda(juego.getRonda() + 1);
				System.out.println("Ronda: " + juego.getRonda() + "/" + juego.getnRondas());

				Enemigo enemigo = juego.getSiguiente();
				if (enemigo == null) break;

				System.out.println("Estás luchando contra: " + enemigo.toString());
				System.out.println("Eres: " + juego.getJugador().toString());

				while (!enemigo.muerto() && !juego.getJugador().muerto()) {
					System.out.println("Acciones:");
					System.out.println("1. Atacar");
					System.out.println("2. Curar");
					System.out.println("3. Guardar");
					System.out.print("Elige: ");
					int accion = entrada.nextInt();

					if (accion == 1) {
						System.out.println(juego.getJugador().getNombre() + " ataca a " + enemigo.getNombre());
						juego.getJugador().atacar(enemigo);
					} else if (accion == 2) {
						System.out.println(juego.getJugador().getNombre() + " se cura");
						((Jugable) juego.getJugador()).curar(); //Va a ser jugable siempre, otra opción sería cambiar getJugador para que devuelva jugable pero esto es mas sencillo y entiendo que es lo que se pide.
					}

					if (!enemigo.muerto()) {
						System.out.println(enemigo.getNombre() + " ataca a " + juego.getJugador().getNombre());
						enemigo.atacar(juego.getJugador());
						System.out.println("Estás luchando contra: " + enemigo.toString());
						System.out.println("Eres: " + juego.getJugador().toString());
					}

					System.out.println("Ronda: " + juego.getRonda() + "/" + juego.getnRondas());
				}

				if (enemigo.muerto()) {
					System.out.println("Enemigo vencido!");
					juego.terminarRonda();
				}

				if (juego.getJugador().muerto()) {
					System.out.println("Has perdido");
					break;
				}
			}

			if (!juego.getJugador().muerto()) {
				System.out.println("¡Has ganado el juego!");

				int rondasActuales = juego.getRonda();
				int recordAnterior;

				// Busca mejor puntuacion
				if (mejorPuntuacion != null) {
					recordAnterior = Integer.parseInt(mejorPuntuacion[1]);
				} else {
					recordAnterior = 0;
				}

				// Compara la puntuación actual con la mejor anterior
				if (rondasActuales > recordAnterior) {
					System.out.println("NUEVO RECORD");
					ioPuntuacion.escribirPuntuacion(juego.getJugador().getNombre(), rondasActuales);
					
					mejorPuntuacion = ioPuntuacion.leerPuntuacion();
					System.out.println("Mejor puntuación: " + mejorPuntuacion[0] + " ~ " + mejorPuntuacion[1]);
				}
			}


			System.out.print("¿Volver a jugar? (s/n): ");
			entrada.nextLine();
			String repetir = entrada.nextLine();
			jugarDeNuevo = repetir.equals("s");
		}

		System.out.println("Gracias por jugar. ¡Hasta la próxima!");
		entrada.close();
	}
}
