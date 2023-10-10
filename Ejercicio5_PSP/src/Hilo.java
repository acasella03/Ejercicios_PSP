public class Hilo extends Thread {
    public Hilo(String mensaje) {
        super(mensaje);
    }

    @Override
    public void run() {
        System.out.println("Soy el hilo numero "+getName());

    }
}
