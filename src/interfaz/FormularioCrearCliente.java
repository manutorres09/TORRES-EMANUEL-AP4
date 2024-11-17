package interfaz;

import control.ControlCliente;
import entidad.Cliente;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormularioCrearCliente {
        public static void mostrar(ControlCliente controlCliente) {
            //creacion de la ventana
            Stage ventana = new Stage();
            ventana.initModality(Modality.APPLICATION_MODAL);
            ventana.setTitle("Crear Cliente");

            //Declaracion de campos

            TextField campoNombre = new TextField();
            campoNombre.setPromptText("Nombre del Cliente");

            TextField campoApellido = new TextField();
            campoApellido.setPromptText("Apellido del Cliente");

            TextField campoMail = new TextField();
            campoMail.setPromptText("Correo Electronico");

            TextField campoTelefono = new TextField();
            campoTelefono.setPromptText("Nro de Telefono");

            Button btnGuardar = new Button("Guardar");
            btnGuardar.setOnAction(e -> {
                try {
                    // Obtener los valores de los campos de texto
                    String nombre = campoNombre.getText();
                    String apellido = campoApellido.getText(); // Obtener el apellido
                    String mail = campoMail.getText();
                    String telefonoTexto = campoTelefono.getText().trim(); // Obtener teléfono como texto

                    // Validar que el apellido no esté vacío
                    if (apellido.isEmpty()) {
                        System.out.println("El apellido no puede estar vacío.");
                        return;
                    }

                    Integer telefono = null;

                    if (!telefonoTexto.isEmpty()) {
                        try {
                            telefono = Integer.parseInt(telefonoTexto); // Intentar convertir el teléfono a un número
                        } catch (NumberFormatException ex) {
                            System.out.println("El teléfono debe ser un número válido.");
                            return; // Detener el proceso si el teléfono no es un número válido
                        }
                    }

                    // Crear el objeto Cliente sin el ID (el ID será autogenerado por la base de datos)
                    Cliente cliente = new Cliente(0, nombre, apellido, mail, telefono != null ? telefono.toString() : null);

                    // Registrar el cliente a través del controlador
                    controlCliente.crearCliente(cliente);

                    // Cerrar la ventana
                    ventana.close();
                } catch (Exception ex) {
                    System.out.println("Error al crear el cliente: " + ex.getMessage());
                }
            });







            VBox layout = new VBox(10, campoNombre, campoApellido, campoMail,campoTelefono, btnGuardar);
            layout.setAlignment(Pos.CENTER);

            Scene escena = new Scene(layout, 300, 200);
            ventana.setScene(escena);
            ventana.showAndWait();
        }





}
