package logico;

public class Cliente {
	private String nombre;
	private String apellido;
	private String cedulaCliente;
	private String direccion;
	private int cantProyectos;
	
	public Cliente(String nombre, String apellido, String cedulaCliente, String direccion, int cantProyectos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedulaCliente = cedulaCliente;
		this.direccion = direccion;
		this.cantProyectos = cantProyectos;
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

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantProyectos() {
		return cantProyectos;
	}

	public void setCantProyectos(int cantProyectos) {
		this.cantProyectos = cantProyectos;
	}
}
