package logico;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombreProyecto;
    private List<Cliente> misClientes; 
   
    public Proyecto(String nombreProyecto) {
        super();
        this.nombreProyecto = nombreProyecto;
        this.misClientes = new ArrayList<>(); 
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public List<Cliente> getMisClientes() {
        return misClientes;
    }

    public void agregarCliente(Cliente cliente) {       
        if (!misClientes.contains(cliente)) {
            misClientes.add(cliente);
        }
    }

    public boolean estaSaturado() {      
        return this.misClientes.size() >= 5;
    }

    @Override
    public String toString() {
        return "Proyecto [Nombre=" + nombreProyecto + ", Clientes Asignados=" + misClientes.size() + "]";
    }
}
