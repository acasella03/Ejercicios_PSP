public class Main {
    public static void main(String[] args) {
        // Número de plazas en el estacionamiento
        int numPlazas = 6;
        // Crear una instancia de la clase Parking con el número de plazas especificado
        Parking parking = new Parking(numPlazas);
        // Crear e iniciar hilos Coche
        for (int i = 0; i < numPlazas*2; i++) {
            Coche coche = new Coche(i,parking);
            coche.start();
        }
    }
}