package ioPuntuacion;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class ioPuntuacion {

	private static final String NOMBRE_ARCHIVO = "mejor puntuacion.txt";


	public static String[] leerPuntuacion() {
		File miArchivo = new File(NOMBRE_ARCHIVO);
		String linea = null;
		try {
			Scanner entradaArchivo = new Scanner(miArchivo);
			if (entradaArchivo.hasNextLine()) {
				linea = entradaArchivo.nextLine();
				entradaArchivo.close();
			}
		} catch (FileNotFoundException e){
			System.err.println("El archivo no existe");
		}
		
		return linea.split(";");
	}

	
	public static void escribirPuntuacion(String nombre, int rondas){
		File archivo = new File(NOMBRE_ARCHIVO);
		FileWriter fw = null;

		try {
			fw = new FileWriter(archivo);
			fw.write(nombre +";"+ rondas);
		} catch (IOException e) {
			System.out.println("Error al guardar la puntuacion");
		} finally {
			if (fw != null) {
				try {
				fw.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
			}
		}
	}
}
