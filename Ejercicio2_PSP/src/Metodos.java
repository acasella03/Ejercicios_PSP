public class Metodos extends Thread{
    public Metodos(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(getName()+ ": Iteración "+ i);
            try{
                Metodos.sleep((long) Math.random()*1000+500);
            } catch (InterruptedException e) {
            }
            System.out.println("Termina iteración " + getName());
        }
    }
}
