package control;

import entidad.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.ConexionBD;

public class ControlCliente {
    private final List<Cliente> clientes;

    public ControlCliente() {
        this.clientes = new ArrayList<>();
    }

    // Método para insertar un cliente
    public static void insertarCliente(Cliente cliente) {
        String query = "INSERT INTO clientes (nombreCliente, apellidoCliente, emailCliente, telefonoCliente) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pst = conn.prepareStatement(query)) {

            // Asignar los valores al PreparedStatement
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getMail());
            pst.setString(4, cliente.getTelefono());

            // Ejecutar la inserción
            int filasInsertadas = pst.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Cliente registrado con éxito.");
            } else {
                System.out.println("Error al registrar el cliente.");
            }

        } catch (SQLException e) {
            System.out.println("Error en la inserción del cliente: " + e.getMessage());
        }
    }

    // Método para crear un cliente en la base de datos
    public void crearCliente(Cliente cliente) {
        try {
            insertarCliente(cliente); // Llama al método para insertar cliente en la base de datos
        } catch (Exception e) {
            System.out.println("Error al crear el cliente: " + e.getMessage());
        }
    }

    public List<Cliente> getClientesDesdeBD() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT idCliente, nombreCliente, apellidoCliente, emailCliente, telefonoCliente FROM clientes";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nombreCliente"),
                        rs.getString("apellidoCliente"),
                        rs.getString("emailCliente"),
                        rs.getString("telefonoCliente")
                );
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error al cargar clientes desde la base de datos: " + e.getMessage());
        }

        return clientes;
    }
}
