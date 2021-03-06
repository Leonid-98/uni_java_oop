package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class MyFrameConfig extends JFrame {
    public static final HashMap<String, Color> valuesColors = new HashMap<String, Color>() {{
        put("black", new Color(0x0));
        put("brown", new Color(0x8B4513));
        put("red", new Color(0xD51414));
        put("orange", new Color(0xFF8D00));
        put("yellow", new Color(0xEAFF00));
        put("green", new Color(0x00880A));
        put("blue", new Color(0x0A48DA));
        put("violet", new Color(0x9F0AF1));
        put("gray", new Color(0x575757));
        put("white", new Color(0xFFFFFF));
        put("gold", new Color(0xD4AF37));
        put("silver", new Color(0xB7B7B7));
        put("none", new Color(0xc17b23));
    }};

    public static final String[] valuesString =
            {"none", "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};

    MyFrameConfig() {
        this.setTitle("Resistance Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640, 400);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("resistor.png");
        this.setIconImage(icon.getImage());
    }
}

class MyFrame extends MyFrameConfig implements ActionListener {
    JButton button;
    JLabel textLabel, imageLabel;
    JPanel panel1, panel2, panel3, panel4, panel5;
    JComboBox combobox1, combobox2, combobox3, combobox4, combobox5;

    MyFrame() {
        String[] test = {"BLACK", "BROWN", "VIOLET", "YELLOW"};
        button = new MyButton(450, 290);
        combobox1 = new MyComboBox(70, 230, valuesString);
        combobox2 = new MyComboBox(170, 230, valuesString);
        combobox3 = new MyComboBox(270, 230, valuesString);
        combobox4 = new MyComboBox(370, 230, valuesString);
        combobox5 = new MyComboBox(470, 230, valuesString);
        imageLabel = new MyLabelImage(15, 15);
        textLabel = new MyLabelText(25, 290);
        panel1 = new MyPanel(80, 25);
        panel2 = new MyPanel(168, 25);
        panel3 = new MyPanel(238, 25);
        panel4 = new MyPanel(302, 25);
        panel5 = new MyPanel(418, 25);

        this.add(imageLabel);
        this.add(button);
        this.add(combobox1);
        this.add(combobox2);
        this.add(combobox3);
        this.add(combobox4);
        this.add(combobox5);
        this.add(textLabel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);

        button.addActionListener(this);
        combobox1.addActionListener(this);
        combobox2.addActionListener(this);
        combobox3.addActionListener(this);
        combobox4.addActionListener(this);
        combobox5.addActionListener(this);

        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");

        if (e.getSource() == button) {
            textLabel.setText("ZOPA");
        }
        if (e.getSource() == combobox1) {
            String x = (String) combobox1.getSelectedItem();
            Color color = valuesColors.get(x);
            panel1.setBackground(color);
            imageLabel.setIcon(image);

        } else if (e.getSource() == combobox2) {
            String x = (String) combobox2.getSelectedItem();
            Color color = valuesColors.get(x);
            panel2.setBackground(color);
            imageLabel.setIcon(image);

        } else if (e.getSource() == combobox3) {
            String x = (String) combobox3.getSelectedItem();
            Color color = valuesColors.get(x);
            panel3.setBackground(color);
            imageLabel.setIcon(image);

        } else if (e.getSource() == combobox4) {
            String x = (String) combobox4.getSelectedItem();
            Color color = valuesColors.get(x);
            panel4.setBackground(color);
            imageLabel.setIcon(image);

        } else if (e.getSource() == combobox5) {
            String x = (String) combobox5.getSelectedItem();
            Color color = valuesColors.get(x);
            panel5.setBackground(color);
            imageLabel.setIcon(image);
        }
    }
}

class MyLabelImage extends JLabel {
    MyLabelImage(int posx, int posy) {
        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(posx, posy, 594, 350);
    }
}

class MyLabelText extends JLabel {
    MyLabelText(int posx, int posy) {
        this.setText("10_000_TEST_000 Ohm +/- N/A");
        this.setForeground(Color.black);
        this.setFont(new Font("Rubik", Font.PLAIN, 24));
        this.setBounds(posx, posy, 500, 40);
    }
}

class MyButton extends JButton {
    MyButton(int posx, int poxy) {
        this.setText("GET RES");
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, 20));
        this.setBounds(posx, poxy, 127, 40);
    }
}

class MyComboBox extends JComboBox {
    MyComboBox(int posx, int posy, String[] array) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(array);
        this.setModel(model);
        this.setBounds(posx, posy, 95, 30);
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, 16));
    }
}

class MyPanel extends JPanel {
    MyPanel(int posx, int posy) {
        this.setBackground(new Color(0xc17b23));
        this.setBounds(posx, posy, 60, 180);
    }
}

