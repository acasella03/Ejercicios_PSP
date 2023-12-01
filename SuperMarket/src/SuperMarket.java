import java.util.ArrayList;
import java.util.Map;

public class SuperMarket {
    private int numeroCajas;
    private ArrayList<Caja> cajas;
    private ArrayList<Double> resultados;

    public SuperMarket(int numeroCajas) {
        this.numeroCajas = numeroCajas;
        this.cajas = new ArrayList<>();
        this.resultados = new ArrayList<>();

        for (int i = 0; i < numeroCajas; i++) {
            cajas.add(new Caja(i, this));
        }
    }

    public int getNumeroCajas() {
        return numeroCajas;
    }

    public synchronized void ponerseEnCola(int clienteId, int cajaElegida) {
        System.out.println("Cliente " + clienteId + " se ha puesto en cola en la caja " + cajaElegida + ".");
        Caja caja = cajas.get(cajaElegida);
        caja.atenderCliente(clienteId);
    }

    public synchronized void esperarAtencion(int clienteId) {
        try {
            wait(); // Esperar a ser notificado por la caja
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void clienteAtendido(int clienteId) {
        System.out.println("Cliente " + clienteId + " ha sido atendido y ha realizado el pago.");
        resultados.add(0.0); // Se podría almacenar el resultado de cada cliente aquí.
        notifyAll(); // Notificar a los clientes que están en espera
    }

    public synchronized void realizarPago(int clienteId, double pago) {
        System.out.println("Cliente " + clienteId + " ha realizado un pago de " + pago + " euros.");
        resultados.set(clienteId - 1, pago); // Actualizar el resultado del cliente
    }

    public Caja[] getCajas() {
        return cajas.toArray(new Caja[0]);
    }
}
