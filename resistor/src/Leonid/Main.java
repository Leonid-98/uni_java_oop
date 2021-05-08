package Leonid;

import Alexandr.FrameAlex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

        ResistorGui frame1 = new ResistorGui();
        DeltaYGui frame2 = new DeltaYGui();
        FrameAlex frame3 = new FrameAlex();
        frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        mainFrame.getButton1().addActionListener(e -> {
            frame3.setVisible(true);
            mainFrame.dispose();
        });
        mainFrame.getButton2().addActionListener(e -> {
            frame1.setVisible(true);
            mainFrame.dispose();
        });
        mainFrame.getButton3().addActionListener(e -> {
            frame2.setVisible(true);
            mainFrame.dispose();
        });
        mainFrame.getButtonFAQ1().addActionListener(e -> openWebpage("https://sisu.ut.ee/elektroonika/28-takistite-v%C3%A4rvikoodid"));
        mainFrame.getButtonFAQ2().addActionListener(e -> openWebpage("https://www.allaboutcircuits.com/textbook/direct-current/chpt-10/delta-y-and-y-conversions/"));

        JFrame[] frames = {frame1, frame2, frame3};
        for (JFrame frame : frames) {
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                    mainFrame.setVisible(true);
                }
            });
        }
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            logError(e.toString());
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
