package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ResistorGui extends JFrame implements ActionListener {
    MyButton button;
    MyLabelText textLabel, infoLabel;
    MyLabelImage imageLabel;
    MyPanel panel1, panel2, panel3, panel4, panel5;
    MyComboBox combobox1, combobox2, combobox3, combobox4, combobox5;

    // See on text, mis läheb ComboBox'ile
    public static final String[] valuesString =
            {"none", "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    public static final String[] multipliersString =
            {"none", "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white", "silver", "gold"};
    public static final String[] tolerancesString =
            {"none", "black", "brown", "green", "blue", "violet", "gray", "silver", "gold"};

    ResistorGui() {
        this.setTitle("Resistance Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640, 400);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
        ImageIcon icon = new ImageIcon("resistor.png");
        this.setIconImage(icon.getImage());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 640, 400);
        this.add(layeredPane);

        button = new MyButton(450, 297, "GET RES", 20);
        combobox1 = new MyComboBox(70, 230, valuesString);
        combobox2 = new MyComboBox(170, 230, valuesString);
        combobox3 = new MyComboBox(270, 230, valuesString);
        combobox4 = new MyComboBox(370, 230, multipliersString);
        combobox5 = new MyComboBox(470, 230, tolerancesString);
        imageLabel = new MyLabelImage(15, 15, "Six-Band-Resistor-Color-Code.png", 594, 350);
        textLabel = new MyLabelText(25, 290, 24, "");
        infoLabel = new MyLabelText(65, 255, 16, " (1st Digit : 2nd Digit : 3th Digit : Multiplier : Tolerance)");
        panel1 = new MyPanel(80, 25);
        panel2 = new MyPanel(168, 25);
        panel3 = new MyPanel(238, 25);
        panel4 = new MyPanel(302, 25);
        panel5 = new MyPanel(418, 25);

        // Selleks, et värvi panelid oleksid all, ja teised elemendid - üleval
        layeredPane.add(imageLabel, JLayeredPane.DRAG_LAYER);
        layeredPane.add(infoLabel, JLayeredPane.DRAG_LAYER);
        layeredPane.add(button, JLayeredPane.DRAG_LAYER);
        layeredPane.add(combobox1, JLayeredPane.DRAG_LAYER);
        layeredPane.add(combobox2, JLayeredPane.DRAG_LAYER);
        layeredPane.add(combobox3, JLayeredPane.DRAG_LAYER);
        layeredPane.add(combobox4, JLayeredPane.DRAG_LAYER);
        layeredPane.add(combobox5, JLayeredPane.DRAG_LAYER);
        layeredPane.add(textLabel, JLayeredPane.DRAG_LAYER);
        layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel2, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel3, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel4, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel5, JLayeredPane.DEFAULT_LAYER);

        button.addActionListener(this);
        combobox1.addActionListener(e -> panel1.setColor(combobox1));
        combobox2.addActionListener(e -> panel2.setColor(combobox2));
        combobox3.addActionListener(e -> panel3.setColor(combobox3));
        combobox4.addActionListener(e -> panel4.setColor(combobox4));
        combobox5.addActionListener(e -> panel5.setColor(combobox5));
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            ArrayList<String> colors = new ArrayList<>() {{
                add(panel1.getColor());
                add(panel2.getColor());
                add(panel3.getColor());
                add(panel4.getColor());
                add(panel5.getColor());
            }};

            while (colors.contains("none"))
                colors.remove("none");

            try {
                switch (colors.size()) {
                    case 3 -> {
                        Resistor resistor3 = new Resistor(colors.get(0), colors.get(1), colors.get(2));
                        textLabel.setText(resistor3.toString());
                    }
                    case 4 -> {
                        Resistor resistor4 = new Resistor(colors.get(0), colors.get(1), colors.get(2), colors.get(3));
                        textLabel.setText(resistor4.toString());
                    }
                    case 5 -> {
                        Resistor resistor5 = new Resistor(colors.get(0), colors.get(1), colors.get(2), colors.get(3), colors.get(4));
                        textLabel.setText(resistor5.toString());
                    }
                    default -> textLabel.setText("Unable to calculate.");
                }
            } catch (NullPointerException e) {
                textLabel.setText(e.getMessage());
            }
        }
    }
}



