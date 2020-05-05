package controlador;

//import java.util.Date; //para la fecha si se quiere en formato oficial

public class Actividad {
	
	private String nombre;
	private String idAct;
	private String idSala;
	private int capacidadSala;
	private String fecha;
	private String hora;
	private String idEmpleado;
	private int maxParticipantes;
	private int nParticipantes;
	
	public Actividad(String nombre, String idAct, String idSala, int capacidadSala, String fecha, String hora, String idEmpleado,
			int maxParticipantes, int nParticipantes) {
		super();
		this.nombre = nombre;
		this.idAct = idAct;
		this.idSala = idSala;
		this.capacidadSala = capacidadSala;
		this.fecha = fecha;
		this.hora = hora;
		this.idEmpleado = idEmpleado;
		this.maxParticipantes = maxParticipantes;
		this.nParticipantes = nParticipantes;
	}

	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	public int getCapacidadSala() {
		return capacidadSala;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdAct() {
		return idAct;
	}

	public void setIdAct(String idAct) {
		this.idAct = idAct;
	}

	public void setCapacidadSala(int aforo) {
		this.capacidadSala = aforo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String empleado) {
		this.idEmpleado = empleado;
	}
	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}
	public int getnParticipantes() {
		return nParticipantes;
	}
	public void setnParticipantes(int nParticipantes) {
		this.nParticipantes = nParticipantes;
	}

}

