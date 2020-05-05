package controlador;

import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Main {
	public static String pathA = "loginA.txt";
	public static String pathC = "Clientes.csv";
	public static String pathEmpleados = "Empleados.csv";
	public static String pathActividades = "Actividades.csv";
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	static ArrayList<Actividad> actividades = new ArrayList<Actividad>();

	
public static void main(String[] args) throws IOException {
		
		String usuarioA = "";
		String contraseÒaA = "";
		String usuarioC = "";
		String contraseÒaC = "";
		
		boolean logA = false;
		boolean logC = false;
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		opcion = menuPrincipal(sc);
		
	}
	
//MEN⁄ PRINCIPAL
	public static int menuPrincipal(Scanner sc) throws IOException {
		System.out.println("<-------------------BIENVENIDO A PROPERGYM--------------------->");
		System.out.println("Digite el n˙mero de su elecciÛn:");
		System.out.println("1. Administrador");
		System.out.println("2. Cliente");
		System.out.println("3. Visualizar Actividades - Registro");
		//System.out.println("4. ProperGym - informaciÛn");
		
		//ELEGIMOS OPCI”N DEL MEN⁄
		int opcion = 0;
		
		//VARIABLES SI EL LOGIN SE COMPLET” O NO
		boolean logA = false;
		boolean logC = false;
				
		//LEE LA OPCI”N
		opcion = sc.nextInt();
		
		//ESCOGE LA OPCI”N
		switch (opcion) {
		case 1:
			logA=loginAdministrador(sc);
			break;
		case 2:
			logC=loginCliente(sc);
			break;
		case 3:
			visActividadesE(sc);
			break;
		/* case 4:
		  	visInfo(sc);
		  	break;
		 */
		}
		return opcion;
	}
	

//ADMINISTRADOR
		//LOGIN DEL ADMINISTRADOR
		public static boolean loginAdministrador(Scanner sc) throws IOException {
			
			//Variable para comprobar si usuario y contrasea coinciden
			boolean logeado = true;
			
			String usuarioA;
			String contrasenaA;
			
			int opcion = 0;
			Scanner admi = new Scanner(System.in);
			
			System.out.println("<---------------------LOGIN ADMINISTRADOR------------------->");
			System.out.println("Usuario");
			usuarioA = admi.nextLine();
			System.out.println("ContraseÒa");
			contrasenaA = admi.nextLine();
			
			//crear un nuevo lector csv
			LoginCSV lec = new LoginCSV();
			
			//Comparar valores ingresados con los del archivo csv -> se usa clase LoginCSV
			logeado = lec.readFileA(pathA, usuarioA, contrasenaA);
			
			//Si coinciden usuario y contraseÒa
			if(logeado == true) {
				//nos dirigimos al men˙ del Administrador
				menuA(sc);
			}else {
				//Si no coinciden, se puede volver a intentar o ir atr·s
				System.out.println("Login Incorrecto");
				System.out.println("1. Volver a intentar");
				System.out.println("2. Atr·s");
				opcion = admi.nextInt();
				if(opcion == 1) {
					logeado=loginAdministrador(sc);
				}else if(opcion == 2) {
					menuPrincipal(sc);
				}
			}
			return logeado;
		}
		
		//MEN⁄ DE ADMINISTRADOR
		public static int menuA(Scanner sc) throws IOException {
			Scanner vis = new Scanner(System.in);
			int opcion = 0;
			System.out.println("1. Administrar Actividades");
			System.out.println("2. Administrar Empleados");
			System.out.println("3. Salir");
			opcion = vis.nextInt();
			switch (opcion) {
			case 1:
				visualizarActivA(sc);
				break;
			case 2:
				admEmpleados(sc);
				break;
			case 3:
				menuPrincipal(sc);
				break;
			}
			return opcion;
		}
		
		
		//VISUALIZAR ACTIVIDADES POR EL ADMINISTRADOR
		public static int visualizarActivA(Scanner sc) throws IOException {
			Scanner vis = new Scanner(System.in);
			int opcion = 0;
			System.out.println("1. Actividades del dÌa");
			System.out.println("2. Actividades de la semana");
			System.out.println("3. Salir");
			opcion = vis.nextInt();
			switch (opcion) {
			case 1:
				visualizarActivDia(sc);
				break;
			case 2:
				visualizarActivSemana(sc);
				break;
			case 3:
				menuPrincipal(sc);
				break;
			}
			return opcion;
			
			
		}
		
		
		//VISUALIZAR ACTIVIDADES DEL DIA
			public static void visualizarActivDia(Scanner sc) throws IOException {
				Scanner vis = new Scanner(System.in);
				int opcion = 0;
				System.out.println("1. AÒadir Actividad");
				System.out.println("2. Modificar/Eliminar Actividad");
				System.out.println("3. Atr·s\n");
				
				System.out.println("<----------VISUALIZAR ACTIVIDADES---------->");
				Visualizacion v = new Visualizacion();
				v.readFileActividades(pathActividades);

				System.out.println("1. Atr·s");
				System.out.println("2. Men˙ Administrador");
				System.out.println("3. Men˙ Principal");
				opcion = vis.nextInt();
				switch (opcion) {
				case 1:
					visualizarActivA(sc);
					break;
				case 2:
					menuA(sc);
					break;
				case 3:
					menuPrincipal(sc);
					break;
				}
				
			}
		
		
		//VIASUALIZAR ACTIVIDADES DE LA SEMANA
		public static void visualizarActivSemana(Scanner sc) throws IOException {
			Scanner vis = new Scanner(System.in);
			int opcion = 0;
			System.out.println("1. AÒadir Actividad");
			System.out.println("2. Modificar/Eliminar Actividad");
			System.out.println("3. Atr·s");
			System.out.println("<---------------------VISUALIZAR ACTIVIDADES------------------------->");

			opcion = vis.nextInt();
			switch (opcion) {
			case 1:
				agregarAct(sc);
				break;
			case 2:
				modActividad(sc);
				break;
			case 3:
				menuA(sc);
				break;
			}
			
		}
		
		
				//AGREGAR ACTIVIDADES
		private static void agregarAct(Scanner sc) throws IOException {
			System.out.println("<----------AGREGAR ACTIVIDAD---------->");
			 	Scanner agAct = new Scanner(System.in);
				
			 	String nombre;
				String idAct;
				String idSala;
				int capacidadSala;
				String fecha;
				String hora;
				String idEmpleado;
				int maxParticipantes;
				int nParticipantes = 0;
				
				//PEDIDA DE DATOS
				System.out.println("Ingrese nombre:");
				nombre = agAct.nextLine();
				System.out.println("Ingrese ID de actividad:");
				idAct = agAct.nextLine();
				System.out.println("Ingrese ID de sala:");
				idSala = agAct.nextLine();
				System.out.println("Ingrese capacidad de la sala:");
				capacidadSala = agAct.nextInt();
				agAct.nextLine(); //separaciÛn despuÈs de nextInt
				System.out.println("Ingrese ID del empleado:");
				idEmpleado = agAct.nextLine();
				System.out.println("Ingrese fecha de actividad:");
				fecha = agAct.nextLine();
				System.out.println("Ingrese hora de la actividad:");
				hora = agAct.nextLine();
				System.out.println("Indique si es individual (1) o grupal (2):");
				int opcion = agAct.nextInt();
				if (opcion == 1) {
					maxParticipantes = 1;
				}
				else {
					maxParticipantes = capacidadSala;
				}
				
				//CREO UNA NUEVA ACTIVIDAD
				actividades.add(new Actividad(nombre, idAct, idSala, capacidadSala, fecha, hora, idEmpleado, maxParticipantes, nParticipantes));
				
				//INGRESO EL CLIENTE EN EL CSV -> USO CLASE REGCLIENTE
				Registro.RegActividades(actividades, pathActividades);
				
				System.out.print("Actividad registrada con Èxito");
		}
		
		//MODIFICAR ACTIVIDADES
				private static void modActividad(Scanner sc) {
					System.out.println("<----------MODIFICAR/ELIMINAR ACTIVIDAD---------->");
					
				}
				
					
		//ADMINISTRAR ENTRENADORES
		public static void admEmpleados(Scanner sc) throws IOException {
			Scanner adm = new Scanner(System.in);
			int opcion = 0;
			
			System.out.println("1. Visualizar empleados");
			System.out.println("2. Agregar empleados");
			System.out.println("3. Modificar empleados");
			System.out.println("5. Salir");
			opcion = adm.nextInt();
			switch (opcion) {
			case 1:
				visEmpleados(sc);
				break;
			case 2:
				regEmpleados(sc);
				break;
			case 5:
				menuPrincipal(sc);
				break;
			}
		}
		
			//CREAR UN NUEVO EMPLEADO
			public static void regEmpleados(Scanner sc) throws IOException {
			Scanner emp = new Scanner(System.in);
			
				String nombre;
				String apellidos;
				String idEmpleado;
				
				//PEDIDA DE DATOS
				System.out.println("Ingrese nombre:");
				nombre = emp.nextLine();
				System.out.println("Ingrese apellidos:");
				apellidos = emp.nextLine();
				System.out.println("Ingrese ID de empleado:");
				idEmpleado = emp.nextLine();
				
				//CREO UN NUEVO EMPLEADO
				empleados.add(new Empleado(nombre, apellidos, idEmpleado));
				
				//INGRESO EL EMPLEADO EN EL CSV -> USO CLASE REGISTROS
				Registro.RegEmpleados(empleados, pathEmpleados);
				
				System.out.print("Empleado registrado con Èxito");
			}
			
			//VISUALIZAR EMPLEADOS -> USO CLASE VISUALIZACION
			public static void visEmpleados (Scanner sc) throws IOException {
				int opcion = 0;
				Scanner visE = new Scanner(System.in);
				
				System.out.println("<----------VISUALIZAR EMPLEADOS---------->");
				Visualizacion v = new Visualizacion();
				v.readFileEmpleados(pathEmpleados);
				
				System.out.println("1. Men˙ de Administrador");
				opcion = visE.nextInt();
				if(opcion == 1) {
					opcion = menuA(sc);
				}
			}
			
		
			
//CLIENTE		
		//LOGIN DEL CLIENTE
		public static boolean loginCliente(Scanner sc) throws IOException {
			
			//Variable para comprobar que usuario y contraseÒa coinciden
			boolean logeado = true;
			
			String usuarioC;
			String contraseÒaC;
			
			int opcion = 0;
			Scanner cliente = new Scanner(System.in);
			
			System.out.println("<---------------------LOGIN CLIENTE------------------------->");
			System.out.println("Ingrese su usuario:");
			usuarioC = cliente.nextLine();
			System.out.println("Ingrese su contraseÒa:");
			contraseÒaC = cliente.nextLine();
			
			//CREO UN NUEVO LECTOR CSV
			LoginCSV lec = new LoginCSV();
			
			//COMPARO VALORES INGRESADOS CON LOS DEL ARCHIVO CSV -> USO CLASE LOGINCSV
			logeado = lec.readFileA(pathC, usuarioC, contraseÒaC);
			
			if(logeado == true) {
				menuCliente(sc);
			}else {
				System.out.println("Login Incorrecto");
				System.out.println("1. Volver a intentar");
				System.out.println("2. Atr·s");
				opcion = cliente.nextInt();
				if(opcion == 1) {
					logeado=loginCliente(sc);
				}else if(opcion == 2) {
					menuPrincipal(sc);
				}
			}
			return logeado;
		}
	
		
		public static int menuCliente(Scanner sc) throws IOException {
			Scanner mec = new Scanner(System.in);
			int opcion = 0;
			
			System.out.println("1. Visualizar Actividades del Gimnasio");
			System.out.println("2. Apuntarse a una actividad");
			//System.out.println("3. Visualizar mi horario");
			System.out.println("4. Salir");
			opcion = mec.nextInt();
			switch (opcion) {
			case 1:
				visActividadesC(sc);
				break;
			case 2:
				apActividad(sc);
				break;
			/*case 3:
				visHorario(sc);
				break;*/
			case 4:
				menuPrincipal(sc);
				break;
			}
			return opcion;
		}
	
	
	
		//VISUALIZAR ACTIVIDADES COMO CLIENTE
		public static void visActividadesC(Scanner sc) throws IOException {
			Scanner visAC = new Scanner(System.in);
			int opcion = 0;
			System.out.println("<----------VISUALIZAR ACTIVIDADES---------->");
			Visualizacion v = new Visualizacion();
			v.readFileActividades(pathActividades);
			
			System.out.println("1. Men˙ de cliente");
			opcion = visAC.nextInt();
			if(opcion == 1) {
				opcion = menuCliente(sc);
			}
		}
		
		//APUNTARSE A ACTIVIDADES
				public static boolean apActividad(Scanner sc) throws IOException {
					
					//Variable para comprobar si los datos coinciden
					boolean checked = true;
					
					Scanner apa = new Scanner(System.in);
					int opcion = 0;
					
					System.out.println("<----------APUNTARSE A ACTIVIDADES---------->");
					
					String fecha;
					String hora;
					String idAct;
					String idSala;
					
					//PEDIDA DE ID de la actividad
					System.out.println("Ingrese ID de la actividad: ");
					idAct = apa.nextLine();
					System.out.println("Por favor, para confirmar los datos de la actividad a la que quiere apuntarse, "
							+ "introduzca la siguiente informaciÛn\n");
					System.out.println("Ingrese la fecha de la actividad: ");
					fecha = apa.nextLine();
					System.out.println("Ingrese la hora de la actividad: ");
					hora = apa.nextLine();
					System.out.println("Ingrese el ID de la sala de la actividad: ");
					idSala = apa.nextLine();
					
					//crear un nuevo lector csv
					LoginCSV lec = new LoginCSV();
					
					//Comparar valores ingresados con los del archivo csv -> se usa clase LoginCSV
					checked = lec.readFileAct(pathActividades, idAct, fecha, hora, idSala);
					
					//Si coinciden usuario y contraseÒa
					if(checked == true) {
						int[] lista = new int[200]; // Lista de n˙meros enteros que supondremos llena.
						int acumulador = 0; // Declaramos e inicializamos el acumulaador.
						for (int i = 0; i < 100; i++)
							acumulador += lista[i]; // Incrementamos el acumulador

						System.out.print("Se ha registrado con Èxito en la actividad " + idAct + "\n");
						System.out.println("1. Men˙ principal");
						opcion = apa.nextInt();
						if(opcion == 1) {
							opcion = menuPrincipal(sc);
						}
					}else {
						//Si no coinciden, se puede volver a intentar o ir atr·s
						System.out.println("Datos incorrectos");
						System.out.println("1. Volver a intentar");
						System.out.println("2. Atr·s");
						opcion = apa.nextInt();
						if(opcion == 1) {
							checked=apActividad(sc);
						}else if(opcion == 2) {
							menuCliente(sc);
						}
					}
					return checked;
				}
				
					
					//Crear una nueva actividad en "mi horario"
					//miHorario.add(new Horario(fecha, hora, idActividad, nombreAct));
					
									
						
//VISUALIZAR - REGISTRO DE CLIENTES
		
	//VISUALIZAR ACTIVIDADES COMO EXTERNO
	public static void visActividadesE(Scanner sc) throws IOException {
		Scanner visA = new Scanner(System.in);
		int opcion = 0;
		System.out.println("<----------VISUALIZAR ACTIVIDADES---------->");
		Visualizacion v = new Visualizacion();
		v.readFileActividades(pathActividades);

		System.out.println("Digite el n˙mero de su elecciÛn:");
		System.out.println("1. Registrarse/MembresÌa");
		System.out.println("2. Atr·s");
		opcion = visA.nextInt();
		if(opcion == 2) {
			opcion = menuPrincipal(sc);
		}else {
			registro(sc);
		}
	}
	
	//REGISTRO DE NUEVO CLIENTE PARA MEMBRESÕA
		public static void registro(Scanner sc) throws IOException {
			Scanner reg = new Scanner(System.in);
			boolean sesion = false;
			
			String usuario;
			String contrasena;
			String Nombre;
			String Apellido;
			String fnac;
			String correo;
			String tarjeta;
			
			
			//PEDIDA DE DATOS
			System.out.println("Ingrese usuario:");
			usuario = reg.nextLine();
			System.out.println("Ingrese contraseÒa:");
			contrasena = reg.nextLine();
			System.out.println("Ingrese Primer Nombre:");
			Nombre = reg.nextLine();
			System.out.println("Ingrese Primer Apellido:");
			Apellido = reg.nextLine();
			System.out.println("Ingrese Fecha de Nacimiento:");
			fnac = reg.nextLine();
			System.out.println("Ingrese Correo ElectrÛnico:");
			correo = reg.nextLine();
			System.out.println("Ingrese el n˙mero de su tarjeta de crÈdito:");
			tarjeta = reg.nextLine();
			
			//CREO UN NUEVO CLIENTE
			clientes.add(new Cliente(usuario, contrasena, Nombre, Apellido, fnac, correo, tarjeta));
			
			//INGRESO EL CLIENTE EN EL CSV -> USO CLASE Registro
			Registro.RegClientes(clientes, pathC);
			
			System.out.print("Usuario registrado con exito");
			
			//ME DIRIJO AL INICIO DE SESI”N DEL USUARIO
			sesion = loginCliente(sc);			
		}
}