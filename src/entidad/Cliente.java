package entidad;

public class Cliente {
    private final int id;
    public String nombreC;
    public String apellidoC;

    public String mailC;

    public Cliente(int id, String nombre, String apellido, String mail) {
        this.id = id;
        this.nombreC = nombre;
        this.apellidoC = apellido;
        this.mailC = mail;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombreC;
    }

    public String getApellido() {
        return apellidoC;
    }
    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return id + " - " + nombreC + " " + apellidoC;
    }
}
