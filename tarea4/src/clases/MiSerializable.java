package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public interface MiSerializable {
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
