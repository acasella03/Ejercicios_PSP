public class Hilo extends Thread {
    private int i;
    static int contador=2;
    public Hilo(String str, boolean contador) {
        super(str);
    }

    @Override
    public void run() {
        Hilo hilo2= new Hilo("hilo"+contador,true);
        if(contador<=5){
            hilo2.start();
            contador++;
        }

        for (i = 1; i <= 10; i++) {
            System.out.println(i + " " + getName());
            try {
                Thread.sleep(((int) (Math.random() * 6 + 1)) * 100);
            } catch (InterruptedException ex) {
            }
        }
        try {
            hilo2.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("Termina thread " + getName());
    }
}

