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
    private static Empresa empre = null;
    public static int generadorTrab = 1;
    public static int generadorCliente = 1;
    public static int generadorContrato = 1;
    
    public static Empresa getInstance() {
		if(empre == null) {
			empre = new Empresa();
		}
		return empre;
	}
    
    private Empresa() {
    	super();
        this.misTrab = new ArrayList<>();
        this.misClientes = new ArrayList<>();
        this.contratos = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }

    public void registrarTrabajador(Trabajador t) {
         misTrab.add(t);
        generadorTrab++;
    }

       public void registrarCliente(Cliente c) {
         misClientes.add(c);
         generadorCliente++;
    }

    public boolean crearContrato(Contrato contrato) {
        Proyecto p = buscarProyecto(contrato.getNombreProyecto().getNombreProyecto());
        Cliente c = buscarCliente(contrato.getCedulaCliente());
        if (p == null || c == null || p.estaSaturado() || c.estaSaturado()) return false;
        contratos.add(contrato);
        p.agregarCliente(c);
        c.agregarProyecto();
        generadorContrato++;
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
