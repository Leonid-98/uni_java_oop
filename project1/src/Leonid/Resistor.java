package Leonid;

public class Resistor extends ResistorsConfig {
    protected String line1, line2, line3, line4, line5;
    private final int lines;

    public Resistor(String line1, String line2, String line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.lines = 3;
    }

    public Resistor(String line1, String line2, String line3, String line4) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.lines = 4;
    }

    public Resistor(String line1, String line2, String line3, String line4, String line5, String... args) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.line5 = line5;
        this.lines = 5;
    }

    public double getResistance() {
        double resistance;
        if (lines == 3) {
            resistance = (values.get(line1) * 10 + values.get(line2)) * multipliers.get(line3);
            return resistance;
        } else if (lines == 4) {
            resistance = (values.get(line1) * 10 + values.get(line2)) * multipliers.get(line3);
            return resistance;
        } else if (lines == 5) {
            resistance = (values.get(line1) * 100 + values.get(line2) * 10 + values.get(line3)) * multipliers.get(line4);
            return resistance;
        }
        return 0.0;
    }

    public String getTolerance() {
        String tolerance;
        if (lines == 4) {
            tolerance = "+/- " + tolerances.get(line4) + "%";
            return tolerance;
        } else if (lines == 5) {
            tolerance = "+/- " + tolerances.get(line5) + "%";
            return tolerance;
        }
        return "N/A";
    }

    @Override
    public String toString() {
        return getResistance() + " Ohm. Tolerance: " + getTolerance();
    }
}