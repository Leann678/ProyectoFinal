package logico;

public class Programador extends Trabajador {
	private String lenguaje;
	
	public Programador(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String proyecto, String calificacionAnual) {
		super(cedulaTrab, nombre, apellido, direccion, genero, edad, salario, proyecto, calificacionAnual);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the lenguaje
	 */
	public String getLenguaje() {
		return lenguaje;
	}

	/**
	 * @param lenguaje the lenguaje to set
	 */
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public boolean programaEn(String lenguaje) {
	    return lenguaje.equalsIgnoreCase(lenguaje);
	}

	

}
