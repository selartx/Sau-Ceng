package testthread;

/**
 *
 * @author Selman HIZAL
 */
public class TestThread {

    public final static int NUMTHREADS = 3;
    public static int sharedData = 0;
    public static int sharedData2 = 0;

    static class theLock extends Object {
    }
    static public theLock lockObject1 = new theLock();

    // static public theLock lockObject = new theLock();
    static class theThread extends Thread {

        public void run() {
            System.out.print("Thread " + getName() + ": Girdi\n");
            synchronized (lockObject1) {
                /**
                 * ******** Kritik Bölge ******************
                 */
                System.out.print("Thread " + getName()
                        + ": Kritik bolge basla, senkron blok tutuldu\n");
                ++sharedData;
                --sharedData2;
                System.out.print("Thread " + getName()
                        + ": Kritik bolge bitir, senkron blogu birak\n");
                /**
                 * ******** Kritik bölge ******************
                 */
            }
        }
    }

    /**
     * Main
     */
    public static void main(String[] args) throws InterruptedException {
        theThread threads[] = new theThread[NUMTHREADS];
        System.out.print("Test islemine gir\n");

        System.out.print("Paylasimli veriye erisimi engellemek icin senkronize et\n");
        synchronized (lockObject1) {

            System.out.print("Thread olustur\n");
            for (int i = 0; i < NUMTHREADS; ++i) {
                threads[i] = new theThread();
                threads[i].start();
            }

            System.out.print("Paylasilan veri isi icin bekle\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.print("bekleme bitti\n");
            }
            System.out.print("kilitli veriyi ac\n");
        }

        System.out.print("Threadleri isinin bitmesi icin bekle\n");
        for (int i = 0; i < NUMTHREADS; ++i) {
            threads[i].join();
        }
    }
}
