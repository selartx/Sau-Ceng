package threadexample1;

/**
 *
 * @author Selman HIZAL
 */
// Thread sınıfını extend ederek runnable interface'i uygula  
public class ThreadExample1 extends Thread {

    // thread'in calismasi icin run() metodu   
    public void run() {
        int a = 10;
        int b = 12;
        int result = a + b;
        System.out.println("Thread calismaya basladi..");
        System.out.println("iki Sayinin Toplami: " + result);
    }

    public static void main(String args[]) {
        // Thread sınıfını extend eden bir sınıfın ornegini olustur  
        ThreadExample1 t1 = new ThreadExample1();
        // start() metodunu cagirarak, run() metodunun calismasini sagla  
        t1.start();
    }
}
