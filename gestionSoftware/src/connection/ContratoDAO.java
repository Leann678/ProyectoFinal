package conexion;

import logico.Contrato;
import logico.Proyecto;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {
    private Connection conexion;

    public ContratoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // OPERACIONES CRUD
    
    /**
     * Inserta un nuevo contrato en la base de datos.
     */
    public void insertar(Contrato contrato) throws SQLException {
        String sql = "INSERT INTO Contrato (id_contrato, f_inicio, f_entrega, cant_clientes_proyecto, " +
                     "cedula_cliente, nombre_proyecto) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, contrato.getIdContrato());
            stmt.setDate(2, Date.valueOf(contrato.getfInicio()));
            stmt.setDate(3, Date.valueOf(contrato.getfEntrega()));
            stmt.setInt(4, contrato.getCantClientesProyecto());
            stmt.setString(5, contrato.getCedulaCliente());
            stmt.setString(6, contrato.getNombreProyecto().getNombreProyecto());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un contrato existente (excepto ID y cliente).
     */
    public void actualizar(Contrato contrato) throws SQLException {
        String sql = "UPDATE Contrato SET f_inicio = ?, f_entrega = ?, cant_clientes_proyecto = ?, " +
                     "nombre_proyecto = ? WHERE id_contrato = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(contrato.getfInicio()));
            stmt.setDate(2, Date.valueOf(contrato.getfEntrega()));
            stmt.setInt(3, contrato.getCantClientesProyecto());
            stmt.setString(4, contrato.getNombreProyecto().getNombreProyecto());
            stmt.setString(5, contrato.getIdContrato());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un contrato por su ID.
     */
    public void eliminar(String idContrato) throws SQLException {
        String sql = "DELETE FROM Contrato WHERE id_contrato = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, idContrato);
            stmt.executeUpdate();
        }
    }

    /**
     * Busca un contrato por su ID.
     */
    public Contrato buscarPorId(String idContrato) throws SQLException {
        String sql = "SELECT * FROM Contrato WHERE id_contrato = ?";
        Contrato contrato = null;
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, idContrato);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    contrato = mapearContratoDesdeResultSet(rs);
                }
            }
        }
        return contrato;
    }

    /**
     * Lista todos los contratos de la base de datos.
     */
    public List<Contrato> listarTodos() throws SQLException {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM Contrato";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                contratos.add(mapearContratoDesdeResultSet(rs));
            }
        }
        return contratos;
    }

    /**
     * Busca contratos por cédula de cliente.
     */
    public List<Contrato> buscarPorCliente(String cedulaCliente) throws SQLException {
        List<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM Contrato WHERE cedula_cliente = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cedulaCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    contratos.add(mapearContratoDesdeResultSet(rs));
                }
            }
        }
        return contratos;
    }

    private Contrato mapearContratoDesdeResultSet(ResultSet rs) throws SQLException {
        // Necesitarás un ProyectoDAO para obtener el objeto Proyecto completo
        Proyecto proyecto = new Proyecto(rs.getString("nombre_proyecto")); // Asume constructor básico
        
        Contrato contrato = new Contrato(
            rs.getDate("f_inicio").toLocalDate(),
            rs.getDate("f_entrega").toLocalDate(),
            rs.getString("id_contrato"),
            rs.getString("cedula_cliente"),
            proyecto
        );
        contrato.setCantClientesProyecto(rs.getInt("cant_clientes_proyecto"));
        return contrato;
    }

    /**
     * Incrementa la cantidad de clientes en el proyecto (si no supera el límite).
     */
    public void agregarClienteAlProyecto(String idContrato) throws SQLException {
        String sql = "UPDATE Contrato SET cant_clientes_proyecto = cant_clientes_proyecto + 1 " +
                     "WHERE id_contrato = ? AND cant_clientes_proyecto < 5";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, idContrato);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new SQLException("No se pudo agregar cliente: límite alcanzado o contrato no existe");
            }
        }
    }
}
