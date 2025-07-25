package logico;

public class JefeDeProyecto extends Trabajador {
	private int cantTrabajadoresProyecto;

	public JefeDeProyecto(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String proyecto, String calificacionAnual) {
		super(cedulaTrab, nombre, apellido, direccion, genero, edad, salario, proyecto, calificacionAnual);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cantTrabajadoresProyecto
	 */
	public int getCantTrabajadoresProyecto() {
		return cantTrabajadoresProyecto;
	}

	/**
	 * @param cantTrabajadoresProyecto the cantTrabajadoresProyecto to set
	 */
	public void setCantTrabajadoresProyecto(int cantTrabajadoresProyecto) {
		this.cantTrabajadoresProyecto = cantTrabajadoresProyecto;
	}

	public boolean lideraMasDe(int cantidad) {
	    return cantTrabajadoresProyecto > cantidad;
	}

}
