package logico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
    private List<Trabajador> misTrab;
    private List<Cliente> misClientes;
    private List<Contrato> contratos;
    private List<Proyecto> proyectos;
    private static Empresa emp = null;

    private Empresa() {
        misTrab = new ArrayList<>();
        misClientes = new ArrayList<>();
        contratos = new ArrayList<>();
        proyectos = new ArrayList<>();
            }
    
    public static Empresa getInstance() {
		if(emp == null) {
			emp = new Empresa();
		}
		return emp; // contructor de la clase controladora debe ser privado, crear una variable estatica y crear un metodo estatico //
	}
	
    public boolean registrarTrabajador(Trabajador t) {
        return misTrab.add(t);
    }

       public boolean registrarCliente(Cliente c) {
        return misClientes.add(c);
    }

    public boolean crearContrato(Contrato contrato) {
        Proyecto p = buscarProyecto(contrato.getNombreProyecto().getNombreProyecto());
        Cliente c = buscarCliente(contrato.getCedulaCliente());
        if (p == null || c == null || p.estaSaturado() || c.estaSaturado()) return false;
        contratos.add(contrato);
        p.agregarCliente(c);
        c.agregarProyecto();
        return true;
    }

    public List<Contrato> obtenerContratosVencidos(LocalDate fechaActual) {
        return contratos.stream()
                .filter(c -> fechaActual.isAfter(c.getfEntrega()))
                .collect(Collectors.toList());
    }

    public void listarTrabajadoresDeProyecto(String nombreProyecto) {
        Proyecto p = buscarProyecto(nombreProyecto);
        if (p != null) {
            p.getMisTrab().forEach(System.out::println);
        }
    }

        public void mostrarProyectosDeCliente(String cedulaCliente) {
        Cliente c = buscarCliente(cedulaCliente);
        if (c != null) {
            System.out.println(c.getCantProyectos());
        }
    }

    private Proyecto buscarProyecto(String nombreProyecto) {
        return proyectos.stream()
                .filter(p -> p.getNombreProyecto().equalsIgnoreCase(nombreProyecto))
                .findFirst()
                .orElse(null);
    }

        private Cliente buscarCliente(String cedulaCliente) {
        return misClientes.stream()
                .filter(c -> c.getCedulaCliente().equalsIgnoreCase(cedulaCliente))
                .findFirst()
                .orElse(null);
    }
}