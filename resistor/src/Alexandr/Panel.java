package Alexandr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Panel extends JPanel {
    private JButton fourRings = new JButton("4");
    private JButton fiveRings = new JButton("5");
    private JButton firststdigitalvalue[] = new JButton[12];
    private JButton seconddigitalvalue[] = new JButton[12];
    private JButton thirddigitalvalue[] = new JButton[12];
    private JButton decimalfactor[] = new JButton[12];
    private JButton tolerance[] = new JButton[12];
    private Color colors[] = new Color[12];
    private Font font = new Font("SanSerif", Font.BOLD,20);
    private Font font1 = new Font("SanSerif", Font.BOLD,70);
    private List<String> colornames = Arrays.asList("Hõbe","Kuld","Must","Pruun","Punane","Oranž","Kollane","Roheline","Sinine","Lilla","Hall","Valge");
    private ImageIO image;
    private Color firststdigitalvalueColor = Color.white;
    private Color seconddigitalvalueColor = Color.white;
    private Color thirdgitalvalueColor = Color.white;
    private Color decimalfactorColor = Color.white;
    private Color toleranceColor = Color.white;
    private String extraButton;
    private String fButton;
    private String sButton;
    private String result;
    private String fhButton;
    private String fdButton;
    private int width = 180;
    private String check = "4";

    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        for (int x = 0; x < 12; x++){ gr.setFont(font); gr.drawString(colornames.get(x),15,x * 37 + 427);}

        gr.setFont(font1);
        gr.drawString(result,280,100);
        gr.drawString(fhButton, 750, 100);

        gr.setColor(firststdigitalvalueColor);gr.fillRect(327, 170, 50, 200);
        gr.setColor(seconddigitalvalueColor);gr.fillRect(415, 170, 50, 200);
        gr.setColor(thirdgitalvalueColor);gr.fillRect(480, 170, 50, 200);
        gr.setColor(decimalfactorColor);gr.fillRect(550, 170, 50, 200);
        gr.setColor(toleranceColor);gr.fillRect(660, 170, 50, 200);
    }

    public Panel(){
        JLabel imgLabel = new JLabel(new ImageIcon("Six-Band-Resistor-Color-Code.png"));
        imgLabel.setBounds(150,70,800,400);
        add(imgLabel);

        setLayout(null);
        colors[0] = new Color(192,192,192); colors[1] = new Color(255,215,0);
        colors[2] = new Color(0,0,0); colors[3] = new Color(150,75,0);
        colors[4] = new Color(255,0,0); colors[5] = new Color(255,165,0);
        colors[6] = new Color(255,255,0); colors[7] = new Color(0,255,0);
        colors[8] = new Color(0,191,255); colors[9] = new Color(139,0,255);
        colors[10] = new Color(128,128,128); colors[11] = new Color(255,255,255);

        fourRings.setBounds(20,50,45,40);
        fiveRings.setBounds(70,50,45,40);
        add(fourRings);
        add(fiveRings);

        values(firststdigitalvalue, 215);
        values(seconddigitalvalue,410);
        values(thirddigitalvalue,-1000);
        decimalfactor(605);
        tolerance(800);

        appereance("fButton",2,12,firststdigitalvalue);
        appereance("sButton",2,12,seconddigitalvalue);
        appereance("extraButton",2,12,thirddigitalvalue);
        appereance("fdButton",0,12,decimalfactor);
        appereance("fhButton",0,2, tolerance);


        result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton), fdButton);

        ActionListener firstL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            firststdigitalvalueColor = b.getBackground();
            fButton = b.getText();
            if (check.equals("4")) {
                System.out.println("e");
                result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton), fdButton);
            } else {
                result = check(Double.valueOf(fButton) * 100 + Double.valueOf(sButton) * 10 + Double.valueOf(extraButton), fdButton);
            }
            repaint();
        };

        ActionListener secondL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            seconddigitalvalueColor = b.getBackground();
            sButton = b.getText();
            if (check.equals("4")) {
                System.out.println("e");
                result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton), fdButton);
            } else {
                result = check(Double.valueOf(fButton) * 100 + Double.valueOf(sButton) * 10 + Double.valueOf(extraButton), fdButton);
            }
            repaint();
        };

        ActionListener thirdL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            thirdgitalvalueColor = b.getBackground();
            extraButton = b.getText();
            if (check.equals("4")) {
                System.out.println("e");
                result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton), fdButton);
            } else {
                result = check(Double.valueOf(fButton) * 100 + Double.valueOf(sButton) * 10 + Double.valueOf(extraButton), fdButton);
            }
            repaint();
        };

        ActionListener firdL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            decimalfactorColor = b.getBackground();
            fdButton = b.getText();
            if (check.equals("4")) {
                System.out.println("e");
                result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton), fdButton);
            } else {
                result = check(Double.valueOf(fButton) * 100 + Double.valueOf(sButton) * 10 + Double.valueOf(extraButton), fdButton);
            }
            repaint();
        };

        ActionListener fourthL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            toleranceColor = b.getBackground();
            fhButton = b.getText();
            repaint();
        };

        ActionListener switch4 = (ActionEvent e) -> {
            check = "4";
            thirdgitalvalueColor = Color.white;
            JButton b = (JButton)e.getSource();
            width = 180;
            for (int i = 0; i < firststdigitalvalue.length; i++){
                remove(firststdigitalvalue[i]);
                remove(seconddigitalvalue[i]);
                remove(decimalfactor[i]);
                remove(thirddigitalvalue[i]);
                remove(tolerance[i]);
            }

            values(firststdigitalvalue, 215);
            values(seconddigitalvalue,410);
            decimalfactor(605);
            tolerance(800);

            for (JButton d: firststdigitalvalue) { d.addActionListener(firstL); }
            for (JButton d: seconddigitalvalue) { d.addActionListener(secondL); }
            for (JButton d: thirddigitalvalue) { d.addActionListener(firdL); }
            for (JButton d: decimalfactor) { d.addActionListener(firdL); }
            for (JButton d: tolerance) { d.addActionListener(fourthL); }
            repaint();
        };

        ActionListener switch5 = (ActionEvent e) -> {
            check = "5";
            JButton b = (JButton)e.getSource();
            width = 120;
            for (int i = 0; i < firststdigitalvalue.length; i++){
                remove(firststdigitalvalue[i]);
                remove(seconddigitalvalue[i]);
                remove(decimalfactor[i]);
                remove(tolerance[i]);
            }
            values(firststdigitalvalue, 200);
            values(seconddigitalvalue,340);
            values(thirddigitalvalue, 480);
            decimalfactor(620);
            tolerance(760);

            for (JButton d: firststdigitalvalue) { d.addActionListener(firstL); }
            for (JButton d: seconddigitalvalue) { d.addActionListener(secondL); }
            for (JButton d: thirddigitalvalue) { d.addActionListener(thirdL); }
            for (JButton d: decimalfactor) { d.addActionListener(firdL); }
            for (JButton d: tolerance) { d.addActionListener(fourthL); }
            repaint();
        };

        for (JButton b: firststdigitalvalue) { b.addActionListener(firstL); }
        for (JButton b: seconddigitalvalue) { b.addActionListener(secondL); }
        for (JButton b: thirddigitalvalue) { b.addActionListener(thirdL); }
        for (JButton b: decimalfactor) { b.addActionListener(firdL); }
        for (JButton b: tolerance) { b.addActionListener(fourthL); }
        fourRings.addActionListener(switch4);
        fiveRings.addActionListener(switch5);
    }

    public String check(double value, String decimalfactor){
        double x = value;
        String om = "";

        if (decimalfactor.equals("÷100")){ x = x / 100;om = "Om"; } else if (decimalfactor.equals("÷10")){ x = x / 10;om = "Om";
        } else if (decimalfactor.equals("x1")) { x = x;om = "Om"; } else  if (decimalfactor.equals("x10")) { x = x * 10;om = "Om";
        } else if (decimalfactor.equals("x100")) { x = x / 10;om = "kOm"; } else if (decimalfactor.equals("x1K")) { x = x;om = "kOm";
        } else if (decimalfactor.equals("x10K")) { x = x * 10;om = "kOm"; } else if (decimalfactor.equals("x100K")) { x = x / 10;om = "MOm";
        } else if (decimalfactor.equals("x1M")) { x = x;om = "MOm"; } else if (decimalfactor.equals("x10M")) { x = x * 10;om = "MOm";
        } else if (decimalfactor.equals("x100M")) { x = x / 10;om = "GOm"; } else if (decimalfactor.equals("x1G")) { x = x;om = "GOm"; }

        return String.valueOf(x) + " " + om;
    }

    public void appereance(String buttonString,int origin, int bounds, JButton[] list){
        int randomNumber = ThreadLocalRandom.current().nextInt(origin, bounds);
        if (buttonString.equals("fButton")) {
            fButton = list[randomNumber].getText();
            firststdigitalvalueColor = list[randomNumber].getBackground();
        } else if (buttonString.equals("sButton")){
            sButton = list[randomNumber].getText();
            seconddigitalvalueColor = list[randomNumber].getBackground();
        } else if (buttonString.equals("fdButton")){
            fdButton = list[randomNumber].getText();
            decimalfactorColor = list[randomNumber].getBackground();
        } else  if (buttonString.equals("fhButton")) {
            fhButton = list[randomNumber].getText();
            toleranceColor = list[randomNumber].getBackground();
        } else if (buttonString.equals("extraButton")) {
            extraButton = list[2].getText();
            toleranceColor = list[2].getBackground();
        }
    }

    public void values(JButton[] jButtons, int xValue){
        for (int x = 0; x < 12; x++){
            jButtons[x] = new JButton((x-2) + "");
            if (x < 2) {
                jButtons[x] = new JButton( "-");
                jButtons[x].setEnabled(false);
            }
            jButtons[x].setBounds(xValue,x * 37 + 407,width,35);
            jButtons[x].setFont(font);
            jButtons[x].setBackground(colors[x]);
            if (x == 0 || x == 1) {
                jButtons[x].setBackground(colors[11]);
            }
            add(jButtons[x]);
        }
    }

    public void decimalfactor(int xValue){
        for (int x = 0; x < 12; x++){
            if (x == 0) { decimalfactor[x] = new JButton("÷100");}
            else if (x == 1) { decimalfactor[x] = new JButton("÷10"); }
            else if (x == 2) { decimalfactor[x] = new JButton("x1"); }
            else if (x == 3) { decimalfactor[x] = new JButton("x10"); }
            else if (x == 4) { decimalfactor[x] = new JButton("x100"); }
            else if (x == 5) { decimalfactor[x] = new JButton("x1K"); }
            else if (x == 6) { decimalfactor[x] = new JButton("x10K"); }
            else if (x == 7) { decimalfactor[x] = new JButton("x100K"); }
            else if (x == 8) { decimalfactor[x] = new JButton("x1M"); }
            else if (x == 9) { decimalfactor[x] = new JButton("x10M"); }
            else if (x == 10) { decimalfactor[x] = new JButton("x100M"); }
            else if (x == 11) { decimalfactor[x] = new JButton("x1G"); }
            decimalfactor[x].setBounds(xValue,x *37 + 407,width,35);
            decimalfactor[x].setFont(font);
            decimalfactor[x].setBackground(colors[x]);
            add(decimalfactor[x]);
        }
    }

    public void tolerance(int xValue){
        for (int x = 0; x < 12; x++){
            if (x == 0) { tolerance[x] = new JButton("±10%");}
            else if (x == 1) { tolerance[x] = new JButton("±5%");}
            else if (x == 2) { tolerance[x] = new JButton("-");tolerance[x].setEnabled(false);}
            else if (x == 3) { tolerance[x] = new JButton("±1%");}
            else if (x == 4) { tolerance[x] = new JButton("±2%");}
            else if (x == 5) { tolerance[x] = new JButton("-");tolerance[x].setEnabled(false);}
            else if (x == 6) { tolerance[x] = new JButton("-");tolerance[x].setEnabled(false);}
            else if (x == 7) { tolerance[x] = new JButton("±0.5%");}
            else if (x == 8) { tolerance[x] = new JButton("±0.25%");}
            else if (x == 9) { tolerance[x] = new JButton("±0.10%");}
            else if (x == 10) { tolerance[x] = new JButton("±0.05%");}
            else if (x == 11) { tolerance[x] = new JButton("-"); tolerance[x].setBackground(Color.white); tolerance[x].setEnabled(false);}

            tolerance[x].setBounds(xValue,x *37 + 407,width,35);
            tolerance[x].setFont(font);
            tolerance[x].setBackground(colors[x]);
            if (x == 2 || x == 5 || x == 6 || x == 11) {
                tolerance[x].setBackground(colors[11]);
            }
            add(tolerance[x]);
        }
    }
}
