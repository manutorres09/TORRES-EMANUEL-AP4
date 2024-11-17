package entidad;

public class Prioridad {

    private int id;
    private String descripcion;

    public Prioridad(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Método para convertir la prioridad de String a int usando un Map
    public static int convertirPrioridad(String prioridad) {
        switch (prioridad) {
            case "Alta":
                return 1;
            case "Media":
                return 2;
            case "Baja":
                return 3;
            default:
                return -1; // Valor inválido
        }
    }



    @Override
    public String toString() {
        return descripcion; // Para que se muestre la descripción en el ComboBox
    }
}
