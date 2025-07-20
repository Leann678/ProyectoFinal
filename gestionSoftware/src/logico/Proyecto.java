package logico;

import java.util.List;

public class Proyecto {
	private String nombre;
	private List<Trabajador>misTrab;
	private List<Cliente>misClientes;
	public Proyecto(String nombre, List<Trabajador> misTrab, List<Cliente> misClientes) {
		super();
		this.nombre = nombre;
		this.misTrab = misTrab;
		this.misClientes = misClientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Trabajador> getMisTrab() {
		return misTrab;
	}
	public void setMisTrab(List<Trabajador> misTrab) {
		this.misTrab = misTrab;
	}
	public List<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(List<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

}
