import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Ascensor ascensor = new Ascensor();
        Random random = new Random();

        //Simula llamadas al ascensor desde diferentes pisos
        for (int i = 0; i < 10; i++) {
            //Genera un piso aleatorio entre 1 y 20
            int pisoAleatorio = random.nextInt(20)+1;
            // Crea una instancia de Persona con el piso aleatorio y la referencia al ascensor
            Persona persona = new Persona(pisoAleatorio, ascensor);
            // Inicia el hilo de la persona
            persona.start();
            try {
                Thread.sleep(1000);//Simula el tiempo entre llamadas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}