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

        List<Proyecto> proyectos = controlProyecto.getProyectos();
        if (proyectos.isEmpty()) {
            layout.getChildren().add(new Label("No hay proyectos registrados."));
        } else {
            for (Proyecto proyecto : proyectos) {
                layout.getChildren().add(new Label(proyecto.getNombre()+" || "+ proyecto.getEstado()+" || "+ proyecto.getPrioridad()));
            }
        }

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> ventana.close());
        layout.getChildren().add(btnCerrar);

        Scene escena = new Scene(layout, 400, 300);
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
