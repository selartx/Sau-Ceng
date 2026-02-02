package deneme;

import java.util.concurrent.Semaphore;

public class Example extends Thread {

    int id;
    static Semaphore semaphore = new Semaphore(1);

    public Example(int id) {
        this.id = id;
    }

    public void run() {
        /*fonksiyon run()*/
        try {

            semaphore.acquire();
            /*kritik bölge başlangıcı*/

        } catch (InterruptedException e) {
        }
        System.out.println("Kritik bolge" + getName());
        semaphore.release();
        System.out.println("Thread birakildi:" + getName());
    }

    public static void main(String[] args) {
        Example esim1 = new Example(5);
        Example esim2 = new Example(2);
        esim1.start(); //thread başlat
        esim2.start();
    }
}
