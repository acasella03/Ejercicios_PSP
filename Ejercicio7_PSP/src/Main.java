public class Main {
    public static void main(String[] args) {

        BuzonCorreo buzon = new BuzonCorreo();

        Lector lector1 = new Lector(buzon);
        Lector lector2 = new Lector(buzon);
        Lector lector3= new Lector(buzon);
        Escritor escritor1 = new Escritor(buzon, "Mensaje 1");
        Escritor escritor2 = new Escritor(buzon, "Mensaje 2");
        Escritor escritor3= new Escritor(buzon, "Mensaje 3");

        lector1.start();
        lector2.start();
        lector3.start();
        escritor1.start();
        escritor2.start();
        escritor3.start();
    }
}
