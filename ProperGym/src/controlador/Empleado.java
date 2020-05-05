package controlador;


public class Empleado {

	private String nombre;
	private String apellidos;
	private String idEmpleado;
	
	public String [] getArray() {
		String [] empleados = {nombre, apellidos, idEmpleado};
		return empleados;
	}
	
	public Empleado(String nombre, String apellidos, String idEmpleado) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idEmpleado = idEmpleado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getidEmpleado() {
		return idEmpleado;
	}
	public void setidEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	
}
