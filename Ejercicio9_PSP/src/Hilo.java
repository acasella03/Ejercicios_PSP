public class Hilo extends Thread {
    public Hilo(String str) {
        super(str);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(getName() + " - Iteración" + i);
            try {
                //Bloquear durante un tiempo aleatorio entre medio y un segundo
                Thread.sleep((long) (Math.random() * 500 + 500));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(getName() + " ha terminado.");
    }
}
