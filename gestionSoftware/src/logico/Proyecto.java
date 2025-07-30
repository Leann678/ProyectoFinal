package logico;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Proyecto {
	private String nombreProyecto;
	private ArrayList<Trabajador>misTrab;
	private ArrayList<Cliente>misClientes;
	private Contrato contrato;
	
	
	public Proyecto(String nombreProyecto, ArrayList<Trabajador> misTrab, ArrayList<Cliente> misClientes, Contrato contrato) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.misTrab = new ArrayList<>();
	    this.setContrato(contrato);
	}
	
	public Proyecto(String text) {
		this.nombreProyecto = text;
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

	/**
	 * @return the contrato
	 */
	public Contrato getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}
