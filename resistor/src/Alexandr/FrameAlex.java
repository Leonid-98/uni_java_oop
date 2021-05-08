package Alexandr;

import javax.swing.*;

public class FrameAlex extends JFrame {

    public FrameAlex(){
        this.setTitle("Calculator");
        this.setSize(1015, 900);
        this.add(new PanelAlex());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
