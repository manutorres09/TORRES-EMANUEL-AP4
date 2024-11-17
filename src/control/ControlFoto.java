package control;

import db.ConexionBD;
import entidad.Foto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControlFoto {

    public void guardarFotoEnBD(Foto foto) {
        String sql = "INSERT INTO fotos (nombreFoto, fechaCaptura, rutaFoto, proyectoId) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, foto.getNombre());
            ps.setDate(2, new java.sql.Date(foto.getFechaCaptura().getTime()));
            ps.setString(3, foto.getRuta());
            ps.setInt(4, foto.getProyectoId());

            ps.executeUpdate();
            System.out.println("Foto almacenada correctamente en la base de datos.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar la foto en la base de datos: " + ex.getMessage());
        }
    }
}
