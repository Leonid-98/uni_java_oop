package Leonid;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class MyLabelText extends JLabel {
    MyLabelText(int posx, int posy, int size, String text) {
        this.setText(text);
        this.setForeground(Color.black);
        this.setFont(new Font("Rubik", Font.PLAIN, size));
        this.setBounds(posx, posy, 500, 40);
    }
}

class MyLabelImage extends JLabel {
    MyLabelImage(int posx, int posy, String filename, int width, int height) {
        ImageIcon image = new ImageIcon(filename);
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(posx, posy, width, height);
    }
}

class MyButton extends JButton {
    MyButton(int posx, int poxy, String text, int size, int width) {
        this.setText(text);
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, size));
        this.setBounds(posx, poxy, width, 33);
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
    // võtab combobox'ist string. Meetod setColor muutab vastavalt stringile värv
    private static final HashMap<String, Color> valuesColors = new HashMap<>() {{
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
    private String color;

    MyPanel(int posx, int posy) {
        this.setBackground(new Color(0xc17b23));
        this.color = "none";
        this.setBounds(posx, posy, 60, 180);
    }

    public void setColor(MyComboBox combobox) {
        String x = (String) combobox.getSelectedItem();
        this.setBackground(valuesColors.get(x));
        this.color = x;
    }

    public String getColor() {
        return this.color;
    }
}

class MyTextField extends JTextField {
    MyTextField(int posx, int posy) {
        this.setBounds(posx, posy, 85, 30);
        this.setFont(new Font("Rubik", Font.PLAIN, 20));
        this.setBackground(new Color(0xFAFFA9));
    }
}
