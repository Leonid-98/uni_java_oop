package Leonid;

import javax.swing.*;
import java.awt.*;

public class MainWindowGui extends JFrame {
    private MyButton button1, button2, button3, button4, buttonFAQ1, buttonFAQ2;

    public MainWindowGui() {
        this.setTitle("Electrical calculator.");
        this.setResizable(false);
        this.setSize(535, 235);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("images/resistor.png");
        this.setIconImage(icon.getImage());
        this.setLocationRelativeTo(null);

        button1 = new MyButton(25, 25, "Detailed color band calculator", 20, 400, 33);
        button2 = new MyButton(25, 65, "Simple color band calculator", 20, 400, 33);
        button3 = new MyButton(25, 105, "Delta-to-Y converter", 20, 400, 33);
        button4 = new MyButton(25, 145, "Resistors in Parallel", 20, 400, 33);
        buttonFAQ1 = new MyButton(450, 25, "?", 20, 45, 33);
        buttonFAQ2 = new MyButton(450, 105, "?", 20, 45, 33);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(buttonFAQ1);
        this.add(buttonFAQ2);

        this.setLayout(null);
    }

    public MyButton getButton1() {
        return button1;
    }

    public MyButton getButton2() {
        return button2;
    }

    public MyButton getButton3() {
        return button3;
    }

    public MyButton getButton4() {
        return button4;
    }

    public MyButton getButtonFAQ1() {
        return buttonFAQ1;
    }

    public MyButton getButtonFAQ2() {
        return buttonFAQ2;
    }
}
