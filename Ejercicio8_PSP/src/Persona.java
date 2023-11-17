public class Persona extends Thread {
    private int pisoOrigen;
    private Ascensor ascensor;

    // Constructor que recibe el piso de origen y una instancia de Ascensor
    public Persona(int pisoOrigen, Ascensor ascensor) {
        this.pisoOrigen = pisoOrigen;
        this.ascensor = ascensor;
    }

    // Método run, que se ejecutará cuando se inicie el hilo
    @Override
    public void run() {
        // Bloque synchronized para evitar problemas de concurrencia
        synchronized (ascensor) {
            System.out.println("Persona en el piso " + pisoOrigen + " llama al ascensor");
        }
        // Llama al método irAPiso del objeto Ascensor
        ascensor.irAPiso(pisoOrigen);
    }
}
