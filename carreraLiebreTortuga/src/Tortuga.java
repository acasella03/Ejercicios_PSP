import java.util.Random;

public class Tortuga extends Thread {
    private Carrera carrera;

    public Tortuga(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (carrera.getPosicionTortuga() < Carrera.META && carrera.getPosicionLiebre() < Carrera.META) {
            int probabilidad = random.nextInt(100) + 1; // Número aleatorio entre 1 y 100

            if (probabilidad <= 50) {
                // Avance rápido
                carrera.avanzarTortuga(3);
                System.out.println("Tortuga avanza rápido.");
            } else if (probabilidad <= 70) {
                // Resbaló
                carrera.avanzarTortuga(-6);
                System.out.println("Tortuga resbala y retrocede.");
            } else {
                // Avance lento
                carrera.avanzarTortuga(1);
                System.out.println("Tortuga avanza lentamente.");
            }

            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("Tortuga ha llegado a la meta.");
    }
}
