public class Main {
    public static void main(String[] args) {
        // Crear instancias de los tres hilos
        Hilo hiloPares = new Hilo("Pares");
        Hilo hiloImpares = new Hilo("Impares");
        Hilo hiloTerminaDosTres = new Hilo("TerminaDosTres");

        // Iniciar los tres hilos simultáneamente
        hiloPares.start();
        hiloImpares.start();
        hiloTerminaDosTres.start();

        try {
            // Esperar a que los hilos terminen
            hiloPares.join();
            hiloImpares.join();
            hiloTerminaDosTres.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtener los resultados de cada hilo
        int sumaPares = ((Hilo) hiloPares).getSum();
        int sumaImpares = ((Hilo) hiloImpares).getSum();
        int sumaTerminaDosTres = ((Hilo) hiloTerminaDosTres).getSum();

        // Mostrar los resultados
        System.out.println("Suma de pares: " + sumaPares);
        System.out.println("Suma de impares: " + sumaImpares);
        System.out.println("Suma de números que terminan en dos o tres: " + sumaTerminaDosTres);

    }
}