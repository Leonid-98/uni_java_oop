package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    Button button;
    public static void main(String[] args) {
//        Resistor res1 = new Resistor("yellow", "yellow", "yellow");
//        System.out.println(res1);
//        res1.line1 = "brown";
//        System.out.println(res1);


        Color resistorColor = new Color(0xc17b23);


        MyFrame frame = new MyFrame();
        JLabel label = new JLabel();
        frame.add(label);


        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT< RIGHT < CNTER
        label.setVerticalTextPosition(JLabel.BOTTOM); // top, cent, bottom
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setBounds(15, 15 , 594, 350);


        frame.setLayout(null);


        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setBounds(80, 25, 60, 180);
        frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setBounds(168, 25, 60, 180);
        frame.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.setBounds(238, 25, 60, 180);
        frame.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.black);
        panel4.setBounds(302, 25, 60, 180);
        frame.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.MAGENTA);
        panel5.setBounds(418, 25, 60, 180);
        frame.add(panel5);

        JLabel textLabel = new JLabel();
        textLabel.setText("10_000_TEST_000 Ohm +/- N/A");
        textLabel.setForeground(Color.black);
        textLabel.setFont(new Font("Rubik", Font.PLAIN, 24));
        textLabel.setBounds(25, 290 , 500, 40);
        frame.add(textLabel);
        frame.setVisible(true);


    }
}
