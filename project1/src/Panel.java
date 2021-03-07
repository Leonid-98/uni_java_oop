import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class Panel extends JPanel {
    private JButton firststdigitalvalue[] = new JButton[12];
    private JButton seconddigitalvalue[] = new JButton[12];
    private JButton decimalfactor[] = new JButton[12];
    private JButton tolerance[] = new JButton[12];
    private Color colors[] = new Color[12];
    private Font font = new Font("SanSerif", Font.BOLD,20);
    private Font font1 = new Font("SanSerif", Font.BOLD,70);
    private List<String> colornames = Arrays.asList("Hõbe","Kuld","Must","Pruun","Punane","Oranž","Kollane","Roheline","Sinine","Lilla","Hall","Valge");
    private ImageIO image;
    private Color firststdigitalvalueColor = Color.white;
    private Color seconddigitalvalueColor = Color.white;
    private Color decimalfactorColor = Color.white;
    private Color toleranceColor = Color.white;
    private String fButton;
    private String sButton;
    private String result;
    private String fhButton;
    private String fdButton;

    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        for (int x = 0; x < 12; x++){ gr.setFont(font); gr.drawString(colornames.get(x),15,x * 37 + 427);}

        gr.setFont(font1);
        gr.drawString(result,280,100);
        gr.drawString(fhButton, 650, 100);

        gr.setColor(firststdigitalvalueColor);gr.fillRect(327, 170, 50, 200);
        gr.setColor(seconddigitalvalueColor);gr.fillRect(415, 170, 50, 200);
        gr.setColor(decimalfactorColor);gr.fillRect(550, 170, 50, 200);
        gr.setColor(toleranceColor);gr.fillRect(660, 170, 50, 200);
    }

    public Panel(){
        JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\Aleksandr_Viktoriya\\Desktop\\OOP_2021\\project1\\Six-Band-Resistor-Color-Code.png"));
        imgLabel.setBounds(150,70,800,400);
        add(imgLabel);

        setLayout(null);
        colors[0] = new Color(192,192,192); colors[1] = new Color(255,215,0);
        colors[2] = new Color(0,0,0); colors[3] = new Color(150,75,0);
        colors[4] = new Color(255,0,0); colors[5] = new Color(255,165,0);
        colors[6] = new Color(255,255,0); colors[7] = new Color(0,255,0);
        colors[8] = new Color(0,191,255); colors[9] = new Color(139,0,255);
        colors[10] = new Color(128,128,128); colors[11] = new Color(255,255,255);

        for (int x = 0; x < 12; x++){
            firststdigitalvalue[x] = new JButton((x-2) + "");
            if (x < 2) {
                firststdigitalvalue[x] = new JButton( "-");
                firststdigitalvalue[x].setEnabled(false);
            }
            firststdigitalvalue[x].setBounds(215,x *37 + 407,180,35);
            firststdigitalvalue[x].setFont(font);
            firststdigitalvalue[x].setBackground(colors[x]);
            if (x == 0 || x == 1) {
                firststdigitalvalue[x].setBackground(colors[11]);
            }
            add(firststdigitalvalue[x]);
        }

        for (int x = 0; x < 12; x++){
            seconddigitalvalue[x] = new JButton((x-2) + "");
            if (x < 2) {
                seconddigitalvalue[x] = new JButton( "-");
                seconddigitalvalue[x].setEnabled(false);
                seconddigitalvalue[x].setBackground(colors[11]);
            }
            seconddigitalvalue[x].setBounds(410,x *37 + 407,180,35);
            seconddigitalvalue[x].setFont(font);
            seconddigitalvalue[x].setBackground(colors[x]);
            if (x == 0 || x == 1) {
                seconddigitalvalue[x].setBackground(colors[11]);
            }
            add(seconddigitalvalue[x]);
        }

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
            decimalfactor[x].setBounds(605,x *37 + 407,180,35);
            decimalfactor[x].setFont(font);
            decimalfactor[x].setBackground(colors[x]);
            add(decimalfactor[x]);
        }

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

            tolerance[x].setBounds(800,x *37 + 407,180,35);
            tolerance[x].setFont(font);
            tolerance[x].setBackground(colors[x]);
            if (x == 2 || x == 5 || x == 6 || x == 11) {
                tolerance[x].setBackground(colors[11]);
            }
            add(tolerance[x]);
        }

        appereance("fButton",2,12,firststdigitalvalue);
        appereance("sButton",2,12,seconddigitalvalue);
        appereance("fdButton",0,12,decimalfactor);
        appereance("fhButton",0,2, tolerance);

        result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton),fdButton);

        ActionListener firstL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            firststdigitalvalueColor = b.getBackground();
            fButton = b.getText();
            result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton),fdButton);
            repaint();
        };

        ActionListener secondL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            seconddigitalvalueColor = b.getBackground();
            sButton = b.getText();
            result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton),fdButton);
            repaint();
        };

        ActionListener firdL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            decimalfactorColor = b.getBackground();
            fdButton = b.getText();
            result = check(Double.valueOf(fButton) * 10 + Double.valueOf(sButton),fdButton);
            repaint();
        };

        ActionListener fourthL = (ActionEvent e) -> {
            JButton b = (JButton)e.getSource();
            toleranceColor = b.getBackground();
            fhButton = b.getText();
            repaint();
        };

        for (JButton b: firststdigitalvalue) { b.addActionListener(firstL); }
        for (JButton b: seconddigitalvalue) { b.addActionListener(secondL); }
        for (JButton b: decimalfactor) { b.addActionListener(firdL); }
        for (JButton b: tolerance) { b.addActionListener(fourthL); }
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
        }
    }
}
