package Leonid;

import javax.swing.*;
import java.awt.*;

public class MyFrameConfig extends JFrame {
    Color bgColor = new Color(0xEDFBC1);

    MyFrameConfig(){
            this.setTitle("Resistance Calculator");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(640, 400);
            this.getContentPane().setBackground(bgColor);
//        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
//        this.setIconImage(image.getImage());
    }
}
