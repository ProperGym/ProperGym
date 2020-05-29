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
			
			System.out.println(" -----------------------------------------------");
			System.out.println("|                  ENTRENADORES                 |");
			System.out.println(" -----------------------------------------------");
	    	System.out.println("|   ID       Nombre          Apellidos          |");
	    	System.out.println(" -----------------------------------------------");
			while ((line = buff.readLine()) != null) {
				String[] fileE = line.split(delimiter);
				System.out.println("|   "+fileE[2]+"       "+fileE[0]+"        "+ fileE[1] +"         ");
			}
			System.out.println(" --------------------------------------------------");
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
		System.out.println(" --------------------------------------------------------------------------------------------------------------------------");
    	System.out.println("|	                                               ACTIVIDADES                                                         |");
		System.out.println(" --------------------------------------------------------------------------------------------------------------------------");
    	System.out.println("|	ID	     Fecha	     Hora	    Sala     Nombre	    Empleado	Capacidad  Aforo max   Ocupadas    |");
    	System.out.println(" --------------------------------------------------------------------------------------------------------------------------");
		while ((line = buff.readLine()) != null) {
			String[] fileAct = line.split(delimiter);
			
			System.out.println("|	"+ fileAct[1] +"	     "+ fileAct[5] +"	     "+ fileAct[6] +"	     "+ fileAct[2] + "	     "+ fileAct[0] +"	     "+ fileAct[4] + "	     "+ fileAct[3] +"	     "+ fileAct[7] + "	          "+ fileAct[8] + "        |");			
		}
		System.out.println("|--------------------------------------------------------------------------------------------------------------------------|");
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
		System.out.println(" ------------------------------------------------------------");
    	System.out.println("|	ID	     Fecha	     Hora	    Sala     |");
    	System.out.println(" ------------------------------------------------------------");
		while ((line = buff.readLine()) != null) {
			String[] fileCA = line.split(delimiter);
			if (fileCA[0].equals(username)) {
			System.out.println("|	"+fileCA[1] + "	     " + fileCA[3] + "	     " + fileCA[4] + 
			"	     " + fileCA[2] + "      |");
			}
		}
		System.out.println("|-------------------------------------------------------------|");
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

public void informeActividades(String path, String username) {
	
	}
}

