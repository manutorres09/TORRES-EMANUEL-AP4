package entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaEntrega;
    private final List<Foto> fotos;
    private String estado;
    private String prioridad;

    private Cliente cliente; // Atributo para asociar el cliente

    // Constructor
    public Proyecto(String nombre, Date fechaInicio, Date fechaEntrega, String estado, String prioridad) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.fotos = new ArrayList<>();
        this.estado = estado;
        this.prioridad = prioridad;
    }

    // Método para asociar un cliente al proyecto
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    // Setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    // Método para agregar fotos al proyecto
    public void agregarFoto(Foto foto) {
        fotos.add(foto);
    }

    @Override
    public String toString() {
        return nombre + " (" + estado + ", " + prioridad + ")";
    }
}
