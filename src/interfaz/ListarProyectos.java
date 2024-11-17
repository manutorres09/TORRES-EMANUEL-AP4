package interfaz;

import control.ControlProyecto;
import entidad.Proyecto;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class ListarProyectos {

    public static void mostrar(ControlProyecto controlProyecto) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Lista de Proyectos");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        // Actualizar la lista de proyectos desde la base de datos
        List<Proyecto> proyectos = controlProyecto.getProyectosDesdeBD();

        if (proyectos.isEmpty()) {
            layout.getChildren().add(new Label("No hay proyectos registrados."));
        } else {
            for (Proyecto proyecto : proyectos) {
                // Mostrar los datos de cada proyecto
                String detalleProyecto = String.format(
                        "Nombre: %s | Estado: %s | Prioridad: %s | Fecha Inicio: %s | Fecha Entrega: %s",
                        proyecto.getNombre(),
                        proyecto.getEstado(),
                        proyecto.getPrioridad(),
                        proyecto.getFechaInicio() != null ? proyecto.getFechaInicio().toString() : "N/A",
                        proyecto.getFechaEntrega() != null ? proyecto.getFechaEntrega().toString() : "N/A"
                );
                layout.getChildren().add(new Label(detalleProyecto));
            }
        }

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> ventana.close());
        layout.getChildren().add(btnCerrar);

        Scene escena = new Scene(layout, 500, 400);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
