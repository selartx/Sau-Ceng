package testthread;

/**
 *
 * @author Selman HIZAL
 */
public class TestThread {

    /**
     * Main method
     */
    public static void main(String[] args) throws InterruptedException {
        ortalama x1 = new ortalama(args);
        min x2 = new min(args);
        max x3 = new max(args);
        x1.start();
        x2.start();
        x3.start();
    }
}

class ortalama extends Thread {

    String[] a;
    double ortalama;
    double toplam;

    public ortalama(String[] k) {
        a = k;

    }

    public void run() {
        for (int i = 0; i < a.length; i++) {
            toplam += Double.parseDouble(a[i]);
        }
        ortalama = toplam / a.length;
        System.out.println("ortalama=" + ortalama);
    }
}

class min extends Thread {

    String[] a;
    double minimum;

    public min(String[] k) {
        a = k;
    }

    public void run() {
        minimum = Double.parseDouble(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (Double.parseDouble(a[i]) < minimum) {
                minimum = Double.parseDouble(a[i]);
            }

        }
        System.out.println("min=" + minimum);
    }

}

class max extends Thread {

    String[] a;
    double maximum;

    public max(String[] k) {
        a = k;

    }

    public void run() {

        maximum = Double.parseDouble(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (Double.parseDouble(a[i]) > maximum) {
                maximum = Double.parseDouble(a[i]);
            }

        }
        System.out.println("max=" + maximum);
    }
}
