package interfaz;

import control.ControlProyecto;
import control.ControlCliente;
import entidad.Cliente;
import entidad.Proyecto;
import entidad.Prioridad;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.util.Date;

public class FormularioCrearProyecto {

    public static void mostrar(ControlProyecto controlProyecto, ControlCliente controlCliente) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Crear Proyecto");

        // Campo de texto para el nombre del proyecto
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre del Proyecto");

        // TextArea para la descripción del proyecto
        TextArea areaDescripcion = new TextArea();
        areaDescripcion.setPromptText("Descripción del Proyecto");
        areaDescripcion.setWrapText(true); // Habilitar ajuste de línea

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
        comboClientes.getItems().addAll(controlCliente.getClientesDesdeBD()); // Obtener lista de clientes

        // Campos para seleccionar fechas (Fecha de inicio y fecha de entrega)
        DatePicker dateInicio = new DatePicker();
        dateInicio.setPromptText("Fecha de inicio");

        DatePicker dateEntrega = new DatePicker();
        dateEntrega.setPromptText("Fecha de entrega");

        // Botón para guardar el proyecto
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            Cliente clienteSeleccionado = comboClientes.getValue();

            if (clienteSeleccionado == null) {
                System.out.println("Error: Debes seleccionar un cliente.");
                return;
            }

            // Validar campos obligatorios
            if (campoNombre.getText().trim().isEmpty() || areaDescripcion.getText().trim().isEmpty()) {
                System.out.println("Error: El nombre y la descripción del proyecto son obligatorios.");
                return;
            }

            // Convertir prioridad de texto a entero
            int prioridadId = Prioridad.convertirPrioridad(comboPrioridad.getValue());
            if (prioridadId == -1) {
                System.out.println("Error: Prioridad inválida.");
                return;
            }


            Date fechaInicioDate = Date.from(dateInicio.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            Date fechaEntregaDate = Date.from(dateEntrega.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

            Proyecto proyecto = new Proyecto(
                    campoNombre.getText(), fechaInicioDate, fechaEntregaDate,
                    comboEstado.getValue(), String.valueOf(prioridadId)
            );

            proyecto.setDescripcion(areaDescripcion.getText());
            proyecto.setCliente(clienteSeleccionado);

            controlProyecto.crearProyecto(proyecto);

            System.out.println("Proyecto creado para el cliente: " + clienteSeleccionado.getNombre());
            ventana.close();
        });


        // Layout para organizar los elementos en la interfaz
        VBox layout = new VBox(10, campoNombre, areaDescripcion, comboEstado, comboPrioridad, comboClientes, dateInicio, dateEntrega, btnGuardar);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout, 400, 400);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
