public class Metodo extends Thread{

    public Metodo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(getName()+ ": Iteración "+ i);
            try{
                Metodo.sleep((long) Math.random()*2000+500);
            } catch (InterruptedException e) {
            }
            System.out.println("Termina iteración " + getName());
        }
    }
}
