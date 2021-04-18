package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeltaYGui {
//    public static void main(String args[]) {
//        MyFrameDY frame = new MyFrameDY();
//        frame.setVisible(true);
//    }


}

class MyFrameDY extends JFrame {
    MyFrameDY() {
        this.setTitle("DeltaY converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("resistor.png");
        this.setIconImage(icon.getImage());

        MyLabelImageDY imageLabel = new MyLabelImageDY(15, 15);
        this.add(imageLabel);

        MyTextFieldDY textFieldR1 = new MyTextFieldDY(100, 310);
        MyTextFieldDY textFieldR2 = new MyTextFieldDY(100, 350);
        MyTextFieldDY textFieldR3 = new MyTextFieldDY(100, 390);
        this.add(textFieldR1);
        this.add(textFieldR2);
        this.add(textFieldR3);

        this.setLayout(null);
    }
}

class MyLabelImageDY extends JLabel {
    MyLabelImageDY(int posx, int posy) {
        ImageIcon image = new ImageIcon("deltaY_small.png");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(posx, posy, 900, 274);
    }
}

class MyTextFieldDY extends JTextField {
    MyTextFieldDY(int posx, int posy){
        this.setBounds(posx, posy, 85, 30);
        this.setFont(new Font("Rubik", Font.PLAIN, 20));
        this.setBackground(new Color(0xFAFFA9));
    }
}