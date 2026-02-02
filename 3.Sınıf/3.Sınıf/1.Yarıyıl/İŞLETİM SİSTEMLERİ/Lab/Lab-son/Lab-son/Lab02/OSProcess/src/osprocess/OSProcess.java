package osprocess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author shiza
 */
public class OSProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Usage: java OSProcess <command>");
            System.exit(0);
        }
        // args[0] is the command that is run in a separate process
        ProcessBuilder pb = new ProcessBuilder(args[0], args[1], args[2],"www.sakarya.edu.tr");
        //ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "ping");
        Process process = pb.start();
        // obtain the input stream
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        // read the output of the process
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        String[] commandLine = {args[0], args[1],"dir"};
        Process process2 = Runtime.getRuntime().exec(commandLine);
        System.out.println(process2.pid());
        eris();
    }
    
    public static void eris(){
		
		boolean connectivity;
		try {
		    URL url = new URL("https://www.sakarya.edu.tr/");
		    URLConnection conn = url.openConnection();
		    conn.connect();
		    connectivity = true;
		 
		} catch (Exception e) {
		    connectivity = false;
		}
		if(connectivity==true)
                    System.out.println("Baglanti basarili");
       }

}
