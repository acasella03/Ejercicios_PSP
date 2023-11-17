public class Ascensor {
    private int pisoActual;

    // Constructor que inicializa el piso actual en 0
    public Ascensor() {
        pisoActual = 0;
    }

    // Método synchronized que simula el ascensor yendo a un piso dado
    public synchronized void irAPiso(int destino){
        // Imprime un mensaje indicando el movimiento del ascensor
        System.out.println("Ascensor en el piso " + pisoActual + " se dirige al piso " + destino);
        try {
            // Simula el tiempo que tarda el ascensor en llegar al piso
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Actualiza el piso actual a la llegada al destino
        pisoActual = destino;
        // Imprime un mensaje indicando que el ascensor ha llegado al piso
        System.out.println("Ascensor llega al piso " + pisoActual);
    }
}
