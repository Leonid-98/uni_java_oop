package Leonid;

import java.awt.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
//        MyFrameRes frame = new MyFrameRes();
//        frame.setVisible(true);
//        openWebpage("https://sisu.ut.ee/elektroonika/28-takistite-v%C3%A4rvikoodid");

        MyFrameDY frame1 = new MyFrameDY();
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
