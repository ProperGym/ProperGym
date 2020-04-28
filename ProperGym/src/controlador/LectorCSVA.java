package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LectorCSVA {
	
	public boolean readFileA(String path, String user, String pass) {
		
		boolean check = false;
		BufferedReader buff = null;
		String line;
		String delimiter = ";";
		
		try {
			buff = new BufferedReader(new FileReader(path));
			while ((line = buff.readLine()) != null) {
				String[] file = line.split(delimiter);
				
				if(file[0].equals(user) && file[1].equals(pass)) {
					check = true;
					System.out.print("Login Correcto\n");
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
	

}
