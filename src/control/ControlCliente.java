package control;

import entidad.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ControlCliente {
    private final List<Cliente> clientes;

    public ControlCliente() {
        this.clientes = new ArrayList<>();
    }

    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente creado exitosamente.");
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
