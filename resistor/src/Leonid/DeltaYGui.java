package Leonid;

import javax.swing.*;
import java.awt.*;

class FrameDeltaY extends JFrame {
    MyButton button;
    MyLabelText output;
    MyTextField fieldR1, fieldR2, fieldR3;
    MyLabelText textR1, textR2, textR3;
    MyLabelImage imageLabel;
    MyLabelText textR12, textR23, textR31;

    FrameDeltaY() {
        this.setTitle("DeltaY converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("resistor.png");
        this.setIconImage(icon.getImage());

        imageLabel = new MyLabelImage(15, 15, "deltaY_small.png", 900, 274);
        fieldR1 = new MyTextField(100, 310);
        fieldR2 = new MyTextField(100, 350);
        fieldR3 = new MyTextField(100, 390);
        textR1 = new MyLabelText(50, 305, 30, "R1              Oom"); // jah, mitte ilus
        textR2 = new MyLabelText(50, 345, 30, "R2              Oom");
        textR3 = new MyLabelText(50, 385, 30, "R3              Oom");
        textR12 = new MyLabelText(680, 305, 30, "R12 =");
        textR23 = new MyLabelText(680, 345, 30, "R23 =");
        textR31 = new MyLabelText(680, 385, 30, "R31 =");
        button = new MyButton(400, 305, "GET RES", 20);
        output = new MyLabelText(400, 345, 30, "");

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

    public void calculateRes() {
        double r1 = Double.parseDouble(fieldR1.getText());
        double r2 = Double.parseDouble(fieldR2.getText());
        double r3 = Double.parseDouble(fieldR3.getText());


        DeltaY rt = new DeltaY(r1, r2, r3);
        textR12.setText("R12 = " + rt.getR12());
        textR23.setText("R23 = " + rt.getR23());
        textR31.setText("R31 = " + rt.getR31());

    }
}


