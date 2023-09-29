public class Main {
    public static void main(String[] args) throws InterruptedException {
        Metodos hilo1 = new Metodos("Hilo 1 ");
        Metodos hilo2 = new Metodos("Hilo 2 ");
        Metodos hilo3 = new Metodos("Hilo 3");
        Metodos hilo4 = new Metodos("Hilos 4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        hilo1.join();
        System.out.println("Hilo1 joins");

        hilo2.join();
        System.out.println("Hilo2 joins");

        hilo3.join();
        System.out.println("Hilo3 joins");

        hilo4.join();
        System.out.println("Hilo4 joins");

        System.out.println("Termina la Main");

    }
}