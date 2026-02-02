package threadexample2;

/**
 *
 * @author Selman HIZAL
 */
class NewThread implements Runnable {

    String name;
    Thread thread;

    NewThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("Yeni thread: " + thread + "olusturuldu\n");
        thread.start();
    }

    public void run() {
        try {
            for (int j = 5; j > 0; j--) {
                System.out.println(name + ": " + j);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " thread kesintiye ugradi");
        }
        System.out.println(name + " thread cikiliyor.");
    }
}

class ThreadExample2 {

    public static void main(String args[]) {
        new NewThread("Thread 1.");
        new NewThread("Thread 2.");
        new NewThread("Thread 3.");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException excetion) {
            System.out.println("Main Thread kesintiye ugradi");
        }
        System.out.println("Main Thread'den cikiliyor");
    }
}
