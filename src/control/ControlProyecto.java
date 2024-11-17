package control;

import entidad.Proyecto;
import entidad.Prioridad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.ConexionBD;

public class ControlProyecto {

    private List<Proyecto> proyectos; // Lista local de proyectos
    // Método para crear un proyecto
    public void crearProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO Proyectos (nombreProyecto, descripcion, estado, prioridadId, clienteId, fechaInicio, fechaEntrega) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, proyecto.getNombre());
            stmt.setString(2, proyecto.getDescripcion()); // Descripción
            stmt.setString(3, proyecto.getEstado());
            stmt.setInt(4, Integer.valueOf(proyecto.getPrioridad())); // Convertir prioridad a ID
            stmt.setInt(5, proyecto.getCliente().getIdCliente());
            stmt.setDate(6, new java.sql.Date(proyecto.getFechaInicio().getTime()));
            stmt.setDate(7, new java.sql.Date(proyecto.getFechaEntrega().getTime()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ControlProyecto() {
        this.proyectos = new ArrayList<>();

        cargarProyectosDesdeBD();
    }

    // Método para obtener la lista de proyectos
    public List<Proyecto> getProyectos() {
        return proyectos;
    }


    // Método para cargar proyectos desde la base de datos
    private void cargarProyectosDesdeBD() {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            String consulta = "SELECT idProyecto, nombreProyecto, fechaInicio, fechaEntrega FROM proyectos";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt("idProyecto");
                String nombre = rs.getString("nombreProyecto");
                java.sql.Date fechaInicio = rs.getDate("fechaInicio");
                java.sql.Date fechaEntrega = rs.getDate("fechaEntrega");

                // Convertir fechas de SQL a java.util.Date
                Proyecto proyecto = new Proyecto(nombre,
                        fechaInicio != null ? new java.util.Date(fechaInicio.getTime()) : null,
                        fechaEntrega != null ? new java.util.Date(fechaEntrega.getTime()) : null,
                        "Desconocido", // Estado inicial
                        "Baja" // Prioridad inicial
                );
                proyecto.setId(id); // Configurar ID cargado desde la BD

                proyectos.add(proyecto); // Agregar a la lista local
            }
        } catch (Exception e) {
            System.out.println("Error al cargar proyectos desde la base de datos: " + e.getMessage());
        }
    }

    public List<Proyecto> getProyectosDesdeBD() {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT p.idProyecto, p.nombreProyecto, p.fechaInicio, p.fechaEntrega, p.estado, " +
                "pr.nivelPrioridad AS prioridad, c.nombreCliente AS cliente " +
                "FROM proyectos p " +
                "JOIN prioridades pr ON p.prioridadId = pr.idPrioridad " +
                "JOIN clientes c ON p.clienteId = c.idCliente";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("idProyecto");
                String nombre = rs.getString("nombreProyecto");
                String estado = rs.getString("estado");
                String prioridad = rs.getString("prioridad");
                String cliente = rs.getString("cliente");

                java.sql.Date fechaInicioSQL = rs.getDate("fechaInicio");
                java.sql.Date fechaEntregaSQL = rs.getDate("fechaEntrega");
                Date fechaInicio = fechaInicioSQL != null ? new Date(fechaInicioSQL.getTime()) : null;
                Date fechaEntrega = fechaEntregaSQL != null ? new Date(fechaEntregaSQL.getTime()) : null;

                Proyecto proyecto = new Proyecto(nombre, fechaInicio, fechaEntrega, estado, prioridad);
                proyecto.setId(id);
                proyecto.setDescripcion("Cliente: " + cliente); // Agregar cliente como descripción para mostrar
                proyectos.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar proyectos desde la base de datos: " + e.getMessage());
        }

        return proyectos;
    }


    public void actualizarProyecto(Proyecto proyecto) {
        String sql = "UPDATE Proyectos SET nombreProyecto = ?, estado = ?, prioridadId = ? WHERE idProyecto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, proyecto.getNombre());
            stmt.setString(2, proyecto.getEstado());
            stmt.setInt(3, Prioridad.convertirPrioridad(proyecto.getPrioridad())); // Convertir prioridad a ID
            stmt.setInt(4, proyecto.getId()); // ID del proyecto a modificar

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Proyecto actualizado correctamente en la base de datos.");
            } else {
                System.out.println("No se pudo actualizar el proyecto en la base de datos.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el proyecto: " + e.getMessage());
        }
    }


}
