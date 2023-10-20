public class Consumidor extends Thread {
    private Recipiente recipiente;
    private int numero;

    public Consumidor(Recipiente r, int numero) {
        recipiente = r;
        this.numero = numero;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 10; i++) {
            valor = recipiente.obtener(); // Obtiene el valor del recipiente
            System.out.println("Consumidor #" + this.numero + " vació: " + valor);
        }
    }
}
