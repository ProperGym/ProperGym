package controlador;

public class Cliente {
	
	private String usuario;
	private String contra;
	private String nombre;
	private String apellido;
	private String fnac;
	private String correo;
	private String tarjeta;
	
	
	
	public Cliente(String usuario, String contra, String nombre, String apellido, String fnac, String correo, String tarjeta) {
		this.usuario = usuario;
		this.contra = contra;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnac = fnac;
		this.correo = correo;
		this.tarjeta = tarjeta;
	}
	
	public String [] getArray() {
		String [] usuarios = {usuario, contra, nombre, apellido, fnac, correo,tarjeta};
		return usuarios;
	}
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha() {
		return fnac;
	}

	public void setFecha(String fecha) {
		this.fnac = fnac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
}
