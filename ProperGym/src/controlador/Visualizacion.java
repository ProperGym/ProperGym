package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Visualizacion {

public void readFileEmpleados(String path) {
		
		BufferedReader buff = null;
		String line;
		String delimiter = ","; //formato csv por comas
		
		try {
			buff = new BufferedReader(new FileReader(path));
			while ((line = buff.readLine()) != null) {
				String[] fileE = line.split(delimiter);
				System.out.println("Empleado ID: " + fileE[2] + " Nombre: " + fileE[0] + " Apellidos: " + fileE[1]);
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
		System.out.println(" -------------------------------------------------------------------------------------------------------------------");
    	System.out.println("|	ID	     Fecha	     Hora	    Sala     Nombre	    Empleado	Capacidad Aforo   Plaza     |");
    	System.out.println(" -------------------------------------------------------------------------------------------------------------------");
		while ((line = buff.readLine()) != null) {
			String[] fileAct = line.split(delimiter);
			
			System.out.println("|	"+ fileAct[1] +"	     "+ fileAct[5] +"	     "+ fileAct[6] +"	     "+ fileAct[2] + "	     "+ fileAct[0] +"	     "+ fileAct[4] + "	     "+ fileAct[3] +"	     "+ fileAct[7] + "	     "+ fileAct[8] + "      |");			
		}
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
	
public void readFileClientesActividades(String path, String username) {
	
	BufferedReader buff = null;
	String line;
	String delimiter = ","; //formato csv por comas
	
	try {
		buff = new BufferedReader(new FileReader(path));
		while ((line = buff.readLine()) != null) {
			String[] fileCA = line.split(delimiter);
			if (fileCA[0].equals(username)) {
			System.out.println("ID: " + fileCA[1] + " - Fecha: " + fileCA[3] + " - Hora: " + fileCA[4] + 
			" - Sala: " + fileCA[2] + "\n");
			}
		}
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
