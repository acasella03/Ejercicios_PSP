/**
 *  Se encarga de mantener el recuento total de vocales
 */
public class Contador {
    private int totalVocales = 0;

    public synchronized void increment(int count) {
        totalVocales += count;
    }

    public int getTotalVocales() {
        return totalVocales;
    }
}
