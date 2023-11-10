public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Crear tres instancias de la clase Hilo
        Hilo h1 = new Hilo("Hilo 1");
        Hilo h2 = new Hilo("Hilo 2");
        Hilo h3 = new Hilo("Hilo 3");

        //Iniciar las tres instancias de los hilos y Esperar a que cada hilo termine sus iteraciones
        h3.start();
        h3.join();
        h2.start();
        h2.join();
        h1.start();
        h1.join();


        System.out.println("Todos los hilos han terminado. Programa principal finalizado.");
    }
}