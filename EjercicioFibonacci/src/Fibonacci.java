public class Fibonacci extends Thread {
    int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        int a=0;
        int b=1;
        for (int i = 0; i < n; i++) {
            System.out.println(a + " ");
            int contador=a;
            a=b;
            b=contador+b;
        }
        System.out.println("Fin del Thread");
    }
}