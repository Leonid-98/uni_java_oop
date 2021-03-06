package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends MyFrameConfig implements ActionListener {
    JButton button;
    JComboBox combobox1, combobox2, combobox3, combobox4, combobox5;
    JLabel textLabel;
    MyFrame() {
        String[] test = {"BLACK", "BROWN", "VIOLET", "YELLOW"};
        button = new MyButton(450, 290);
        combobox1 = new MyComboBox(70, 230, test);
        combobox2 = new MyComboBox(170, 230, test);
        combobox3 = new MyComboBox(270, 230, test);
        combobox4 = new MyComboBox(370, 230, test);
        combobox5 = new MyComboBox(470, 230, test);
        JLabel imageLabel = new MyLabelImage(15, 15);
        this.setLayout(null);
        textLabel = new MyLabelText(25, 290);
        JPanel panel1 = new MyPanel(80, 25);
        JPanel panel2 = new MyPanel(168, 25);
        JPanel panel3 = new MyPanel(238, 25);
        JPanel panel4 = new MyPanel(302, 25);
        JPanel panel5 = new MyPanel(418, 25);

        button.addActionListener(this);
        combobox1.addActionListener(this);
        combobox2.addActionListener(this);
        combobox3.addActionListener(this);
        combobox4.addActionListener(this);
        combobox5.addActionListener(this);

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

        panel1.setBackground(Color.green);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            textLabel.setText("ZOPA");
        }
        if(e.getSource()==combobox1){
            String x = (String) combobox1.getSelectedItem();
            textLabel.setText(x);
        }
    }
}

class MyLabelImage extends JLabel{
    MyLabelImage(int posx, int posy){
        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT< RIGHT < CNTER
        this.setVerticalTextPosition(JLabel.BOTTOM); // top, cent, bottom
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(posx, posy , 594, 350);
    }
}

class MyLabelText extends JLabel{
    MyLabelText(int posx, int posy){
        this.setText("10_000_TEST_000 Ohm +/- N/A");
        this.setForeground(Color.black);
        this.setFont(new Font("Rubik", Font.PLAIN, 24));
        this.setBounds(posx, posy , 500, 40);
    }
}

class MyButton extends JButton{
    MyButton(int posx, int poxy){
        this.setText("GET RES");
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, 20));
        this.setBounds(posx, poxy, 127, 40);
    }
}

class MyComboBox extends JComboBox{
    MyComboBox(int posx, int posy, String[] array){
//        String[] test = {"BLACK", "BROWN", "VIOLET", "YELLOW"};
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(array);
        this.setModel(model);
//        this.addItem("55");
        this.setBounds(posx, posy, 95, 30);
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, 16));
    }
}

class MyPanel extends JPanel{
    MyPanel(int posx, int posy){
        this.setBackground(Color.red);
        this.setBounds(posx, posy, 60, 180);
    }
}

