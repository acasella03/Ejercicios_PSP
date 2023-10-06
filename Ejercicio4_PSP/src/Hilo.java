public class Hilo extends Thread{
    private int sum = 0;

    public Hilo(String str) {
        super(str);
    }

    @Override
    public void run() {
        switch (getName()) {
            case "Pares":
                for (int i = 2; i <= 1000; i += 2) {
                    sum += i;
                }
                break;
            case "Impares":
                for (int i = 1; i <= 1000; i += 2) {
                    sum += i;
                }
                break;
            case "TerminaDosTres":
                for (int i = 1; i <= 1000; i++) {
                    if (i % 10 == 2 || i % 10 == 3) {
                        sum += i;
                    }
                }
                break;
            default:
                System.out.println("Nombre de hilo no reconocido");
        }
    }

    public int getSum() {
        return sum;
    }
}
