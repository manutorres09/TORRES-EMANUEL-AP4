package entidad;

public class Cliente {
    private final int idCliente; // Cambiado de 'id' a 'idCliente'
    private String nombreC;
    private String apellidoC;
    private String mailC;
    private String telefonoC;

    // Constructor sin teléfono (establece un valor predeterminado)
    public Cliente(int idCliente, String nombre, String apellido, String mail) {
        this.idCliente = idCliente; // Cambiado de 'id' a 'idCliente'
        this.nombreC = nombre;
        this.apellidoC = apellido;
        this.mailC = mail;
        this.telefonoC = "No especificado"; // Valor predeterminado
    }

    // Constructor con teléfono
    public Cliente(int idCliente, String nombre, String apellido, String mail, String telefono) {
        this.idCliente = idCliente; // Cambiado de 'id' a 'idCliente'
        this.nombreC = nombre;
        this.apellidoC = apellido;
        this.mailC = mail;
        this.telefonoC = telefono;
    }

    // Getters
    public int getIdCliente() {
        return idCliente; // Cambiado de 'getId' a 'getIdCliente'
    }

    public String getNombre() {
        return nombreC;
    }

    public String getApellido() {
        return apellidoC;
    }

    public String getMail() {
        return mailC;
    }

    public String getTelefono() {
        return telefonoC;
    }

    // Sobrescribimos el método toString() para facilitar la impresión
    @Override
    public String toString() {
        return idCliente + " - " + nombreC + " " + apellidoC + " | Teléfono: " + telefonoC + " | Email: " + mailC;
    }
}
