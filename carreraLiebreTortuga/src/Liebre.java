import java.util.Random;

public class Liebre extends Thread {
    private Carrera carrera;

    public Liebre(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public void run() {
        Random random = new Random();

        System.out.println("¡Comienza la carrera entre la liebre y la tortuga!");

        while (carrera.getPosicionLiebre() < Carrera.META && carrera.getPosicionTortuga() < Carrera.META) {
            int probabilidad = random.nextInt(100) + 1; // Número aleatorio entre 1 y 100
            if (probabilidad <= 20) {
                //Duerme
                System.out.println("Liebre duerme.");
            } else if (probabilidad <= 40) {
                //Gran salto
                carrera.avanzarLiebre(9);
                System.out.println("Liebre da un gran salto.");
            } else if (probabilidad <= 70) {
                //Pequeño salto
                carrera.avanzarLiebre(1);
                System.out.println("Liebre da un pequeño salto.");
            } else if (probabilidad <= 80) {
                //Resbalón grande
                carrera.avanzarLiebre(-12);
                System.out.println("Liebre resbala y da un resbalón grande.");
            } else {
                //Resbalón pequeño
                carrera.avanzarLiebre(-2);
                System.out.println("Liebre resbala y da un resbalón pequeño.");
            }
            try {
                Thread.sleep((1000)); //Espera 1 segundo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("Liebre ha llegado a la meta.");
    }
}
