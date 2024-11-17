package entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
    private int id; // ID único del proyecto
    private final String nombre;
    private final Date fechaInicio;
    private final Date fechaEntrega;
    private final List<Foto> fotos;
    private String estado;
    private String prioridad;
    private String descripcion;

    private Cliente cliente; // Atributo para asociar el cliente

    // Constructor
    public Proyecto(String nombre, Date fechaInicio, Date fechaEntrega, String estado, String prioridad) {
        this.id = -1;  // O cualquier valor predeterminado que desees
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.fotos = new ArrayList<>();
        this.estado = estado;
        this.prioridad = String.valueOf(prioridad);
    }

    // Método para configurar el ID (por ejemplo, al cargar desde la BD)
    public void setId(int id) {
        this.id = id;
    }

    public void agregarFoto(Foto foto) {
        this.fotos.add(foto); // Agrega la foto a la lista local
    }


    // Getters
    public int getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }
    public String getDescripcion() {
        return descripcion;
    }


    // Setters
    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para asociar un cliente al proyecto
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return nombre + " (" + estado + ", " + prioridad + ")";
    }

    public void setNombre(String text) {
    }
}
