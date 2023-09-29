public class Main {
    public static void main(String[] args) {
        new Metodo("Hilo 1 ").start();
        new Metodo("Hilo 2 ").start();
        System.out.println("Termina main");

    }
}