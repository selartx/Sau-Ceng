package ureticituketici;

/**
 *
 * @author Selman HIZAL
 */
public class UreticiTuketici {

    public static void main(String[] args) {
        kubDelik c = new kubDelik();
        uretici p1 = new uretici(c, 1);
        tuketici c1 = new tuketici(c, 1);

        p1.start();
        c1.start();
    }
}
