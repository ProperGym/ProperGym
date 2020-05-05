package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Visualizacion {

public void readFileEmpleados(String path) {
		
		BufferedReader buff = null;
		String line;
		String delimiter = ","; //formato csv por comas
		
		try {
			buff = new BufferedReader(new FileReader(path));
			while ((line = buff.readLine()) != null) {
				String[] fileE = line.split(delimiter);
				//System.out.println(Arrays.toString(file));
				System.out.println("Empleado ID: " + fileE[2] + ". Nombre: " + fileE[0] + ", Apellidos: " + fileE[1]);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

public void readFileActividades(String path) {
	
	BufferedReader buff = null;
	String line;
	String delimiter = ","; //formato csv por comas
	
	try {
		buff = new BufferedReader(new FileReader(path));
		while ((line = buff.readLine()) != null) {
			String[] fileAct = line.split(delimiter);
			//System.out.println(Arrays.toString(file));
			System.out.println("ID: " + fileAct[1] + " - Fecha: " + fileAct[5] + " - Hora: " + fileAct[6] + 
			" - Sala: " + fileAct[2] + " - Nombre: " + fileAct[0] + " - Empleado: " + fileAct[4] + 
			" - Capacidad de sala: " + fileAct[3] +	" - M·ximo aforo: " + fileAct[7] + 
			" - Plazas ocupadas: " + fileAct[8] + "\n");			
		}
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
	
}
