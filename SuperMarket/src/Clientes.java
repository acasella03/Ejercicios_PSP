import java.util.Random;

class Clientes extends Thread {
    private int id;
    private SuperMarket supermercado;

    public Clientes(int id, SuperMarket supermercado) {
        this.id = id;
        this.supermercado = supermercado;
    }

    @Override
    public void run() {
        Random random = new Random();

        // Simular tiempo de compra
        try {
            Thread.sleep(random.nextInt(5000)); // Tiempo aleatorio de compra
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        // Elegir aleatoriamente una caja y ponerse en cola
        int cajaElegida = random.nextInt(supermercado.getNumeroCajas());
        supermercado.ponerseEnCola(id, cajaElegida);

        // Esperar a ser atendido
        supermercado.esperarAtencion(id);

        // Pagar un valor aleatorio
        double pago = random.nextDouble() * 100;
        supermercado.realizarPago(id, pago);
    }
}