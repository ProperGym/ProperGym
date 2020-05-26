package controlador;

import java.awt.Panel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Main {
	public static String pathA = "loginA.txt";
	public static String pathC = "Clientes.csv";
	public static String pathEmpleados = "Empleados.txt";
	public static String pathActividades = "Actividades.txt";
	public static String pathClientesActividades = "ClientesActividades.csv";
	public static String logedUser;
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	static ArrayList<Actividad> actividades = new ArrayList<Actividad>();

	
public static void main(String[] args) throws IOException, MessagingException {
		
		String usuarioA = "";
		String passwordA = "";
		String usuarioC = "";
		String passwordC = "";
		
		boolean logA = false;
		boolean logC = false;
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		opcion = menuPrincipal(sc);
		
	}
	
//MEN⁄ PRINCIPAL
	public static int menuPrincipal(Scanner sc) throws IOException, MessagingException {
		System.out.println("\n\n		<-------------------BIENVENIDO A PROPERGYM--------------------->");
		System.out.println(" ___________________________________________________");
		System.out.println("|          Digite el número de su elección          |");
		System.out.println(" ---------------------------------------------------");
		System.out.println("|  1. Administrador                                 |");
		System.out.println(" ---------------------------------------------------");
		System.out.println("|  2. Cliente                                       |");
		System.out.println(" ---------------------------------------------------");
		System.out.println("|  3. Visualizar Actividades/Registro membresía     |");
		System.out.println("|___________________________________________________|");
		//System.out.println("4. ProperGym - InformaciÛn");
		
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
		public static boolean loginAdministrador(Scanner sc) throws IOException, MessagingException {
			
			//Variable para comprobar si usuario y password coinciden
			boolean logeado = true;
			
			String usuarioA;
			String passwordA;
			
			int opcion = 0;
			Scanner admi = new Scanner(System.in);
			System.out.println("\n---------------------");
			System.out.println("LOGIN ADMINISTRADOR");
			System.out.println("---------------------");
			System.out.println("INGRESAR USUARIO");
			usuarioA = admi.nextLine();
			System.out.println("INGRESAR CONTRASEÑA");
			passwordA = admi.nextLine();
			
			//crear un nuevo lector csv
			LoginCSV lec = new LoginCSV();
			
			//Comparar valores ingresados con los del archivo csv -> se usa clase LoginCSV
			logeado = lec.readFileA(pathA, usuarioA, passwordA);
			
			//Si coinciden usuario y contraseÒa
			if(logeado == true) {
				//nos dirigimos al men˙ del Administrador
				menuA(sc);
			}else {
				//Si no coinciden, se puede volver a intentar o ir atr·s
				System.out.println("LOGIN INCORRECTO");
				System.out.println("1. Volver a intentar");
				System.out.println("2. Atrás");
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
		public static int menuA(Scanner sc) throws IOException, MessagingException {
			Scanner vis = new Scanner(System.in);
			int opcion = 0;
			System.out.println(" ___________________________________________________");
			System.out.println("|                 MENU ADMINISTRADOR                |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  1. Administrar Actividades                       |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  2. Administrar Empleados                         |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  3. Generar Informes                              |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  4. Salir                                         |");
			System.out.println("____________________________________________________");
			opcion = vis.nextInt();
			switch (opcion) {
			case 1:
				admActividades(sc);
				break;
			case 2:
				admEmpleados(sc);
				break;
			case 3:
				menuCSVl(sc);
				break;
			case 4:
				menuPrincipal(sc);
				break;
			}
			return opcion;
		}
		
		
		private static int menuCSVl(Scanner sc) throws IOException, MessagingException {
			Scanner vis = new Scanner(System.in);
			int opcion = 0;
			System.out.println(" ___________________________________________________");
			System.out.println("|                 Informes                          |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  Actividades                                   |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  Clientes                                      |");
			System.out.println(" ---------------------------------------------------");
			System.out.println("|  Enviar por correo                             |");
			System.out.println(" ---------------------------------------------------");
			System.out.print("Se generaron los informes y se enviará a la cuenta determinada");

			Properties propiedad = new Properties();
	        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
	        propiedad.setProperty("mail.smtp.starttls.enable", "true");
	        propiedad.setProperty("mail.smtp.port", "587");
	        Session sesion = Session.getDefaultInstance(propiedad);
	        String correoEnvia = "jazminsoria191998@gmail.com";
	        String contrasena = "6Br#0Yes";
	        String receptor = "jazminsoria191998@gmail.com";
	        String asunto = "Prueba Proyecto Ingenieria";
	        String mensaje= "Prueba txt";
	        
	        BodyPart adjunto = new MimeBodyPart();
	        adjunto.setDataHandler(new DataHandler(new FileDataSource(pathActividades)));
	        adjunto.setFileName(pathActividades);
	        
	        MimeMultipart m = new MimeMultipart();
	        m.addBodyPart(adjunto);
	        MimeMessage mail = new MimeMessage(sesion);
	        try {
	            mail.setFrom(new InternetAddress (correoEnvia));
	            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
	            mail.setSubject(asunto);
	            mail.setText(mensaje);
	            mail.setContent(m);
	            
	            Transport transportar = sesion.getTransport("smtp");
	            transportar.connect(correoEnvia,contrasena);
	            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
	            transportar.close();
	            
	        } catch (AddressException ex) {
	            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (MessagingException ex) {
	            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        System.out.print("\nIngresa 1 para volver");
	        opcion = vis.nextInt();
	        if(opcion ==1) {
	        	opcion=menuA(sc);
	        }
			return opcion;
			
		}

		//ADMINISTRAR ACTIVIDADES
			public static int admActividades(Scanner sc) throws IOException, MessagingException {
				Scanner admA = new Scanner(System.in);
				int opcion = 0;
				Visualizacion v = new Visualizacion();
				v.readFileActividades(pathActividades);
				
				System.out.println("\n1. Añadir Actividad");
				System.out.println("2. Modificar Actividad");
				System.out.println("3. Eliminar Actividad");
				System.out.println("4. Atrás");
				
				opcion = admA.nextInt();
				
				
				switch (opcion) {
				case 1:
					agregarAct(sc);
					break;
				case 2:
					modActividad(sc);
					break;
				case 3:
					elimActividad(sc);
					break;
				case 4:
					menuPrincipal(sc);
					break;
				}
				return opcion;
			}
			
	
		//ELIMINAR ACTIVIDADES
		private static void elimActividad(Scanner sc) throws IOException, MessagingException {
			Scanner mod = new Scanner(System.in);
			int opcion = 0;
			System.out.println("\n--------------------");
			System.out.println("ELIMINAR ACTIVIDAD\n");
			System.out.println("--------------------");
			
			Modificacion.deleteRecordAct();
			opcion = admActividades(sc);
			
		}

		//AGREGAR ACTIVIDADES
		private static void agregarAct(Scanner sc) throws IOException, MessagingException {
			 	Scanner agAct = new Scanner(System.in);
			 	int opcion = 0;
				
			 	String nombre;
				String idAct;
				String idSala;
				int capacidadSala;
				String fecha;
				String hora;
				String idEmpleado;
				int maxParticipantes;
				int nParticipantes = 0;
				
				System.out.println("\n--------------------");
				System.out.println("AGREGAR ACTIVIDAD");
				System.out.println("--------------------");
				
				//PEDIDA DE DATOS
				System.out.println("Ingrese nombre de la actividad:");
				nombre = agAct.nextLine();
				System.out.println("Ingrese ID de actividad:");
				idAct = agAct.nextLine();
				System.out.println("Ingrese ID de sala:");
				idSala = agAct.nextLine();
				System.out.println("Ingrese capacidad de la sala:");
				capacidadSala = agAct.nextInt();
				agAct.nextLine(); //separaciÛn despuÈs de nextInt
				System.out.println("Ingrese ID del entrenador:");
				idEmpleado = agAct.nextLine();
				System.out.println("Ingrese fecha de la actividad:");
				fecha = agAct.nextLine();
				System.out.println("Ingrese hora de la actividad:     (hh:mm)");
				hora = agAct.nextLine();
				System.out.println("Indique si es individual (1) o grupal (2):");
				int option = agAct.nextInt();
				if (option == 1) {
					maxParticipantes = 1;
				}
				else {
					maxParticipantes = capacidadSala;
				}
				
				//CREO UNA NUEVA ACTIVIDAD
				actividades.add(new Actividad(nombre, idAct, idSala, capacidadSala, fecha, hora, idEmpleado, maxParticipantes, nParticipantes));
				
				//INGRESO EL CLIENTE EN EL CSV -> USO CLASE REGCLIENTE
				Registro.RegActividades(actividades, pathActividades);
				
				System.out.print("Actividad " + idAct + " registrada con éxito.\n");
				opcion = admActividades(sc);
		}
		
		//MODIFICAR ACTIVIDADES
				private static void modActividad(Scanner sc) throws IOException, MessagingException {
					Scanner mod = new Scanner(System.in);
					int opcion = 0;
					System.out.println("\n--------------------");
					System.out.println("MODIFICAR ACTIVIDAD");
					System.out.println("--------------------");
					
					
					Modificacion.editRecordAct();
					opcion = admActividades(sc);
								
				}
				
					
		//ADMINISTRAR ENTRENADORES
		public static int admEmpleados(Scanner sc) throws IOException, MessagingException {
			Scanner adm = new Scanner(System.in);
			int opcion = 0;
			Visualizacion v = new Visualizacion();
			v.readFileEmpleados(pathEmpleados);
			
			System.out.println("1. Agregar empleados");
			System.out.println("2. Modificar datos de empleados");
			System.out.println("3. Eliminar empleados");
			System.out.println("4. Atrás");
			
			opcion = adm.nextInt();
			switch (opcion) {
			case 1:
				regEmpleados(sc);
				break;
			case 2:
				modEmpleados(sc);
				break;
			case 3:
				elimEmpleados(sc);
				break;
			case 4:
				menuA(sc);
				break;
			}
			return opcion;
		}
		
		
		private static void elimEmpleados(Scanner sc) throws IOException, MessagingException {
			Scanner mod = new Scanner(System.in);
			int opcion = 0;
			
			System.out.println("\n--------------------");
			System.out.println("ELIMINAR EMPLEADO");
			System.out.println("--------------------\n");
			
			
			Modificacion.deleteRecordEmp();
			opcion = admEmpleados(sc);
			
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
				
				System.out.print("Empleado registrado con éxito");
		}
			
			//MODIFICAR EMPLEADO
		public static void modEmpleados(Scanner sc) throws IOException, MessagingException {
				Scanner mod = new Scanner(System.in);
				int opcion = 0;
				
				System.out.println("\n--------------------");
				System.out.println("  MODIFICAR EMPLEADO");
				System.out.println("--------------------\n");
				
				Modificacion.editRecordEmp();
				opcion = admEmpleados(sc);
				
		}
			
		
			
//CLIENTE		
		//LOGIN DEL CLIENTE
		public static boolean loginCliente(Scanner sc) throws IOException, MessagingException {
			
			//Variable para comprobar que usuario y contraseÒa coinciden
			boolean logeado = true;
			
			String usuarioC;
			String passwordC;
			
			int opcion = 0;
			Scanner cliente = new Scanner(System.in);
			
			System.out.println("\n--------------------");
			System.out.println("   LOGIN CLIENTE");
			System.out.println("--------------------");
			System.out.println("Ingrese su usuario:");
			usuarioC = cliente.nextLine();
			System.out.println("Ingrese su contraseña:");
			passwordC = cliente.nextLine();
			
			//CREO UN NUEVO LECTOR CSV
			LoginCSV lec = new LoginCSV();
			
			//COMPARO VALORES INGRESADOS CON LOS DEL ARCHIVO CSV -> USO CLASE LOGINCSV
			logeado = lec.readFileA(pathC, usuarioC, passwordC);
			logedUser = usuarioC; //guarda el usuario logeado
			
			if(logeado == true) {
				menuCliente(sc);
			}else {
				System.out.println("\nLogin Incorrecto - Los datos no coinciden");
				System.out.println("1. Volver a intentar");
				System.out.println("2. Atrás");
				opcion = cliente.nextInt();
				if(opcion == 1) {
					logeado=loginCliente(sc);
				}else if(opcion == 2) {
					menuPrincipal(sc);
				}
			}
			return logeado;
		}
	
		//MEN⁄ CLIENTE
		public static int menuCliente(Scanner sc) throws IOException, MessagingException {
			Scanner mec = new Scanner(System.in);
			int opcion = 0;
			System.out.println("\n--------------------");
			System.out.println("   MI HORARIO");
			System.out.println("--------------------\n");
			
			Visualizacion v = new Visualizacion();
			v.readFileClientesActividades(pathClientesActividades, logedUser);
			
			System.out.println("\n1. Apuntarse a una actividad");
			System.out.println("2. Salir");
			opcion = mec.nextInt();
			
			switch (opcion) {
			case 1:
				apActividad(sc);
				break;
			case 2:
				menuPrincipal(sc);
				break;
			}
			return opcion;
		}
		
		
		//APUNTARSE A ACTIVIDADES
				public static boolean apActividad(Scanner sc) throws IOException, MessagingException {
					
					//Variable para comprobar si los datos coinciden
					boolean checked = true;
					
					Scanner apa = new Scanner(System.in);
					int opcion = 0;
					
					System.out.println("\n--------------------");
					System.out.println("APUNTARSE A ACTIVIDAD");
					System.out.println("--------------------\n");
					Visualizacion v = new Visualizacion();
					v.readFileActividades(pathActividades);
					
					String fecha;
					String hora;
					String idAct;
					String idSala;
					
					//PEDIDA DE ID de la actividad
					System.out.println("Ingrese el ID de la actividad a la que quiere apuntarse: ");
					idAct = apa.nextLine();
					System.out.println("Por favor, confirme los siguientes datos sobre la actividad " + idAct);
					System.out.println("Ingrese la fecha de la actividad:     (dd/mm/yyyy)");
					fecha = apa.nextLine();
					System.out.println("Ingrese la hora de la actividad:     (hh:mm)");
					hora = apa.nextLine();
					System.out.println("Ingrese el ID de la sala de la actividad: ");
					idSala = apa.nextLine();
					
					//crear un nuevo lector csv
					LoginCSV lec = new LoginCSV();
					
					//Comparar valores ingresados con los del archivo csv -> se usa clase LoginCSV
					checked = lec.readFileAct(pathActividades, idAct, fecha, hora, idSala);
					
					//Si coinciden los datos
					if(checked == true) {
						Registro.RegClientesAct(idAct, idSala, fecha, hora, logedUser, pathClientesActividades);
						menuCliente(sc);
						
					}else {
						//Si no coinciden, se puede volver a intentar o ir atr·s
						System.out.println("\nDatos incorrectos");
						System.out.println("1. Volver a intentar");
						System.out.println("2. Atrás");
						opcion = apa.nextInt();
						if(opcion == 1) {
							checked=apActividad(sc);
						}else if(opcion == 2) {
							menuCliente(sc);
						}
					}
					return checked;
				}
				
					
									
						
//VISUALIZAR - REGISTRO DE CLIENTES
		
	//VISUALIZAR ACTIVIDADES COMO EXTERNO
	public static void visActividadesE(Scanner sc) throws IOException, MessagingException {
		Scanner visA = new Scanner(System.in);
		int opcion = 0;
		Visualizacion v = new Visualizacion();
		v.readFileActividades(pathActividades);

		System.out.println("\nDigite el número de su elección:");
		System.out.println("1. Registrarse/MembresÌa");
		System.out.println("2. Atrás");
		opcion = visA.nextInt();
		if(opcion == 1) {
			opcion = registro(sc);
		}else if (opcion == 2){
			opcion = menuPrincipal(sc);
		}
	}
	
	//REGISTRO DE NUEVO CLIENTE PARA MEMBRESÕA
		public static int registro(Scanner sc) throws IOException, MessagingException {
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
			System.out.println("\n--------------------");
			System.out.println("REGISTRO MEMBRESIA");
			System.out.println("--------------------");
			System.out.println("Ingrese usuario:");
			usuario = reg.nextLine();
			System.out.println("Ingrese contraseña:");
			contrasena = reg.nextLine();
			System.out.println("Ingrese Primer Nombre:");
			Nombre = reg.nextLine();
			System.out.println("Ingrese Primer Apellido:");
			Apellido = reg.nextLine();
			System.out.println("Ingrese Fecha de Nacimiento:");
			fnac = reg.nextLine();
			System.out.println("Ingrese Correo Electrónico:");
			correo = reg.nextLine();
			System.out.println("Ingrese el número de su tarjeta de crédito:");
			tarjeta = reg.nextLine();
			
			//CREO UN NUEVO CLIENTE
			clientes.add(new Cliente(usuario, contrasena, Nombre, Apellido, fnac, correo, tarjeta));
			
			//INGRESO EL CLIENTE EN EL CSV -> USO CLASE REGISTRO
			Registro.RegClientes(clientes, pathC);
			
			System.out.print("Usuario registrado con éxito\n");
			
			//ME DIRIJO AL INICIO DE SESI”N DEL USUARIO
			sesion = loginCliente(sc);
			return 0;			
		}
}