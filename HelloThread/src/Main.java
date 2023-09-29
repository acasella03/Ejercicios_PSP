public class Main {
    public static void main(String[] args) {
        new HelloTread("Pepe").start();
        new HelloTread("Juan").start();
        System.out.println("Termina thread main");
    }
}