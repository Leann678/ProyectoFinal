package conexion;

import logico.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
	
	 private Connection conexion; // Debes inicializar esto (Singleton, Pool, etc.)

	    // Constructor que recibe la conexión
	    public ClienteDAO(Connection conexion) {
	        this.conexion = conexion;
	    }

	    // OPERACIONES CRUD

	    /**
	     * Inserta un nuevo cliente en la base de datos.
	     */
	    public void insertar(Cliente cliente) throws SQLException {
	        String sql = "INSERT INTO Cliente (cedula_cliente, nombre, apellido, direction, telefono, email, cant_proyectos) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setString(1, cliente.getCedulaCliente());
	            stmt.setString(2, cliente.getNombre());
	            stmt.setString(3, cliente.getApellido());
	            stmt.setString(4, cliente.getDireccion());
	            stmt.setString(5, cliente.getTelefono());
	            stmt.setString(6, cliente.getEmail());
	            stmt.setInt(7, cliente.getCantProyectos());
	            stmt.executeUpdate();
	        }
	    }

	    /**
	     * Actualiza un cliente existente.
	     */
	    public void actualizar(Cliente cliente) throws SQLException {
	        String sql = "UPDATE Cliente SET nombre = ?, apellido = ?, direction = ?, telefono = ?, email = ?, " +
	                     "cant_proyectos = ? WHERE cedula_cliente = ?";
	        
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setString(1, cliente.getNombre());
	            stmt.setString(2, cliente.getApellido());
	            stmt.setString(3, cliente.getDireccion());
	            stmt.setString(4, cliente.getTelefono());
	            stmt.setString(5, cliente.getEmail());
	            stmt.setInt(6, cliente.getCantProyectos());
	            stmt.setString(7, cliente.getCedulaCliente());
	            stmt.executeUpdate();
	        }
	    }

	    /**
	     * Elimina un cliente por su cédula.
	     */
	    public void eliminar(String cedula) throws SQLException {
	        String sql = "DELETE FROM Cliente WHERE cedula_cliente = ?";
	        
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setString(1, cedula);
	            stmt.executeUpdate();
	        }
	    }

	    /**
	     * Busca un cliente por su cédula.
	     */
	    public Cliente buscarPorCedula(String cedula) throws SQLException {
	        String sql = "SELECT * FROM Cliente WHERE cedula_cliente = ?";
	        Cliente cliente = null;
	        
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setString(1, cedula);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    cliente = new Cliente(
	                        rs.getString("nombre"),
	                        rs.getString("apellido"),
	                        rs.getString("cedula_cliente"),
	                        rs.getString("direction"),
	                        rs.getInt("cant_proyectos")
	                    );
	                    cliente.setTelefono(rs.getString("telefono"));
	                    cliente.setEmail(rs.getString("email"));
	                }
	            }
	        }
	        return cliente;
	    }

	    /**
	     * Obtiene todos los clientes de la base de datos.
	     */
	    public List<Cliente> listarTodos() throws SQLException {
	        List<Cliente> clientes = new ArrayList<>();
	        String sql = "SELECT * FROM Cliente";
	        
	        try (PreparedStatement stmt = conexion.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Cliente cliente = new Cliente(
	                    rs.getString("nombre"),
	                    rs.getString("apellido"),
	                    rs.getString("cedula_cliente"),
	                    rs.getString("direction"),
	                    rs.getInt("cant_proyectos")
	                );
	                cliente.setTelefono(rs.getString("telefono"));
	                cliente.setEmail(rs.getString("email"));
	                clientes.add(cliente);
	            }
	        }
	        return clientes;
	    }

	    /**
	     * Incrementa la cantidad de proyectos de un cliente.
	     */
	    public void agregarProyecto(String cedula) throws SQLException {
	        String sql = "UPDATE Cliente SET cant_proyectos = cant_proyectos + 1 " +
	                     "WHERE cedula_cliente = ? AND cant_proyectos < 5"; // Respeta el CHECK de la BD
	        
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setString(1, cedula);
	            stmt.executeUpdate();
	        }
    }  
}
