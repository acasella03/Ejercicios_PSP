public class Main {

    public static void main(String[] args) {
        Caja cajaIngreso = new Caja("ingresar");
        Caja cajaEgreso =new Caja("retirar");

        // Crear y ejecutar el hilo de ingresos y extracciones
        cajaIngreso.start();
        try {
            cajaIngreso.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        cajaEgreso.start();
    }
}