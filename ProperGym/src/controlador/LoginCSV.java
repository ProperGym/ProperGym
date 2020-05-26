package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvWriter;

public class LoginCSV {

	//LOGIN
	public boolean readFileA(String path, String user, String pass) {
		
		boolean check = false;
		BufferedReader buff = null;
		String line;
		String delimiter = ",";
		
		try {
			buff = new BufferedReader(new FileReader(path));
			while ((line = buff.readLine()) != null) {
				String[] file = line.split(delimiter);
				
				if(file[0].equals(user) && file[1].equals(pass)) {
					check = true;
					System.out.println("Login Correcto\n");
					return check;
				}else {
					check = false;
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
//Comprueba datos de actividad e incrementa participantes
public boolean readFileAct(String path, String idAct, String fecha, String hora, String idSala) {
		
		boolean check = false;
		BufferedReader buffA = null;
		String line;
		String delimiter = ",";
		ArrayList<String[]> newLines = new ArrayList<String[]>(); // lista de arrays tipo String
		boolean hayplazas = false;
		
		try {
			buffA = new BufferedReader(new FileReader(path));
			while ((line = buffA.readLine()) != null) {
				String[] file = line.split(delimiter);
				
				if(file[1].equals(idAct) && file[5].equals(fecha) && file[6].equals(hora) && file[2].equals(idSala)) {
					check = true;
					int participantes = Integer.parseInt(file[8]); //convertido en int
					int capacidadSala = Integer.parseInt(file[7]);
					if (participantes < capacidadSala) {
						file[8] = Integer.toString(participantes + 1); 
						hayplazas = true;
						
						System.out.print("Datos correctos\n");
						System.out.print("Se ha registrado con Èxito en la actividad " + idAct + "\n");
					}
					else {
						System.out.print("Datos correctos. \nLamentablemente, no quedan plazas disponibles \n");
					}
				}
				newLines.add(file);
			}

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if (check == true) {
		try {
			
				CsvWriter writer = new CsvWriter(new FileWriter(path, false), ',');
				for(String[] newLine : newLines) {
					for (String f: newLine) { // se aÒade palabra a palabra
						writer.write(f);
					}
					writer.endRecord();
				}
				writer.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		
		return hayplazas;
	}


//MODIFICACI”N DE ACTIVIDADES
public void actualizarAct() {
	
}
}