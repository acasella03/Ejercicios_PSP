public class Ascensor {
    private int pisoActual;

    public Ascensor() {
        pisoActual = 0;
    }

    public synchronized void irAPiso(int destino){
        System.out.println("Ascensor en el piso " + pisoActual + " se dirige al piso " + destino);
        try {
            Thread.sleep(1000);//Simula el tiempo que tarda el ascensor en llegar al piso
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pisoActual = destino;
        System.out.println("Ascensor llega al piso " + pisoActual);
    }
}
