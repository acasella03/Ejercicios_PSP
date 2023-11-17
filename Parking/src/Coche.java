import java.util.Random;

/**
 * Representa un coche que realiza acciones como intentar entrar al estacionamiento,
 * permanecer un tiempo dentro y salir, todo esto en un bucle infinito.
 * La introducción de tiempos aleatorios simula un comportamiento más realista de la
 * interacción de múltiples coches con el estacionamiento.
 */
public class Coche extends Thread {
    private int cocheId; //identificador del coche
    private Parking parking; //una referencia al objeto de la clase Parking

    // Constructor que recibe un identificador de coche y una instancia de Parking
    public Coche(int cocheId, Parking parking) {
        this.cocheId = cocheId;
        this.parking = parking;
    }

    // Método run, que se ejecutará cuando se inicie el hilo
    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            try {
                // Tiempo aleatorio de espera antes de intentar entrar al estacionamiento
                Thread.sleep(random.nextInt(5000));
                // Intenta entrar al estacionamiento
                boolean pudoEntrar = parking.entrarParking(cocheId);

                if (pudoEntrar) {
                    // Tiempo aleatorio dentro del estacionamiento
                    Thread.sleep(random.nextInt(5000));
                    // Selecciona una plaza aleatoria y sale del estacionamiento
                    int plaza = random.nextInt(parking.getNumPlazas());
                    parking.salirParking(cocheId, plaza);
                    // Tiempo aleatorio fuera del estacionamiento antes de volver a intentar entrar
                    Thread.sleep(random.nextInt(5000));
                }
            } catch (InterruptedException e) {
                // Manejo de interrupciones
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
