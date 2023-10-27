public class Lector extends Thread {
    private BuzonCorreo buzon;

    public Lector(BuzonCorreo buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {
        String mensaje = buzon.leerMensaje();
    }
}
