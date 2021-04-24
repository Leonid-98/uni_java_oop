package Leonid;

import java.awt.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
//        frameColorBand frame = new frameColorBand();
//        frame.setVisible(true);
//        openWebpage("https://sisu.ut.ee/elektroonika/28-takistite-v%C3%A4rvikoodid");

        FrameDeltaY frame1 = new FrameDeltaY();
        frame1.setVisible(true);
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
