package interfaz;

import control.ControlCliente;
import control.ControlProyecto;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

    private final ControlProyecto controlProyecto = new ControlProyecto();
    private final ControlCliente controlCliente = new ControlCliente();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Gestión Fotográfica");

        // Crear los botones del menú principal
        Button btnCrearProyecto = new Button("Crear Proyecto");
        Button btnListarProyectos = new Button("Listar Proyectos");
        Button btnCargarFotos = new Button("Cargar Fotografías");
        Button btnModificarProyecto = new Button("Modificar Proyecto");
        Button btnCrearCliente = new Button("Crear Cliente");
        Button btnSalir = new Button("Salir");

        // Asignar eventos a los botones
        btnCrearProyecto.setOnAction(e -> FormularioCrearProyecto.mostrar(controlProyecto, controlCliente));
        btnListarProyectos.setOnAction(e -> ListarProyectos.mostrar(controlProyecto));
        btnCargarFotos.setOnAction(e -> CargarFotografias.mostrar(controlProyecto));
        btnModificarProyecto.setOnAction(e -> ModificarProyecto.mostrar(controlProyecto));
        btnCrearCliente.setOnAction(e -> FormularioCrearCliente.mostrar(controlCliente));
        btnSalir.setOnAction(e -> primaryStage.close());

        // Configurar el layout del menú principal
        VBox layout = new VBox(15, btnCrearProyecto, btnListarProyectos, btnCargarFotos, btnModificarProyecto, btnCrearCliente, btnSalir);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Inicia la aplicación JavaFX
    }
}
