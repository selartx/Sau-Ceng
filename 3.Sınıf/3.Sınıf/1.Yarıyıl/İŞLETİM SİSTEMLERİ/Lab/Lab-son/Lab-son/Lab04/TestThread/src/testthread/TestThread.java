package testthread;

/**
 *
 * @author Selman HIZAL
 */
public class TestThread {

    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create threads
        PrintChar printA = new PrintChar('a', 100);
        PrintChar printB = new PrintChar('b', 100);
        PrintNum print100 = new PrintNum(100);

        // Start threads
        print100.start();
        printA.start();
        printB.start();
    }
}

class PrintChar extends Thread {

    private char charToPrint;
    private int times;

    //karakter yazdırma
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

// 1 den n e kadar rakam yazdırmak için
class PrintNum extends Thread {

    private int lastNum;

    /**
     * yazdır 1, 2, ... i
     */
    public PrintNum(int n) {
        lastNum = n;
    }

    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }
    }
}
