package db;

import java.sql.*;

public class ConexionBD {
    // Definir los datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/gestionproyectosfotograficos"; // Cambia 'mi_basedatos' por tu base de datos
    private static final String USUARIO = "root";  // Usuario de la base de datos
    private static final String CONTRASENA = "";   // Contraseña de la base de datos

    // Método para obtener la conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        // Intentamos conectar con la base de datos
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }


}
