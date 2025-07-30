package logico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

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
        return emp;
    }

    public boolean registrarTrabajador(Trabajador t) {
        if (t == null) {
            System.err.println("Error (registrarTrabajador): Trabajador es null.");
            return false;
        }

        return misTrab.add(t);
    }
    public List<Trabajador> getMisTrab() {
        return misTrab;
    }

    public boolean registrarCliente(Cliente c) {
        if (c == null) {
            System.err.println("Error (registrarCliente): Cliente es null.");
            return false;
        }
        if (buscarCliente(c.getCedulaCliente()) != null) {
            System.err.println("Error (registrarCliente): Cliente con cédula " + c.getCedulaCliente() + " ya existe. No se registrará duplicado.");
            return false;
        }
        System.out.println("DEBUG (Empresa): Registrando cliente: " + c.getCedulaCliente());
        return misClientes.add(c);
    }
    public List<Cliente> getMisClientes() {
        return misClientes;
    }
    public Cliente buscarCliente(String cedulaCliente) {
        return misClientes.stream()
                .filter(c -> c.getCedulaCliente().equalsIgnoreCase(cedulaCliente))
                .findFirst()
                .orElse(null);
    }

    public boolean registrarProyecto(Proyecto p) {
        if (p == null) {
            System.err.println("Error (registrarProyecto): Proyecto es null.");
            return false;
        }
        if (buscarProyecto(p.getNombreProyecto()) != null) {
            System.err.println("Error (registrarProyecto): Proyecto con nombre " + p.getNombreProyecto() + " ya existe. No se registrará duplicado.");
            return false;
        }
        System.out.println("DEBUG (Empresa): Registrando proyecto: " + p.getNombreProyecto());
        return proyectos.add(p);
    }
    public List<Proyecto> getMisProyectos() {
        return proyectos;
    }
    public Proyecto buscarProyecto(String nombreProyecto) {
        return proyectos.stream()
                .filter(p -> p.getNombreProyecto().equalsIgnoreCase(nombreProyecto))
                .findFirst()
                .orElse(null);
    }

    public List<Proyecto> getProyectosConTrabajadoresAsignados() {
        Set<Proyecto> uniqueProjects = new HashSet<>();
        for (Trabajador trabajador : misTrab) {
            Proyecto proyectoAsignado = trabajador.getProyectoAsignado();
            if (proyectoAsignado != null) {
                uniqueProjects.add(proyectoAsignado);
            }
        }
        return new ArrayList<>(uniqueProjects);
    }


    public boolean concederContrato(Contrato contrato) {
        if (contrato == null || contrato.getIdContrato() == null || contrato.getIdContrato().isEmpty() ||
            contrato.getCedulaCliente() == null || contrato.getCedulaCliente().isEmpty() ||
            contrato.getNombreProyecto() == null || contrato.getNombreProyecto().getNombreProyecto().isEmpty()) {
            System.err.println("Error (concederContrato): Datos de contrato incompletos o inválidos.");
            return false;
        }

        if (contratos.stream().anyMatch(c -> c.getIdContrato().equalsIgnoreCase(contrato.getIdContrato()))) {
            System.err.println("Error (concederContrato): Ya existe un contrato con el ID: " + contrato.getIdContrato());
            return false;
        }

        Cliente clienteAsociadoExistente = buscarCliente(contrato.getCedulaCliente());
        if (clienteAsociadoExistente == null) {
            System.out.println("DEBUG (concederContrato): Cliente con cédula " + contrato.getCedulaCliente() + " no encontrado en Empresa. Intentando registrarlo automáticamente...");
            Cliente nuevoClienteParaRegistro = new Cliente(
                "TEMP_Nombre_Auto",
                "TEMP_Apellido_Auto",
                contrato.getCedulaCliente(),
                "TEMP_Direccion_Auto",
                0
            );
            if (!registrarCliente(nuevoClienteParaRegistro)) {
                System.err.println("Error (concederContrato): Fallo al registrar nuevo cliente automáticamente (posiblemente duplicado).");
                return false;
            }
            clienteAsociadoExistente = nuevoClienteParaRegistro; 
        }

        Proyecto proyectoAsociadoExistente = buscarProyecto(contrato.getNombreProyecto().getNombreProyecto());
        if (proyectoAsociadoExistente == null) {
            System.out.println("DEBUG (concederContrato): Proyecto con nombre " + contrato.getNombreProyecto().getNombreProyecto() + " no encontrado en Empresa. Intentando registrarlo automáticamente...");
            Proyecto nuevoProyectoParaRegistro = new Proyecto(contrato.getNombreProyecto().getNombreProyecto());
            if (!registrarProyecto(nuevoProyectoParaRegistro)) {
                System.err.println("Error (concederContrato): Fallo al registrar nuevo proyecto automáticamente (posiblemente duplicado).");
                return false;
            }
            proyectoAsociadoExistente = nuevoProyectoParaRegistro; 
        }

        
        if (clienteAsociadoExistente == null || proyectoAsociadoExistente == null) {
            System.err.println("ERROR FATAL (concederContrato): Cliente o Proyecto son NULL después de buscar/auto-registrar. Esto no debería ocurrir.");
            return false;
        }


        if (proyectoAsociadoExistente.estaSaturado()) {
            System.err.println("Error (concederContrato): El proyecto '" + proyectoAsociadoExistente.getNombreProyecto() + "' ya está saturado (máx. 5 clientes).");
            return false;
        }
        if (clienteAsociadoExistente.estaSaturado()) {
            System.err.println("Error (concederContrato): El cliente '" + clienteAsociadoExistente.getNombre() + "' ya está saturado (máx. 5 proyectos).");
            return false;
        }

        
        contratos.add(contrato);
        if (!proyectoAsociadoExistente.getMisClientes().contains(clienteAsociadoExistente)) {
            proyectoAsociadoExistente.agregarCliente(clienteAsociadoExistente);
        }
        
        clienteAsociadoExistente.agregarProyecto();

        System.out.println("DEBUG (Empresa): Contrato '" + contrato.getIdContrato() + "' concedido con éxito.");
        return true;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public List<Contrato> obtenerContratosVencidos(LocalDate fechaActual) {
        return contratos.stream()
                .filter(c -> fechaActual.isAfter(c.getfEntrega()))
                .collect(Collectors.toList());
    }

 
    public void mostrarProyectosDeCliente(String cedulaCliente) {
        Cliente c = buscarCliente(cedulaCliente);
        if (c != null) {
            System.out.println(c.getCantProyectos());
        }
    }
}
