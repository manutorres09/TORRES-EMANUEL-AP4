package entidad;

import java.util.Date;

public class Foto {
    private int id;
    private String nombre;
    private Date fechaCaptura;
    private String ruta;
    private int proyectoId;

    public Foto(int id, String nombre, Date fechaCaptura, String ruta, int proyectoId) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCaptura = fechaCaptura;
        this.ruta = ruta;
        this.proyectoId = proyectoId;
    }

    // Constructor sin ID (para nuevas fotos)
    public Foto(String nombre, Date fechaCaptura, String ruta, int proyectoId) {
        this.nombre = nombre;
        this.fechaCaptura = fechaCaptura;
        this.ruta = ruta;
        this.proyectoId = proyectoId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    @Override
    public String toString() {
        return "Foto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaCaptura=" + fechaCaptura +
                ", ruta='" + ruta + '\'' +
                ", proyectoId=" + proyectoId +
                '}';
    }
}
