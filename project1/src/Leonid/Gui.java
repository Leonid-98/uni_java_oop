package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

class MyFrame extends MyFrameConfig implements ActionListener {
    JButton button;
    JComboBox combobox1, combobox2, combobox3, combobox4, combobox5;
    JLabel textLabel;
    MyFrame() {
        button = new MyButton(450, 290);
        button.addActionListener(this);
        // button.addActionListener(e -> System.out.println("poo")); // без интерфейса
        this.add(button);

        String[] test = {"BLACK", "BROWN", "VIOLET", "YELLOW"};

        combobox1 = new MyComboBox();
        combobox1.addActionListener(this);
        this.add(combobox1);

        combobox2 = new JComboBox(test);
        combobox2.setBounds(170, 230, 95, 30);
        combobox2.setBackground(new Color(0xFAFFA9));
        combobox2.setFont(new Font("Rubik", Font.PLAIN, 16));
        combobox2.addActionListener(this);
        this.add(combobox2);

        combobox3 = new JComboBox(test);
        combobox3.setBounds(270, 230, 95, 30);
        combobox3.setBackground(new Color(0xFAFFA9));
        combobox3.setFont(new Font("Rubik", Font.PLAIN, 16));
        combobox3.addActionListener(this);
        this.add(combobox3);

        combobox4 = new JComboBox(test);
        combobox4.setBounds(370, 230, 95, 30);
        combobox4.setBackground(new Color(0xFAFFA9));
        combobox4.setFont(new Font("Rubik", Font.PLAIN, 16));
        combobox4.addActionListener(this);
        this.add(combobox4);

        combobox5 = new JComboBox(test);
        combobox5.setBounds(470, 230, 95, 30);
        combobox5.setBackground(new Color(0xFAFFA9));
        combobox5.setFont(new Font("Rubik", Font.PLAIN, 16));
        combobox5.addActionListener(this);
        this.add(combobox5);


        JLabel label = new MyLabel();
        this.add(label);

        this.setLayout(null);


        textLabel = new JLabel();
        textLabel.setText("10_000_TEST_000 Ohm +/- N/A");
        textLabel.setForeground(Color.black);
        textLabel.setFont(new Font("Rubik", Font.PLAIN, 24));
        textLabel.setBounds(25, 290 , 500, 40);
        this.add(textLabel);


        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setBounds(80, 25, 60, 180);
        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setBounds(168, 25, 60, 180);
        this.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.setBounds(238, 25, 60, 180);
        this.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.black);
        panel4.setBounds(302, 25, 60, 180);
        this.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.MAGENTA);
        panel5.setBounds(418, 25, 60, 180);
        this.add(panel5);

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

class MyLabel extends JLabel{
    MyLabel(){
        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
        this.setIcon(image);
        this.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT< RIGHT < CNTER
        this.setVerticalTextPosition(JLabel.BOTTOM); // top, cent, bottom
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(15, 15 , 594, 350);
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
    MyComboBox(){
//        String[] test = {"BLACK", "BROWN", "VIOLET", "YELLOW"};
//        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(test);
//        this.setModel(model);
        this.addItem("55");
        this.setBounds(70, 230, 95, 30);
        this.setBackground(new Color(0xFAFFA9));
        this.setFont(new Font("Rubik", Font.PLAIN, 16));
    }
}

