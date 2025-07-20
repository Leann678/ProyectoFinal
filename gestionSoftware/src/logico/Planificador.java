package logico;

public class Planificador extends Trabajador{
	private int cantDiasPlanificacion;
	
	public Planificador(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String proyecto, String calificacionAnual) {
		super(cedulaTrab, nombre, apellido, direccion, genero, edad, salario, proyecto, calificacionAnual);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the cantDiasPlanificacion
	 */
	public int getCantDiasPlanificacion() {
		return cantDiasPlanificacion;
	}
	/**
	 * @param cantDiasPlanificacion the cantDiasPlanificacion to set
	 */
	public void setCantDiasPlanificacion(int cantDiasPlanificacion) {
		this.cantDiasPlanificacion = cantDiasPlanificacion;
	}

	

}
