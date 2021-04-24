package Leonid;

import javax.swing.*;
import java.awt.*;

public class DeltaYGui {
//    public static void main(String args[]) {
//        MyFrameDY frame = new MyFrameDY();
//        frame.setVisible(true);
//    }


}

class MyFrameDY extends JFrame {
    MyButtonDY button;
    MyLabelTextDY output;
    MyTextFieldDY fieldR1, fieldR2, fieldR3;
    MyLabelTextDY textR1, textR2, textR3;
    MyLabelImageDY imageLabel;
    MyLabelTextDY textR12, textR23, textR31;

    MyFrameDY() {
        this.setTitle("DeltaY converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("resistor.png");
        this.setIconImage(icon.getImage());

        imageLabel = new MyLabelImageDY(15, 15);
        fieldR1 = new MyTextFieldDY(100, 310);
        fieldR2 = new MyTextFieldDY(100, 350);
        fieldR3 = new MyTextFieldDY(100, 390);
        textR1 = new MyLabelTextDY(50, 305, 30, "R1              Oom"); // jah, mitte ilus
        textR2 = new MyLabelTextDY(50, 345, 30, "R2              Oom");
        textR3 = new MyLabelTextDY(50, 385, 30, "R3              Oom");
        textR12 = new MyLabelTextDY(680, 305, 30, "R12 =");
        textR23 = new MyLabelTextDY(680, 345, 30, "R23 =");
        textR31 = new MyLabelTextDY(680, 385, 30, "R31 =");
        button = new MyButtonDY(400, 305);
        output = new MyLabelTextDY(400, 345, 30, "");

        this.add(imageLabel);
        this.add(fieldR1);
        this.add(fieldR2);
        this.add(fieldR3);
        this.add(textR1);
        this.add(textR2);
        this.add(textR3);
        this.add(textR12);
        this.add(textR23);
        this.add(textR31);
        this.add(button);
        this.add(output);

        button.addActionListener(e -> calculateRes());

        this.setLayout(null);
    }

    public void calculateRes(){
        double r1 = Double.parseDouble(fieldR1.getText());
        double r2 = Double.parseDouble(fieldR2.getText());
        double r3 = Double.parseDouble(fieldR3.getText());


        ResistorsTriangle rt = new ResistorsTriangle(r1, r2, r3);
        textR12.setText("R12 = " + rt.getR12());
        textR23.setText("R23 = " + rt.getR23());
        textR31.setText("R31 = " + rt.getR31());

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
    MyTextFieldDY(int posx, int posy) {
        this.setBounds(posx, posy, 85, 30);
        this.setFont(new Font("Rubik", Font.PLAIN, 20));
        this.setBackground(new Color(0xFAFFA9));
    }
}

class MyLabelTextDY extends JLabel {
    MyLabelTextDY(int posx, int posy, int size, String text) {
        this.setText(text);
        this.setForeground(Color.black);
        this.setFont(new Font("Rubik", Font.PLAIN, size));
        this.setBounds(posx, posy, 500, 40);
    }
}

class MyButtonDY extends JButton {
    MyButtonDY(int posx, int poxy) {
        this.setText("GET RES");
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, 20));
        this.setBounds(posx, poxy, 127, 33);
    }
}
