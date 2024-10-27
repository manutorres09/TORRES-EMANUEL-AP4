package interfaz;

import control.ControlProyecto;
import control.ControlCliente;
import entidad.Cliente;
import entidad.Proyecto;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Date;

public class FormularioCrearProyecto {

    public static void mostrar(ControlProyecto controlProyecto, ControlCliente controlCliente) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Crear Proyecto");

        // Campo de texto para el nombre del proyecto
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre del Proyecto");

        // ComboBox para el estado del proyecto
        ComboBox<String> comboEstado = new ComboBox<>();
        comboEstado.setPromptText("Estado del proyecto");
        comboEstado.getItems().addAll("No iniciado", "En proceso", "Entregado");

        // ComboBox para la prioridad del proyecto
        ComboBox<String> comboPrioridad = new ComboBox<>();
        comboPrioridad.setPromptText("Prioridad");
        comboPrioridad.getItems().addAll("Alta", "Media", "Baja");

        // ComboBox para seleccionar un cliente
        ComboBox<Cliente> comboClientes = new ComboBox<>();
        comboClientes.setPromptText("Seleccionar Cliente");
        comboClientes.getItems().addAll(controlCliente.getClientes()); // Obtener lista de clientes

        // Botón para guardar el proyecto
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            // Crear un proyecto con los datos ingresados
            Cliente clienteSeleccionado = comboClientes.getValue(); // Obtener cliente seleccionado

            if (clienteSeleccionado == null) {
                System.out.println("Error: Debes seleccionar un cliente.");
                return; // No permite guardar si no hay cliente seleccionado
            }

            Proyecto proyecto = new Proyecto(
                    campoNombre.getText(), new Date(), new Date(),
                    comboEstado.getValue(), comboPrioridad.getValue()
            );

            // Asociar el proyecto al cliente seleccionado
            proyecto.setCliente(clienteSeleccionado);

            // Guardar el proyecto utilizando el control de proyectos
            controlProyecto.crearProyecto(proyecto);

            System.out.println("Proyecto creado para el cliente: " + clienteSeleccionado.getNombre());

            ventana.close(); // Cerrar la ventana después de guardar
        });

        // Layout para organizar los elementos en la interfaz
        VBox layout = new VBox(10, campoNombre, comboEstado, comboPrioridad, comboClientes, btnGuardar);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout, 300, 300);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
