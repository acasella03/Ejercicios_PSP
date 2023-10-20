/**
 * Este programa implementa el problema clásico de productor-consumidor.
 * Los productores colocan valores en un recipiente, y los consumidores obtienen esos valores.
 * La clase Recipiente representa el recipiente a llenar o vaciar, y los hilos Productor y Consumidor
 * interactúan con él, utilizando métodos sincronizados y notificaciones para garantizar la sincronización
 * adecuada y evitar condiciones de carrera. Los hilos de productores y consumidores funcionan en paralelo,
 * y se puede observar cómo los valores se colocan y se obtienen del recipiente.
 */
public class Main {
    public static void main(String[] args) {

        Recipiente recipiente = new Recipiente();
        Productor p1 = new Productor(recipiente, 1);
        Consumidor c1 = new Consumidor(recipiente, 1);

        p1.start();
        c1.start();

    }
}