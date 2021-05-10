package Leonid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Leonid.Main.logError;

public class ParralelResGui extends JFrame {
    MyButton buttonAdd, buttonRemove, buttonCalc;
    MyTextField textFieldR1, textFieldR2;
    MyLabelText textLabel;
    ArrayList<MyTextField> textFields;
    int posy = 105;  // algne positsiion uusi TextField'i jaoks
    int count = 0;   // algne indeks uusi TextField'i jaoks

    public ParralelResGui() {
        this.setTitle("Resistors in Parallel.");
        this.setResizable(false);
        this.setSize(290, 500);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("images/resistor.png");
        this.setIconImage(icon.getImage());
        this.setLocationRelativeTo(null);

        textFields = new ArrayList<>();

        buttonAdd = new MyButton(150, 25, "Add", 20, 100, 33);
        buttonRemove = new MyButton(150, 65, "X", 20, 100, 33);
        buttonCalc = new MyButton(150, 105, "=", 20, 100, 33);
        textFieldR1 = new MyTextField(25, 25, 100, 33);
        textFieldR2 = new MyTextField(25, 65, 100, 33);
        textLabel = new MyLabelText(150, 145, 20, "");

        textFieldR1.setText("R1");
        textFieldR2.setText("R2");

        buttonAdd.addActionListener(event -> addTextField());
        buttonRemove.addActionListener(event -> removeTextField());
        buttonCalc.addActionListener(event -> calculateRes());

        this.add(buttonAdd);
        this.add(buttonRemove);
        this.add(buttonCalc);
        this.add(textFieldR1);
        this.add(textFieldR2);
        this.add(textLabel);

        this.setLayout(null);
    }

    private void addTextField() {
        if (count < 8) {
            MyTextField textField = new MyTextField(25, posy, 100, 33);
            textField.setText("R" + (count + 3));
            this.add(textField);
            this.revalidate();
            this.repaint();
            textFields.add(textField);
            posy += 40;
            count++;
        }

    }

    private void removeTextField() {
        if (count > 0) {
            this.remove(textFields.get(count - 1));
            textFields.remove(count - 1);
            this.revalidate();
            this.repaint();
            posy -= 40;
            count--;
        }
    }

    private void calculateRes() {
        // 1/R = 1/R1 + 1/R2 + ... + 1/Rn -> Rööbiti ühendus
        try {
            double invertSum = 1 / Double.parseDouble(textFieldR1.getText()) +
                    1 / Double.parseDouble(textFieldR2.getText());
            for (MyTextField elem : textFields)
                invertSum += 1 / Double.parseDouble(elem.getText());
            textLabel.setText(round(1 / invertSum) + " \u03A9");

        } catch (NumberFormatException e) {
            logError(e.toString());
            textLabel.setText("Input Error");
        }
    }

    public static double round(double val) {
        val = val * 1000;
        val = Math.round(val);
        return val / 1000;
    }
}
