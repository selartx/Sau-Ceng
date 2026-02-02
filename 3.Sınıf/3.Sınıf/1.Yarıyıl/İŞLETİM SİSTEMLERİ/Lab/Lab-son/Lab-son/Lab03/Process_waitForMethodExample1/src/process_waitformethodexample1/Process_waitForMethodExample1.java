package process_waitformethodexample1;

/**
 *
 * @author selmanhizal
 */
public class Process_waitForMethodExample1 {

    public static void main(String[] args) {
        try {
            // yeni bir process olustur 
            System.out.println("Ms Paint programi calistir.");
            Process p = Runtime.getRuntime().exec("mspaint.exe");
            // siz sonlandırana kadar processi bekler.  
            p.waitFor();
            // Ms Paint.exe programını manuel olarak kapattiginizda buradan devam edecek  
            System.out.println("Ms paint programindan ciktiniz.");
        } catch (Exception ex) {
            System.out.println("exception is:" + ex);
        }
    }
}
