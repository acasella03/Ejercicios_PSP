import java.util.Scanner;

/**
 * Se inician los hilos, y al final se muestra el recuento total de vocales
 */
public class Main {
    public static void main(String[] args) {

        //Solicitamos al usuario que introduzca un texto
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = scanner.nextLine();
        scanner.close();

        // Creamos un contador compartido para almacenar el recuento total de vocales.
        Contador contador = new Contador();

        // Creamos 5 hilos para contar las vocales y los iniciamos.
        ContadorHilo hiloA = new ContadorHilo(texto, 'a', contador);
        ContadorHilo hiloE = new ContadorHilo(texto, 'e', contador);
        ContadorHilo hiloI = new ContadorHilo(texto, 'i', contador);
        ContadorHilo hiloO = new ContadorHilo(texto, 'o', contador);
        ContadorHilo hiloU = new ContadorHilo(texto, 'u', contador);

        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();

        // Esperamos a que todos los hilos terminen.
        try {
            hiloA.join();
            hiloE.join();
            hiloI.join();
            hiloO.join();
            hiloU.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtenemos el recuento total de vocales y lo mostramos.
        int totalVocales = contador.getTotalVocales();
        System.out.println("Número total de vocales: " + totalVocales);
    }
}