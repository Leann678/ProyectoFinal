package logico;

import java.util.ArrayList;

public class Cliente {
    private String cedulaCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private int cantProyectos;

    public Cliente(String cedulaCliente, String nombre, String apellido, String direccion, String telefono, String email) {
        super();
        this.cedulaCliente = cedulaCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.cantProyectos = 0;
    }

 .
    public Cliente(String nombre, String apellido, String cedulaCliente, String direccion, int cantProyectos) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedulaCliente = cedulaCliente;
        this.direccion = direccion;
        this.cantProyectos = cantProyectos;
        this.telefono = ""; 
        this.email = "";
    }

    // --- Getters y Setters ---
    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCantProyectos() {
        return cantProyectos;
    }

    public void agregarProyecto() {
        this.cantProyectos++;
    }

    public boolean estaSaturado() {
        return this.cantProyectos >= 3; 
    }

    @Override
    public String toString() {
        return "Cliente [Cedula=" + cedulaCliente + ", Nombre=" + nombre + " " + apellido +
               ", Direccion=" + direccion + ", Telefono=" + telefono + ", Email=" + email +
               ", Proyectos Asignados=" + cantProyectos + "]";
    }
}
