import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int numeroCajas = 5;
        int numeroClientes = 10;

        SuperMarket supermercado = new SuperMarket(numeroCajas);

        // Crear clientes y comenzar su ejecución
        ArrayList<Clientes> clientes = new ArrayList<>();
        for (int i = 1; i <= numeroClientes; i++) {
            Clientes cliente = new Clientes(i, supermercado);
            clientes.add(cliente);
            cliente.start();
        }

        // Esperar a que todos los clientes terminen
        for (Clientes cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Imprimir mensaje de finalización
        System.out.println("Todos los clientes han sido atendidos. ¡Programa terminado!");


    }
}