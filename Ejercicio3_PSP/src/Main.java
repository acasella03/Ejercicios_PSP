public class Main {
    public static void main(String[] args) throws InterruptedException {

        Hilo h1 = new Hilo("hilo1", true);
        h1.start();
        h1.join();
        System.out.println("Termina thread main");

    }
}