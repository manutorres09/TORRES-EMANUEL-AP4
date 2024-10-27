package interfaz;

import control.ControlProyecto;
import entidad.Proyecto;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModificarProyecto {

    public static void mostrar(ControlProyecto controlProyecto) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Modificar Proyecto");

        // ComboBox para seleccionar un proyecto
        Label labelSeleccion = new Label("Seleccione un proyecto:");
        ComboBox<Proyecto> comboProyectos = new ComboBox<>();
        comboProyectos.setPromptText("Proyectos disponibles");
        comboProyectos.getItems().addAll(controlProyecto.getProyectos());

        Button btnModificar = new Button("Modificar");
        btnModificar.setDisable(true); // Deshabilitado hasta seleccionar un proyecto

        comboProyectos.setOnAction(e -> btnModificar.setDisable(false));

        btnModificar.setOnAction(e -> {
            Proyecto proyectoSeleccionado = comboProyectos.getValue();
            if (proyectoSeleccionado != null) {
                mostrarFormularioModificar(controlProyecto, proyectoSeleccionado);
                ventana.close();
            }
        });

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> ventana.close());

        VBox layout = new VBox(10, labelSeleccion, comboProyectos, btnModificar, btnCerrar);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout, 400, 300);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    private static void mostrarFormularioModificar(ControlProyecto controlProyecto, Proyecto proyecto) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Modificar Proyecto");

        // Campos con los datos del proyecto precargados
        TextField campoNombre = new TextField(proyecto.getNombre());
        ComboBox<String> comboEstado = new ComboBox<>();
        comboEstado.getItems().addAll("No iniciado", "En proceso", "Entregado");
        comboEstado.setValue(proyecto.getEstado()); // Precargar estado

        ComboBox<String> comboPrioridad = new ComboBox<>();
        comboPrioridad.getItems().addAll("Alta", "Media", "Baja");
        comboPrioridad.setValue(proyecto.getPrioridad()); // Precargar prioridad

        Button btnGuardar = new Button("Guardar Cambios");
        btnGuardar.setOnAction(e -> {
            proyecto.setEstado(comboEstado.getValue());
            proyecto.setPrioridad(comboPrioridad.getValue());
            System.out.println("Proyecto actualizado: " + proyecto.getNombre());
            ventana.close();
        });

        VBox layout = new VBox(10, campoNombre, comboEstado, comboPrioridad, btnGuardar);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout, 300, 200);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
