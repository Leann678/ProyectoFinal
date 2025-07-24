package logico;

public class Trabajador {
	protected String cedulaTrab;
	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected String genero;
	protected int edad;
	protected float salario;
	protected String proyecto;
	protected String calificacionAnual;
	
	public Trabajador(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String proyecto, String calificacionAnual) {
		super();
		this.cedulaTrab = cedulaTrab;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.genero = genero;
		this.edad = edad;
		this.salario = salario;
		this.proyecto = proyecto;
		this.calificacionAnual = calificacionAnual;
	}

	public String getCedulaTrab() {
		return cedulaTrab;
	}

	public void setCedulaTrab(String cedulaTrab) {
		this.cedulaTrab = cedulaTrab;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getCalificacionAnual() {
		return calificacionAnual;
	}

	public void setCalificacionAnual(String calificacionAnual) {
		this.calificacionAnual = calificacionAnual;
	}

	@Override
	public String toString() {
	    return "ID: " + cedulaTrab + ", Nombre: " + nombre + " " + apellido +
	           ", Dirección: " + direccion + ", Genero: " + genero +
	           ", Edad: " + edad + ", Salario: $" + salario +
	           ", Proyecto: " + Proyecto + ", Calificación Anual: " + calificacionAnual;
	}


}
