package threada;

/**
 *
 * @author Selman HIZAL
 */
public class ThreadA {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        synchronized (b) {
            try {
                System.out.println("b threadin islemini bitirmesini bekle...");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Toplam: " + b.total);
        }
    }
}

class ThreadB extends Thread {

    int total;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            notify();
        }
    }
}
