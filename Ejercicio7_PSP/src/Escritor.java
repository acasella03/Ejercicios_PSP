public class Escritor extends Thread {
    private BuzonCorreo buzon;
    private String mensaje;

    public Escritor(BuzonCorreo buzon, String mensaje) {
        this.buzon = buzon;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        buzon.enviarMensaje(mensaje);
    }
}
