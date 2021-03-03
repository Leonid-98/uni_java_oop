import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Panel extends JPanel {

    private JButton firststdigitalvalue[] = new JButton[12];
    private JButton seconddigitalvalue[] = new JButton[12];
    private JButton decimalfactor[] = new JButton[12];
    private JButton tolerance[] = new JButton[12];
    private Color colors[] = new Color[12];
    private Font font = new Font("SanSerif", Font.BOLD,20);
    private List<String> colornames = Arrays.asList("Hõbe","Kuld","Must","Pruun","Punane","Oranž","Kollane","Roheline","Sinine","Lilla","Hall","Valge");

    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        for (int x = 0; x < 12; x++){ gr.setFont(font); gr.drawString(colornames.get(x),15,x * 50 + 285);}
    }

    public Panel(){
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
            firststdigitalvalue[x].setBounds(215,x * 50 + 257,180,40);
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
            seconddigitalvalue[x].setBounds(410,x * 50 + 257,180,40);
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
            decimalfactor[x].setBounds(605,x * 50 + 257,180,40);
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

            tolerance[x].setBounds(800,x * 50 + 257,180,40);
            tolerance[x].setFont(font);
            tolerance[x].setBackground(colors[x]);
            if (x == 2 || x == 5 || x == 6 || x == 11) {
                tolerance[x].setBackground(colors[11]);
            }
            add(tolerance[x]);
        }
    }
}
