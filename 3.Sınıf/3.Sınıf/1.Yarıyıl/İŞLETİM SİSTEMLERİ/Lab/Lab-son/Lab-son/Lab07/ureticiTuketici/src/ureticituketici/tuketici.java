package ureticituketici;

public class tuketici extends Thread {

    private kubDelik kubDelik;
    private int number;

    public tuketici(kubDelik c, int number) {
        kubDelik = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = kubDelik.get();
            System.out.println("tuketici #" + this.number
                    + " got: " + value);
        }
    }
}
