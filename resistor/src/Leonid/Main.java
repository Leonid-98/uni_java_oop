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
        MainWindowGui mainWindowGui = new MainWindowGui();
        mainWindowGui.setVisible(true);
        mainWindowGui.setDefaultCloseOperation(mainWindowGui.EXIT_ON_CLOSE);

        FrameAlex frame1 = new FrameAlex();
        ResistorGui frame2 = new ResistorGui();
        DeltaYGui frame3 = new DeltaYGui();
        ParralelResGui frame4 = new ParralelResGui();
        frame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame4.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        mainWindowGui.getButton1().addActionListener(e -> {
            frame1.setVisible(true);
            mainWindowGui.dispose();
        });
        mainWindowGui.getButton2().addActionListener(e -> {
            frame2.setVisible(true);
            mainWindowGui.dispose();
        });
        mainWindowGui.getButton3().addActionListener(e -> {
            frame3.setVisible(true);
            mainWindowGui.dispose();
        });
        mainWindowGui.getButton4().addActionListener(e -> {
            frame4.setVisible(true);
            mainWindowGui.dispose();
        });
        mainWindowGui.getButtonFAQ1().addActionListener(e -> openWebpage("https://sisu.ut.ee/elektroonika/28-takistite-v%C3%A4rvikoodid"));
        mainWindowGui.getButtonFAQ2().addActionListener(e -> openWebpage("https://www.allaboutcircuits.com/textbook/direct-current/chpt-10/delta-y-and-y-conversions/"));

        // instead of EXIT_ON_CLOSE
        JFrame[] frames = {frame1, frame2, frame3, frame4};
        for (JFrame frame : frames) {
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                    mainWindowGui.setVisible(true);
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
