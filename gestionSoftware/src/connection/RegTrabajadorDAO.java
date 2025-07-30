package conexion;

import logico.Trabajador;
import logico.Proyecto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegTrabajadorDAO {
    private Connection conexion;
    private ProyectoDAO proyectoDAO;

    public RegTrabajadorDAO(Connection conexion, ProyectoDAO proyectoDAO) {
        this.conexion = conexion;
        this.proyectoDAO = proyectoDAO;
    }

    // ------------------- OPERACIONES CRUD -------------------

    /**
     * Inserta un nuevo trabajador en la base de datos.
     */
    public void insertar(Trabajador trabajador) throws SQLException {
        String sql = "INSERT INTO Trabajador (cedula_trab, nombre, apellido, direction, genero, edad, " +
                   "salario, proyectoAsignado, calificacion_anual, posicion, especialidad) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, trabajador.getCedulaTrab());
            stmt.setString(2, trabajador.getNombre());
            stmt.setString(3, trabajador.getApellido());
            stmt.setString(4, trabajador.getDireccion());
            stmt.setString(5, trabajador.getGenero());
            stmt.setInt(6, trabajador.getEdad());
            stmt.setDouble(7, trabajador.getSalario());
            stmt.setString(8, trabajador.getProyectoAsignado() != null ? 
                          trabajador.getProyectoAsignado().getNombreProyecto() : null);
            stmt.setString(9, trabajador.getCalificacionAnual());
            stmt.setString(10, trabajador.getPosicion());
            stmt.setString(11, trabajador.getEspecialidad());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un trabajador existente.
     */
    public void actualizar(Trabajador trabajador) throws SQLException {
        String sql = "UPDATE Trabajador SET nombre = ?, apellido = ?, direction = ?, genero = ?, " +
                   "edad = ?, salario = ?, proyectoAsignado = ?, calificacion_anual = ?, " +
                   "posicion = ?, especialidad = ? WHERE cedula_trab = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, trabajador.getNombre());
            stmt.setString(2, trabajador.getApellido());
            stmt.setString(3, trabajador.getDireccion());
            stmt.setString(4, trabajador.getGenero());
            stmt.setInt(5, trabajador.getEdad());
            stmt.setDouble(6, trabajador.getSalario());
            stmt.setString(7, trabajador.getProyectoAsignado() != null ? 
                          trabajador.getProyectoAsignado().getNombreProyecto() : null);
            stmt.setString(8, trabajador.getCalificacionAnual());
            stmt.setString(9, trabajador.getPosicion());
            stmt.setString(10, trabajador.getEspecialidad());
            stmt.setString(11, trabajador.getCedulaTrab());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un trabajador por su cédula.
     */
    public void eliminar(String cedula) throws SQLException {
        String sql = "DELETE FROM Trabajador WHERE cedula_trab = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.executeUpdate();
        }
    }

    /**
     * Busca un trabajador por su cédula.
     */
    public Trabajador buscarPorCedula(String cedula) throws SQLException {
        String sql = "SELECT * FROM Trabajador WHERE cedula_trab = ?";
        Trabajador trabajador = null;
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    trabajador = mapearTrabajadorDesdeResultSet(rs);
                }
            }
        }
        return trabajador;
    }

    /**
     * Lista todos los trabajadores.
     */
    public List<Trabajador> listarTodos() throws SQLException {
        List<Trabajador> trabajadores = new ArrayList<>();
        String sql = "SELECT * FROM Trabajador";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                trabajadores.add(mapearTrabajadorDesdeResultSet(rs));
            }
        }
        return trabajadores;
    }

    /**
     * Asigna/desasigna un proyecto a un trabajador.
     */
    public void asignarProyecto(String cedulaTrab, String nombreProyecto) throws SQLException {
        if (nombreProyecto != null && !proyectoDAO.existeProyecto(nombreProyecto)) {
            throw new SQLException("El proyecto no existe");
        }
        
        String sql = "UPDATE Trabajador SET proyectoAsignado = ? WHERE cedula_trab = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombreProyecto);
            stmt.setString(2, cedulaTrab);
            stmt.executeUpdate();
        }
    }

    // ------------------- MÉTODO AUXILIAR -------------------
    
    private Trabajador mapearTrabajadorDesdeResultSet(ResultSet rs) throws SQLException {
        Proyecto proyecto = null;
        String nombreProyecto = rs.getString("proyectoAsignado"); // Clave: usa el nombre correcto de columna
        if (nombreProyecto != null) {
            proyecto = proyectoDAO.buscarPorNombre(nombreProyecto);
        }
        
        return new Trabajador(
            rs.getString("cedula_trab"),
            rs.getString("nombre"),
            rs.getString("apellido"),
            rs.getString("direction"),
            rs.getString("genero"),
            rs.getInt("edad"),
            (float) rs.getDouble("salario"),
            rs.getString("calificacion_anual"),
            proyecto,
            rs.getString("posicion"),
            rs.getString("especialidad")
        );
    }
}
