/**
 * Extiende de Thread para contar las vocales
 */
public class ContadorHilo extends Thread {
    private String texto;
    private char vocal;
    private Contador contador;

    public ContadorHilo(String texto, char vocal, Contador contador) {
        this.texto = texto;
        this.vocal = vocal;
        this.contador = contador;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == vocal) {
                count++;
            }
        }
        contador.increment(count);
    }
}
