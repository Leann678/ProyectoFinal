package conexion;

import logico.Proyecto;
import logico.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {
    private Connection conexion;

    public ProyectoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // OPERACIONES CRUD

    /**
     * Inserta un nuevo proyecto en la base de datos (solo guarda el nombre).
     */
    public void insertar(Proyecto proyecto) throws SQLException {
        String sql = "INSERT INTO Proyecto (nombre_proyecto) VALUES (?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, proyecto.getNombreProyecto());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un proyecto por su nombre.
     */
    public void eliminar(String nombreProyecto) throws SQLException {
        String sql = "DELETE FROM Proyecto WHERE nombre_proyecto = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProyecto);
            stmt.executeUpdate();
        }
    }

    /**
     * Verifica si un proyecto existe en la base de datos.
     */
    public boolean existeProyecto(String nombreProyecto) throws SQLException {
        String sql = "SELECT 1 FROM Proyecto WHERE nombre_proyecto = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProyecto);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Lista todos los proyectos registrados en la base de datos.
     */
    public List<String> listarNombresProyectos() throws SQLException {
        List<String> proyectos = new ArrayList<>();
        String sql = "SELECT nombre_proyecto FROM Proyecto";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                proyectos.add(rs.getString("nombre_proyecto"));
            }
        }
        return proyectos;
    }

    // MÉTODOS PARA CLIENTES DEL PROYECTO (EN MEMORIA)
    /**
     * Carga los clientes de un proyecto desde la tabla Contrato.
     */
    public List<Cliente> cargarClientesDelProyecto(String nombreProyecto, ClienteDAO clienteDAO) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT DISTINCT cedula_cliente FROM Contrato WHERE nombre_proyecto = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProyecto);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = clienteDAO.buscarPorCedula(rs.getString("cedula_cliente"));
                    if (cliente != null) {
                        clientes.add(cliente);
                    }
                }
            }
        }
        return clientes;
    }

    /**
     * Crea un objeto Proyecto con sus clientes cargados desde la BD.
     */
    public Proyecto cargarProyectoCompleto(String nombreProyecto, ClienteDAO clienteDAO) throws SQLException {
        if (!existeProyecto(nombreProyecto)) {
            return null;
        }
        Proyecto proyecto = new Proyecto(nombreProyecto);
        List<Cliente> clientes = cargarClientesDelProyecto(nombreProyecto, clienteDAO);
        for (Cliente cliente : clientes) {
            proyecto.agregarCliente(cliente);
        }
        return proyecto;
    }
    
    /**
     * Busca un proyecto por su nombre.
     */
    public Proyecto buscarPorNombre(String nombreProyecto) throws SQLException {
        String sql = "SELECT * FROM Proyecto WHERE nombre_proyecto = ?";
        Proyecto proyecto = null;
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProyecto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    proyecto = new Proyecto(rs.getString("nombre_proyecto"));
                    // Si necesitas cargar clientes asociados:
                    // proyecto.setMisClientes(cargarClientesDelProyecto(nombreProyecto, clienteDAO));
                }
            }
        }
        return proyecto;
    }
}
