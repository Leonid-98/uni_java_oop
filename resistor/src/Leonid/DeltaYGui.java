package Leonid;

import javax.swing.*;
import java.awt.*;

import static Leonid.Main.logError;

public class DeltaYGui extends JFrame {
    MyButton button;
    MyLabelText output;
    MyTextField fieldR1, fieldR2, fieldR3;
    MyLabelText textR1, textR2, textR3;
    MyLabelImage imageLabel;
    MyLabelText textR12, textR23, textR31;

    DeltaYGui() {
        this.setTitle("Delta-to-Y calculator.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("images/resistor.png");
        this.setIconImage(icon.getImage());
        this.setLocationRelativeTo(null);

        imageLabel = new MyLabelImage(15, 15, "images/deltaY_small.png", 900, 274);
        fieldR1 = new MyTextField(100, 310, 85, 30);
        fieldR2 = new MyTextField(100, 350, 85, 30);
        fieldR3 = new MyTextField(100, 390, 85, 30);
        textR1 = new MyLabelText(50, 305, 30, "R1         \u03A9"); // Omega täht
        textR2 = new MyLabelText(50, 345, 30, "R2         \u03A9");
        textR3 = new MyLabelText(50, 385, 30, "R3         \u03A9");
        textR12 = new MyLabelText(680, 305, 30, "R12 =");
        textR23 = new MyLabelText(680, 345, 30, "R23 =");
        textR31 = new MyLabelText(680, 385, 30, "R31 =");
        button = new MyButton(400, 305, "GET RES", 20, 127, 33);
        output = new MyLabelText(350, 345, 30, "");

        button.addActionListener(e -> calculateRes());

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

        this.setLayout(null);
    }

    public void calculateRes() {
        try {
            output.setText("");
            double r1 = Double.parseDouble(fieldR1.getText());
            double r2 = Double.parseDouble(fieldR2.getText());
            double r3 = Double.parseDouble(fieldR3.getText());
            DeltaYLogic dY = new DeltaYLogic(r1, r2, r3);
            textR12.setText("R12 = " + dY.getR12() + " \u03A9");
            textR23.setText("R23 = " + dY.getR23() + " \u03A9");
            textR31.setText("R31 = " + dY.getR31() + " \u03A9");

        } catch (NumberFormatException e) {
            logError(e.fillInStackTrace().toString());
            if (e.getMessage().equals("empty String"))
                output.setText("Empty field");
            if (e.getMessage().contains("For input string")) {
                output.setText("Input is not a number");
            }
        } catch (IllegalArgumentException e) {
            logError(e.fillInStackTrace().toString());
            output.setText(e.getMessage());
        }
    }


}



