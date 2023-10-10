import java.text.DecimalFormat;

class Caja extends Thread {
    private double saldo;
    private DecimalFormat formatoDecimal;

    public Caja (String str){
        super(str);
        this.saldo = 1000.0;
        this.formatoDecimal = new DecimalFormat("#.##");
    }

    public void realizarIngreso(double importe) {
        saldo += importe;
        System.out.println("Ingreso: +" + formatoDecimal.format(importe) + " euros");
        System.out.println("Saldo actual: " + formatoDecimal.format(saldo) + " euros\n");
    }

    public void realizarExtraccion(double importe) {
        if (saldo >= importe) {
            saldo -= importe;
            System.out.println("Extracción: -" + formatoDecimal.format(importe) + " euros");
            System.out.println("Saldo actual: " + formatoDecimal.format(saldo) + " euros\n");
        } else {
            System.out.println("Saldo insuficiente para la extracción.");
        }
    }

    @Override
    public void run() {
        if (getName().equals("ingresar")){
            // Simular 10 ingresos
            for (int i = 0; i < 10; i++) {
                double importe = Math.round(Math.random() * 100 * 100.0) / 100.0; // Monto aleatorio entre 0 y 100 euros
                realizarIngreso(importe);
            }
        }else if (getName().equals("retirar")){
            // Simular 5 extracciones
            for (int i = 0; i < 5; i++) {
                double importe = Math.round(Math.random() * 50 * 100.0) / 100.0; // Monto aleatorio entre 0 y 50 euros
                realizarExtraccion(importe);
            }
        }

    }
}
