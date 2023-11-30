public class Carrera {
    static final int META = 70;
    private static final int INICIO = 1;

    private int posicionLiebre;
    private int posicionTortuga;

    public Carrera() {
        this.posicionLiebre = INICIO;
        this.posicionTortuga = INICIO;
    }

    public synchronized void avanzarLiebre(int cantidad) {
        posicionLiebre += cantidad;
        if (posicionLiebre > META) {
            posicionLiebre = META;
        }
    }

    public synchronized void avanzarTortuga(int cantidad) {
        posicionTortuga += cantidad;
        if (posicionTortuga > META) {
            posicionTortuga = META;
        }
    }

    public int getPosicionLiebre() {
        return posicionLiebre;
    }

    public int getPosicionTortuga() {
        return posicionTortuga;
    }
}
