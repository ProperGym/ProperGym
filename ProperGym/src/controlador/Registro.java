package controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.csvreader.CsvWriter;

public class Registro {
	
	

	public static void RegClientes(List<Cliente> clientes, String path) {
		
		
		try {
			CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
			
			for(Cliente cliente : clientes) {
				writer.write(cliente.getUsuario());
				writer.write(cliente.getContra());
				writer.write(cliente.getNombre());
				writer.write(cliente.getApellido());
				writer.write(cliente.getFecha());
				writer.write(cliente.getCorreo());
				
				writer.endRecord();
			}
			
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public static void RegEmpleados(List<Empleado> empleados, String path) {
		
		
		try {
			CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
			
			for(Empleado empleado : empleados) {
				writer.write(empleado.getNombre());
				writer.write(empleado.getApellidos());
				writer.write(empleado.getidEmpleado());
				
				writer.endRecord();
			}
			
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public static void RegActividades(List<Actividad> actividades, String path) {
		
		
		try {
			CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
			
			for(Actividad actividad : actividades) {
				writer.write(actividad.getNombre());
				writer.write(actividad.getIdAct()); 
				writer.write(actividad.getIdSala());
				writer.write(Integer.toString(actividad.getCapacidadSala())); //convertir los INT a STRING
				writer.write(actividad.getIdEmpleado());
				writer.write(actividad.getFecha());
				writer.write(actividad.getHora());
				writer.write(Integer.toString(actividad.getMaxParticipantes()));
				writer.write(Integer.toString(actividad.getnParticipantes()));
				
				writer.endRecord();
			}
			
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}


public static void RegClientesAct(String idAct, String idSala, String fecha, String hora, String username, String path) {
	
	
	try {
		CsvWriter writer = new CsvWriter(new FileWriter(path, true), ',');
			writer.write(username);
			writer.write(idAct); 
			writer.write(idSala);
			writer.write(fecha);
			writer.write(hora);
			
			writer.endRecord();
		
		writer.close();
	}catch (IOException e) {
		e.printStackTrace();
	}
}

}
