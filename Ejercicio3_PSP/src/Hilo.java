public class Hilo extends Thread {
    public Hilo(String str) {
        super(str);
    }

    @Override
    public void run() {
        System.out.println(getName() + " comenzó.");

        for (int i = 1; i < 10; i++) {
            System.out.println(getName() + " está procesando (" + i + "/" + 10 + ")");
            try {
                Hilo.sleep((long) Math.random() * 1000 + 500);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + " finalizó.");

            // Crear hilo hijo
            String[] parts = getName().split(" ");
            int getNumHilo = Integer.parseInt(parts[1]);
            if (getNumHilo < 5) {
                Hilo hiloHijo = new Hilo("Hilo " + (getNumHilo + 1));
                hiloHijo.start();

                // Esperar a que el hilo hijo termine
                try {
                    hiloHijo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
