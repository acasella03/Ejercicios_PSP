public class BuzonCorreo {
    private String mensaje;
    private boolean mensajePresente;

    public synchronized void enviarMensaje(String mensaje) {
        while (mensajePresente) {
            try {
                wait(); // Esperar si el buzón ya contiene un mensaje
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.mensaje = mensaje;
        mensajePresente = true;
        System.out.println("Mensaje enviado: " + mensaje);
        notifyAll(); // Notificar a los hilos que esperan para leer
    }

    public synchronized String leerMensaje() {
        while (!mensajePresente) {
            try {
                wait(); // Esperar si el buzón está vacío
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String mensajeLeido = this.mensaje;
        mensajePresente = false;
        System.out.println("Mensaje leído: " + mensajeLeido);
        notifyAll(); // Notificar a los hilos que esperan para escribir
        return mensajeLeido;
    }
}
