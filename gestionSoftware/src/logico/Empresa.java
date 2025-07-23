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

    public Empresa() {
        misTrab = new ArrayList<>();
        misClientes = new ArrayList<>();
        contratos = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public boolean registrarTrabajador(Trabajador t) {
        return misTrab.add(t);
    }

       public boolean registrarCliente(Cliente c) {
        return misClientes.add(c);
    }

    public boolean crearContrato(Contrato contrato) {
        Proyecto p = buscarProyecto(contrato.getProyecto().getNombre());
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

}
