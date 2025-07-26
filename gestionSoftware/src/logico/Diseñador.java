package logico;

public class Diseñador extends Trabajador{

	public Diseñador(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String proyecto, String calificacionAnual, Proyecto proyectoAsignado) {
		super(cedulaTrab, nombre, apellido, direccion, genero, edad, salario, proyecto, calificacionAnual, proyectoAsignado);
		// TODO Auto-generated constructor stub
	}

		public boolean esDestacado() {
	    return calificacionAnual.equalsIgnoreCase("Destacado");
	}


}
