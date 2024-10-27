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
            TextField campoId = new TextField();
            campoId.setPromptText("ID del Cliente");

            TextField campoNombre = new TextField();
            campoNombre.setPromptText("Nombre del Cliente");

            TextField campoApellido = new TextField();
            campoApellido.setPromptText("Apellido del Cliente");

            TextField campoMail = new TextField();
            campoMail.setPromptText("Correo Electronico");

            Button btnGuardar = new Button("Guardar");
            btnGuardar.setOnAction(e -> {
                //manejo de Excepciones
                try {
                    int id = Integer.parseInt(campoId.getText());
                    String nombre = campoNombre.getText();
                    String apellido = campoApellido.getText();
                    String mail = campoMail.getText();
                    Cliente cliente = new Cliente(id, nombre, apellido, mail);
                    controlCliente.crearCliente(cliente);
                    ventana.close();
                }catch (NumberFormatException ex){
                    System.out.println("El ID debe ser un número entero.");
                }
            });

            VBox layout = new VBox(10, campoId, campoNombre, campoApellido, campoMail, btnGuardar);
            layout.setAlignment(Pos.CENTER);

            Scene escena = new Scene(layout, 300, 200);
            ventana.setScene(escena);
            ventana.showAndWait();
        }





}
