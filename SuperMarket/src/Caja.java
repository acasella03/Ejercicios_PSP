import java.util.ArrayList;

class Caja {
    private int id;
    private ArrayList<Integer> cola;
    private SuperMarket supermercado;

    public Caja(int id, SuperMarket supermercado) {
        this.id = id;
        this.cola = new ArrayList<>();
        this.supermercado = supermercado;
    }

    public synchronized void atenderCliente(int clienteId) {
        cola.add(clienteId);
        notifyAll(); // Notificar a todos los hilos esperando

        while (cola.isEmpty()) {
            try {
                wait(); // Esperar hasta que haya clientes en la cola
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Atender al cliente
        int clienteActual = cola.remove(0);
        System.out.println("Cliente " + clienteActual + " en la caja " + id + " está siendo atendido.");

        // Simular tiempo de atención
        try {
            Thread.sleep(2000); // Tiempo aleatorio de atención
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        supermercado.clienteAtendido(clienteActual);
    }
}
