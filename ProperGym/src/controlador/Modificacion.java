package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Modificacion {
	
	public static void eliminarFichero(File fichero, File fichero2) {

	    if (!fichero.exists()) {
	        System.out.println("El archivo data no existe.");
	    } else {
	        fichero.delete();
	        fichero2.renameTo(fichero);
	        System.out.println("El archivo data fue eliminado.");
	    }

	}
	
	public static void editRecordAct() throws IOException {
		
		String ID, Fecha, newnombre,newidAct, newidSala , newfecha, newhora, newidEmpleado, record, record2;
		int newmaxParticipantes,newcapacidadSala, newnParticipantes;
		String path = "Actividades.txt";
		String tempFile = "tempAct.txt";
		File data = new File(path);
		File temp = new File(tempFile);
		
		BufferedReader br = new BufferedReader( new FileReader(data) );
		BufferedWriter bw = new BufferedWriter( new FileWriter(temp) );
		
		Scanner strInput = new Scanner(System.in);
		
		System.out.print("Modificando registros");
		
		
		System.out.println("Ingrese ID de actividad a modificar: ");
		ID = strInput.nextLine();
		System.out.println("Ingrese Fecha de actividad a modificar: ");
		Fecha = strInput.nextLine();
		
		while( ( record = br.readLine() ) != null ) {
			
			StringTokenizer st = new StringTokenizer(record,",");
			if( record.contains(ID) && record.contains(Fecha)) {
				System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			"+st.nextToken()+"      "+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			" +st.nextToken()+"	"+st.nextToken()+"			|");
			}
			
		}
		br.close();
		
		System.out.println("Ingrese Nuevo Nombre: ");
		newnombre = strInput.nextLine();
		System.out.println("Ingrese Nuevo ID: ");
		newidAct = strInput.nextLine();
		System.out.println("Ingrese Nuevo ID Sala: ");
		newidSala = strInput.nextLine();
		System.out.println("Ingrese Nueva Fecha: ");
		newfecha = strInput.nextLine();
		System.out.println("Ingrese Nueva Hora: ");
		newhora = strInput.nextLine();
		System.out.println("Ingrese Nuevo ID Empleado: ");
		newidEmpleado = strInput.nextLine();
		System.out.println("Ingrese Nueva Capacidad Sala: ");
		newcapacidadSala = strInput.nextInt();
		System.out.println("Ingrese Nuevo Maximo Participantes: ");
		newmaxParticipantes = strInput.nextInt();
		System.out.println("Ingrese Nueva Cantidad de Plazas ocupadas: ");
		newnParticipantes = strInput.nextInt();
		
		BufferedReader br2 = new BufferedReader( new FileReader(data) );
		
		while( (record2 = br2.readLine() ) != null ) {    			
			if(record2.contains(ID) && record2.contains(Fecha)) {
				bw.write(newnombre+","+newidAct+","+newidSala+","+newcapacidadSala+","+newidEmpleado+","+newfecha+","+newhora+","+newmaxParticipantes+","+newnParticipantes);
			} else {
				bw.write(record2);	
			}    			
			bw.flush();
			bw.newLine();
		}
		
		bw.close();
		br2.close();  
		data.delete();    		
		boolean success = temp.renameTo(data);    		
		System.out.println(success);    	
		
	}
	
public static void editRecordEmp() throws IOException {
		
		String ID, newApellido, newnombre,newID, record, record2;
		String path = "Empleados.txt";
		String tempFile = "tempEmp.txt";
		File data = new File(path);
		File temp = new File(tempFile);
		
		BufferedReader br = new BufferedReader( new FileReader(data) );
		BufferedWriter bw = new BufferedWriter( new FileWriter(temp) );
		
		Scanner strInput = new Scanner(System.in);
		
		System.out.print("Modificando registros");
		
		
		System.out.println("Ingrese ID del Empleado a modificar: ");
		ID = strInput.nextLine();
		
		while( ( record = br.readLine() ) != null ) {
			
			StringTokenizer st = new StringTokenizer(record,",");
			if( record.contains(ID)) {
				System.out.println("|	"+st.nextToken()+"	"+st.nextToken()+" 		"+st.nextToken()+"			|");
			}
			
		}
		br.close();
		
		
		System.out.println("Ingrese Nuevo ID: ");
		newID = strInput.nextLine();
		System.out.println("Ingrese Nuevo Nombre: ");
		newnombre = strInput.nextLine();
		System.out.println("Ingrese Nuevo Apellido: ");
		newApellido = strInput.nextLine();
		
		
		BufferedReader br2 = new BufferedReader( new FileReader(data) );
		
		while( (record2 = br2.readLine() ) != null ) {    			
			if(record2.contains(ID)) {
				bw.write(newnombre+","+newApellido+","+newID);
			} else {
				bw.write(record2);	
			}    			
			bw.flush();
			bw.newLine();
		}
		
		bw.close();
		br2.close();   
		
		eliminarFichero(data, temp); 
		  	
		
	}

public static void deleteRecordAct() throws IOException {
	
	String ID, record;
	String path = "Actividades.txt";
	String tempFile = "tempeAct.txt";
	File data = new File(path);
	File temp = new File(tempFile);
	
	BufferedReader br = new BufferedReader( new FileReader(data) );
	BufferedWriter bw = new BufferedWriter( new FileWriter(temp) );
	
	Scanner strInput = new Scanner(System.in);
	
	
	
	System.out.println("\nIngrese ID de Actividad a eliminar: ");
	ID = strInput.nextLine();
	
	while( ( record = br.readLine() ) != null ) {
		if( record.contains(ID) ) {
			continue;
		}else {
			bw.write(record);
		}
		
		bw.flush();
		bw.newLine();

	}
	
	br.close();
	bw.close();
	
	data.delete();
	
	boolean success = temp.renameTo(data);    		
	System.out.println(success); 
	
}

public static void deleteRecordEmp() throws IOException {
	
	String ID, record;
	String path = "Empleados.txt";
	String tempFile = "tempeEmp.txt";
	File data = new File(path);
	File temp = new File(tempFile);
	
	BufferedReader br = new BufferedReader( new FileReader(data) );
	BufferedWriter bw = new BufferedWriter( new FileWriter(temp) );
	
	Scanner strInput = new Scanner(System.in);
	
	
	
	System.out.println("\nIngrese ID de Empleado a eliminar: ");
	ID = strInput.nextLine();
	
	while( ( record = br.readLine() ) != null ) {
		if( record.contains(ID) ) {
			continue;
		}else {
			bw.write(record);
		}
		
		bw.flush();
		bw.newLine();

	}
	
	br.close();
	bw.close();
	
	data.delete();
	
	boolean success = temp.renameTo(data);    		
	System.out.println(success); 
	
}

}
