package logico;

public class Planificador extends Trabajador{
	private int cantDiasPlanificacion;
	
	public Planificador(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String calificacionAnual, Proyecto proyectoAsignado) {
		super(cedulaTrab, nombre, apellido, direccion, genero, edad, salario, calificacionAnual, proyectoAsignado);
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

	public boolean planificaCadaXDias(int dias) {
	    return cantDiasPlanificacion == dias;
	}

}
