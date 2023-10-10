public class Main {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("1");
        Hilo hilo2 = new Hilo("2");

        //CON JOIN, comentar éste código para que ejecute el priority
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hilo1.start();

        //CON PRIORITY
        hilo2.setPriority(Hilo.MAX_PRIORITY);
        hilo1.setPriority(Hilo.MIN_PRIORITY);

        hilo1.start();
        hilo2.start();

    }
}