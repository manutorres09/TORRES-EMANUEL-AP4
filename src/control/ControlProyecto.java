package control;

import entidad.Proyecto;
import java.util.ArrayList;
import java.util.List;

public class ControlProyecto {
    private final List<Proyecto> proyectos;

    public ControlProyecto() {
        this.proyectos = new ArrayList<>();
    }

    public void crearProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
        System.out.println("Proyecto '" + proyecto.getNombre() + "' creado exitosamente.");
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }


}
