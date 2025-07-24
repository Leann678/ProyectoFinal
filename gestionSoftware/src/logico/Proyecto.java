package logico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Proyecto {
	private String nombre;
	private ArrayList<Trabajador>misTrab;
	private ArrayList<Cliente>misClientes;
	public Proyecto(String nombre, ArrayList<Trabajador> misTrab, ArrayList<Cliente> misClientes) {
		super();
		this.nombre = nombre;
		this.misTrab = new ArrayList<>();
	    this.misClientes = new ArrayList<>();	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Trabajador> getMisTrab() {
		return misTrab;
	}
	public void setMisTrab(ArrayList<Trabajador> misTrab) {
		this.misTrab = misTrab;
	}
	public List<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	
	public boolean agregarCliente(Cliente cliente) {
	    if (misClientes.size() >= 5) return false;
	    return misClientes.add(cliente);
	}

	public boolean estaSaturado() {
	    return misClientes.size() >= 5;
	}

	public void agregarTrabajador(Trabajador trabajador) {
		misTrab.add(trabajador);
	}

	public ArrayList<Trabajador> obtenerTrabajadoresPorRol(String rol) {
	    return misTrab.stream()
	        .filter(t -> t.getClass().getSimpleName().equalsIgnoreCase(rol))
	        .collect(Collectors.toCollection(ArrayList::new));

	}

}
