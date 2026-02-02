package process_waitformethodexample2;

/**
 *
 * @author selmanhizal
 */
public class Process_waitForMethodExample2 {

    public static void main(String[] args) {
        try {
            // yeni bir proses olustur  
            System.out.println("Ms Paint calisacak.");
            Process p1 = Runtime.getRuntime().exec("mspaint.exe");
            // processin bitmesi beklenecek.  
            p1.waitFor();
            // mspaint.exe programi kapatildiginda devam edecek  
            System.out.println("Ms-paint ugulamasindan ciktiniz.");
            System.out.println("Notepad calisacak.");
            Process p2 = Runtime.getRuntime().exec("notepad.exe");
            // processin bitmesi beklenecek.  
            p2.waitFor();
            // notepad.exe programi kapatildiginda devam edecek   
            System.out.println("Notepad uygulamasindan ciktiniz.");

        } catch (Exception ex) {
            System.out.println("Oops! bir hata olustu.");
        }

    }
}
