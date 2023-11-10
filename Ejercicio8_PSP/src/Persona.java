public class Persona extends Thread {
    private int pisoOrigen;
    private Ascensor ascensor;

    public Persona(int pisoOrigen, Ascensor ascensor) {
        this.pisoOrigen = pisoOrigen;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        synchronized (ascensor) {
            System.out.println("Persona en el piso " + pisoOrigen + " llama al ascensor");
        }
        ascensor.irAPiso(pisoOrigen);
    }
}
