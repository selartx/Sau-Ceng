package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Selman HIZAL
 */
public class Mavenproject1 {

    public static void disk() {
        File file = new File("c:");
        long totalSpace = file.getTotalSpace(); //toplam boş alan
        long usableSpace = file.getUsableSpace();
        long freeSpace = file.getFreeSpace();

        out.println(" === Partition Detail ===");

        out.println(" === bytes ===");
        System.out.println("Toplam alan : " + totalSpace + " bytes");
        System.out.println("Toplam bos kullanilabilir : " + usableSpace + " bytes");
        System.out.println("Bos alan : " + freeSpace + " bytes");

        System.out.println(" === Megabyte (MB) ===");
        System.out.println("mb cinsinden toplam : " + totalSpace / 1024 / 1024 + " mb");
        System.out.println("mb cinsinden toplam kullanilabilir : " + usableSpace / 1024 / 1024 + " mb");
        System.out.println("mb cinsinden toplam bos : " + freeSpace / 1024 / 1024 + " mb");
    }

    public static void eris() {

        boolean connectivity;
        try {
            URL url = new URL("https://cs.subu.edu.tr/");
            URLConnection conn = url.openConnection();
            conn.connect();
            connectivity = true;

        } catch (Exception e) {
            connectivity = false;
        }
        if (connectivity == true) {
            System.out.println("baglanti var");
        }
    }

    public static void main(String[] args) {
        disk();
        eris();

        try {
            String line;
            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe"); //Windows
            //Process p = Runtime.getRuntime().exec("ps -e"); //Linux
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }

    }
}
