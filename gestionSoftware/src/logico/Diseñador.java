
package logico;

public class Dise�ador extends Trabajador{

	public  Dise�ador(String cedulaTrab, String nombre, String apellido, String direccion, String genero, int edad,
			float salario, String calificacionAnual, Proyecto proyectoAsignado) {
		super(cedulaTrab, nombre, apellido, direccion, genero, edad, salario, calificacionAnual, proyectoAsignado, calificacionAnual, calificacionAnual);
		// TODO Auto-generated constructor stub
	}

		public boolean esDestacado() {
	    return calificacionAnual.equalsIgnoreCase("Destacado");
	}


}







