package process_waitformethodexample3;

/**
 *
 * @author selmanhizal
 */
public class Process_waitForMethodExample3 {

    public static void main(String[] args) {
        try {
            System.out.println("Ms paint ve Notepad birlikte calistir.\n");
            System.out.println("1. Ms Paint calisacak.");
            Process p1 = Runtime.getRuntime().exec("mspaint.exe");
            System.out.println("2. Notepad calisacak.\n\n");
            Process p2 = Runtime.getRuntime().exec("notepad.exe");
            // p1 processinin bitmesi beklenecek.  
            p1.waitFor();
            // MS Paint uygulaması bittiginde buradan devam edecek  
            System.out.println("Ms-paint programindan ciktiniz.");
            p2.waitFor();
            System.out.println("Notepad programindan ciktiniz.");
        } catch (Exception ex) {
            System.out.println("Oops! an error has occurred.");
        }
    }

}
