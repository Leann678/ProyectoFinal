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
