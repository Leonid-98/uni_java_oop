package Leonid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    JButton button;
    MyFrame() {
        this.setTitle("title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640, 400);
        this.getContentPane().setBackground(new Color(0xEDFBC1));
//        ImageIcon image = new ImageIcon("Six-Band-Resistor-Color-Code.png");
//        this.setIconImage(image.getImage());

        button = new JButton("REFRESH");
        button.setBackground(new Color(0xFAFFA9));
        button.setFont(new Font("Rubik", Font.PLAIN, 20));
        button.setBounds(450, 290, 127, 40);
        button.addActionListener(this);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("poo");
        }
    }
}

class MyLabel extends JLabel{
    MyLabel(){
        ;
    }
}


