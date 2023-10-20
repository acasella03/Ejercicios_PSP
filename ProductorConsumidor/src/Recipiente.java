public class Recipiente {
    private int contenido; // Contenido del recipiente
    private boolean disponible = false; // Bandera para indicar si el recipiente tiene contenido

    public synchronized int obtener() {
        while (disponible == false) {
            try {
                wait(); // Espera si el recipiente está vacío
            } catch (InterruptedException e) {}
        }
        disponible = false; // Indica que el recipiente está vacío
        notifyAll(); // Notifica a otros hilos que pueden continuar
        return contenido; // Devuelve el contenido del recipiente
    }

    public synchronized void llenar(int valor) {
        while (disponible == true) {
            try {
                wait(); // Espera si el recipiente está lleno
            } catch (InterruptedException e) { }
        }
        contenido = valor; // Coloca el valor en el recipiente
        disponible = true; // Indica que el recipiente está lleno
        notifyAll(); // Notifica a otros hilos que pueden continuar
    }
}
