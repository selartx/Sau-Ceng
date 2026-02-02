package ureticituketici;

public class uretici extends Thread {

    private kubDelik kubDelik;
    private int number;

    public uretici(kubDelik c, int number) {
        kubDelik = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            kubDelik.put(i);
            System.out.println("uretici #" + this.number
                    + " put: " + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
