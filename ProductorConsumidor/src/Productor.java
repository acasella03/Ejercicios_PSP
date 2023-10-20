public class Productor extends Thread {
    private Recipiente recipiente;
    private int numero;

    public Productor(Recipiente r, int numero) {
        recipiente = r;
        this.numero = numero;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            recipiente.llenar(i); // Coloca un valor en el recipiente
            System.out.println("Productor #" + this.numero + " llenó: " + i);
            try {
                sleep((int)(Math.random() * 100)); // Espera un tiempo aleatorio
            } catch (InterruptedException e) { }
        }
    }
}
