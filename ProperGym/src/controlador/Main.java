package controlador;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static String pathA = "loginA.txt";
	public static String pathC = "loginC.txt";
	
	public static int menuPrincipal(Scanner sc) {
		System.out.println("<-------------------BIENVENIDO A PROPERGYM--------------------->");
		System.out.println("Digite el numero de su eleccion:");
		System.out.println("1. Administrador");
		System.out.println("2. Cliente");
		System.out.println("3. Visualizar");
		int opcion = 0;
		boolean logA = false;
		boolean logC = false;
		opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			logA=loginAdministrador(sc);
			break;
		case 2:
			logC=loginCliente(sc);
			break;
		case 3:
			visualizarActivE(sc);
			break;
		}
		return opcion;
		
	}
	
	public void limpiar(int lineas)
	{
	 for (int i=0; i < lineas; i++)
	 {
	  System.out.println();
	 }
	}
	
	public static void registro(Scanner sc) {
		Scanner reg = new Scanner(System.in);
		String usuario;
		String contrasena;
		String Nombre;
		String Apellido;
		String fnac;
		String correo;
		System.out.println("Ingrese usuario:");
		usuario = reg.nextLine();
		System.out.println("Ingrese contrasena:");
		contrasena = reg.nextLine();
		System.out.println("Ingrese Primer Nombre:");
		Nombre = reg.nextLine();
		System.out.println("Ingrese Primer Apellido:");
		Apellido = reg.nextLine();
		System.out.println("Ingrese Fecha de Nacimiento:");
		fnac = reg.nextLine();
		System.out.println("Ingrese Correo Electronico:");
		correo = reg.nextLine();
		String [] cliente = {usuario, contrasena, Nombre, Apellido, fnac, correo};
		
	}
	
	public static boolean loginAdministrador(Scanner sc) {
		
		boolean logeado = true;
		String usuarioA;
		String contrasenaA;
		int opcion = 0;
		Scanner admi = new Scanner(System.in);
		
		System.out.println("<---------------------LOGIN ADMINISTRADOR------------------->");
		System.out.println("Usuario");
		usuarioA = admi.nextLine();
		System.out.println("Contrasena");
		contrasenaA = admi.nextLine();
		LectorCSVA lec = new LectorCSVA();
		
		logeado = lec.readFileA(pathA, usuarioA, contrasenaA);
		
		
		if(logeado == true) {
			visualizarActiv(sc);
		}else {
			System.out.println("Login Incorrecto");
			System.out.println("1. Volver a intentar");
			System.out.println("2. Atras");
			opcion = admi.nextInt();
			if(opcion == 1) {
				logeado=loginAdministrador(sc);
			}else if(opcion == 2) {
				menuPrincipal(sc);
			}
		}
		return logeado;
	}
	
	public static boolean loginCliente(Scanner sc) {
		boolean logeado = true;
		String usuarioC;
		String contrasenaC;
		int opcion = 0;
		Scanner cliente = new Scanner(System.in);
		
		System.out.println("<---------------------LOGIN CLIENTE------------------------->");
		System.out.println("Ingrese su usuario:");
		usuarioC = cliente.nextLine();
		System.out.println("Ingrese su contrasena:");
		contrasenaC = cliente.nextLine();
		LectorCSVA lec = new LectorCSVA();
		
		logeado = lec.readFileA(pathC, usuarioC, contrasenaC);
		
		if(logeado == true) {
			visualizarActiv(sc);
		}else {
			System.out.println("Login Incorrecto");
			System.out.println("1. Volver a intentar");
			System.out.println("2. Atras");
			opcion = cliente.nextInt();
			if(opcion == 1) {
				logeado=loginCliente(sc);
			}else if(opcion == 2) {
				menuPrincipal(sc);
			}
		}
		return logeado;
	}
	
	public static void visualizarActivE(Scanner sc) {
		Scanner vis = new Scanner(System.in);
		int opcion = 0;
		System.out.println("<---------------------VISUALIZAR ACTIVIDADES------------------------->");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Digite el numero de su eleccion:");
		System.out.println("1. Registrarse/MembresÌa");
		System.out.println("2. Atras");
		opcion = vis.nextInt();
		if(opcion == 2) {
			opcion = menuPrincipal(sc);
		}else {
			registro(sc);
		}
	}
	
	public static void visualizarActiv(Scanner sc) {
		Scanner vis = new Scanner(System.in);
		int opcion = 0;
		System.out.println("<---------------------VISUALIZAR ACTIVIDADES------------------------->");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("Actividades del Gimnasio");
		System.out.println("1. Atras");
		opcion = vis.nextInt();
		if(opcion == 1) {
			opcion = menuPrincipal(sc);
		}
	}
	
	public static void main(String[] args) {
		String usuarioA = "";
		String contrasenaA = "";
		String usuarioC = "";
		String contrasenaC = "";
		boolean logA = false;
		boolean logC = false;
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		opcion = menuPrincipal(sc);
		
	}

}



