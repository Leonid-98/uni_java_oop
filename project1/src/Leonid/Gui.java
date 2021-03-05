package Leonid;

import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640, 400);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
//        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
//        this.setIconImage(image.getImage());

    }
}

class MyLabel extends JLabel{
    MyLabel(){
        ;
    }
}


