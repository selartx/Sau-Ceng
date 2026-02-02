package testprocessbuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author shiza
 */
public class TestProcessBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try
        {
            String threeCommands[] = 
                { "cmd", "/c", 
                    "dir", // prints out directory list text 
                    "&&",
                    "ping", "google.com",
                    "&&",
                    "tasklist" // prints out task list text
                };
            ProcessBuilder builder = new ProcessBuilder(threeCommands);
            builder.directory(new File("C://"));
            builder.redirectErrorStream();

            Process subProcess = builder.start();

            // this reads from the subprocess's output stream
            BufferedReader subProcessInputReader = 
                new BufferedReader(new InputStreamReader(subProcess.getInputStream()));

            String line = null;
            while ((line = subProcessInputReader.readLine()) != null)
                System.out.println(line);

            subProcessInputReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
