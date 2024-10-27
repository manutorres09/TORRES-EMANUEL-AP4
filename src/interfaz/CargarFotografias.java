package interfaz;

import control.ControlProyecto;
import entidad.Foto;
import entidad.Proyecto;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class CargarFotografias {

    public static void mostrar(ControlProyecto controlProyecto) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Cargar Fotografías");

        // ComboBox para seleccionar un proyecto
        Label labelSeleccion = new Label("Seleccione un proyecto:");
        ComboBox<Proyecto> comboProyectos = new ComboBox<>();
        comboProyectos.setPromptText("Proyectos disponibles");

        // Cargar los proyectos en el ComboBox
        List<Proyecto> proyectos = controlProyecto.getProyectos();
        comboProyectos.getItems().addAll(proyectos);

        // Botón para abrir el explorador de archivos
        Button btnSeleccionarFoto = new Button("Seleccionar Foto");
        Label labelRutaFoto = new Label("Ruta de la foto: Ninguna seleccionada");

        btnSeleccionarFoto.setOnAction(e -> {
            File fotoSeleccionada = abrirExploradorArchivos();
            if (fotoSeleccionada != null) {
                labelRutaFoto.setText("Ruta de la foto: " + fotoSeleccionada.getAbsolutePath());
            } else {
                labelRutaFoto.setText("No se seleccionó ninguna foto.");
            }
        });

        // Botón para cargar la foto en el proyecto
        Button btnCargar = new Button("Cargar");
        btnCargar.setOnAction(e -> {
            Proyecto proyectoSeleccionado = comboProyectos.getValue();
            if (proyectoSeleccionado != null && !labelRutaFoto.getText().contains("Ninguna")) {
                String rutaFoto = labelRutaFoto.getText().replace("Ruta de la foto: ", "");
                Foto nuevaFoto = new Foto(rutaFoto);
                proyectoSeleccionado.agregarFoto(nuevaFoto);
                System.out.println("Foto agregada al proyecto: " + proyectoSeleccionado.getNombre());
                ventana.close();
            } else {
                System.out.println("Seleccione un proyecto y una foto antes de continuar.");
            }
        });

        VBox layout = new VBox(10, labelSeleccion, comboProyectos, btnSeleccionarFoto, labelRutaFoto, btnCargar);
        layout.setAlignment(Pos.CENTER);

        Scene escena = new Scene(layout, 400, 300);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    private static File abrirExploradorArchivos() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Foto");

        // Filtro para aceptar solo archivos .jpg
        FileChooser.ExtensionFilter filtroJPG = new FileChooser.ExtensionFilter("Archivos JPG", "*.jpg");
        fileChooser.getExtensionFilters().add(filtroJPG);

        // Abrir el explorador de archivos y devolver el archivo seleccionado
        return fileChooser.showOpenDialog(null);
    }
}
