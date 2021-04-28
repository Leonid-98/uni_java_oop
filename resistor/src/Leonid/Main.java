package Leonid;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        ResistorGui frame1 = new ResistorGui();
        frame1.setVisible(true);
//        openWebpage("https://sisu.ut.ee/elektroonika/28-takistite-v%C3%A4rvikoodid");

        DeltaYGui frame2 = new DeltaYGui();
        frame2.setVisible(true);

    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logError(String text) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ErrorLog.txt", true)))) {
            String time = new SimpleDateFormat("[dd.MM.yyyy](HH:mm:ss): ").format(Calendar.getInstance().getTime());
            bw.write(time + text + "\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
