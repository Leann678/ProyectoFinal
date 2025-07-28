package logico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Proyecto {
	private String nombreProyecto;
	private ArrayList<Trabajador>misTrab;
	private ArrayList<Cliente>misClientes;
	public Proyecto(String nombreProyecto, ArrayList<Trabajador> misTrab, ArrayList<Cliente> misClientes) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.misTrab = new ArrayList<>();
	    this.misClientes = new ArrayList<>();	
	}
	
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
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
