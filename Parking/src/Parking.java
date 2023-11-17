/**
 * Implementa un escenario básico de estacionamiento con métodos para que los coches entren y salgan
 * del estacionamiento, mostrando el estado actual del estacionamiento. La sincronización se utiliza
 * para garantizar una manipulación segura de los datos compartidos en un entorno de concurrencia.
 */
public class Parking {
    private int numPlazas; //número total de plazas
    private int plazasLibres; //número actual de plazas libres
    private boolean[] plazasOcupadas; //un array de booleanos que indica qué plazas están ocupadas

    // Constructor que inicializa el estacionamiento con un número de plazas
    public Parking(int numPlazas) {
        this.numPlazas = numPlazas;
        this.plazasLibres = numPlazas;
        this.plazasOcupadas = new boolean[numPlazas];
    }

    // Método para obtener el número total de plazas en el estacionamiento
    public int getNumPlazas() {
        return numPlazas;
    }

    // Método synchronized para que un coche entre al estacionamiento
    public synchronized boolean entrarParking(int cocheId) throws InterruptedException {
        while (plazasLibres == 0) {
            System.out.println("Coche " + cocheId + " esperando en la entrada.");
            wait(); //para liberar el monitor y permitir que otros hilos realicen operaciones
        }

        for (int i = 0; i < numPlazas; i++) {
            if (!plazasOcupadas[i]) {
                plazasOcupadas[i] = true;
                plazasLibres--;
                System.out.println("ENTRADA: Coche " + cocheId + " aparca en " + i + ".");
                mostrarEstado();
                return true;
            }
        }

        return false; // Nunca debería llegar aquí
    }

    // Método synchronized para que un coche salga del estacionamiento
    public synchronized void salirParking(int cocheId, int plaza) {
        plazasOcupadas[plaza] = false;
        plazasLibres++;
        System.out.println("SALIDA: Coche " + cocheId + " saliendo.");
        mostrarEstado();
        notifyAll(); //Cuando un coche sale del estacionamiento, se utiliza notifyAll para despertar a los hilos en espera.
    }

    // Método privado para mostrar el estado actual del estacionamiento
    private void mostrarEstado() {
        System.out.print("Plazas libres: " + plazasLibres + "\nParking: ");
        for (int i = 0; i < numPlazas; i++) {
            System.out.print("[" + (plazasOcupadas[i] ? i + 1 : 0) + "] ");
        }
        System.out.println();
    }
}
