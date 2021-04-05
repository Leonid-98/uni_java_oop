package Leonid;

import java.awt.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        openWebpage("https://sisu.ut.ee/elektroonika/28-takistite-v%C3%A4rvikoodid");
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
