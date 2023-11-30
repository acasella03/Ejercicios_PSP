public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera();
        Liebre liebre = new Liebre(carrera);
        Tortuga tortuga = new Tortuga(carrera);

        liebre.start();
        tortuga.start();

        try {
            liebre.join();
            tortuga.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("¡Carrera terminada!");
        if (carrera.getPosicionLiebre() >= Carrera.META && carrera.getPosicionTortuga() >= Carrera.META) {
            System.out.println("¡Es un empate!");
        } else if (carrera.getPosicionLiebre() >= Carrera.META) {
            System.out.println("¡La liebre ha ganado!");
        } else {
            System.out.println("¡La tortuga ha ganado!");
        }
    }
}