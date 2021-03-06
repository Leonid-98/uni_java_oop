package Leonid;

import java.util.HashMap;

abstract class ResistorsConfig {
    public static final HashMap<String, Double> valuesRes = new HashMap<String, Double>() {{
        put("black", 0.0);
        put("brown", 1.0);
        put("red", 2.0);
        put("orange", 3.0);
        put("yellow", 4.0);
        put("green", 5.0);
        put("blue", 6.0);
        put("violet", 7.0);
        put("gray", 8.0);
        put("white", 9.0);
    }};

    public static final HashMap<String, Double> multipliersRes = new HashMap<String, Double>() {{
        put("silver", 0.01);
        put("gold", 0.1);
        put("black", 1.0);
        put("brown", 10.0);
        put("red", 100.0);
        put("orange", 1000.0);
        put("yellow", 10_000.0);
        put("green", 100_000.0);
        put("blue", 1_000_000.0);
        put("violet", 10_000_000.0);
        put("gray", 100_000_000.0);
        put("white", 1_000_000_000.0);
    }};

    public static final HashMap<String, Double> tolerancesRes = new HashMap<String, Double>() {{
        put("silver", 10.0);
        put("gold", 5.0);
        put("black", 1.0);
        put("brown", 2.0);
        put("green", 0.5);
        put("blue", 0.25);
        put("violet", 0.1);
        put("gray", 0.05);
    }};
}

class Resistor extends ResistorsConfig {
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
            resistance = (valuesRes.get(line1) * 10 + valuesRes.get(line2)) * multipliersRes.get(line3);
            return resistance;
        } else if (lines == 4) {
            resistance = (valuesRes.get(line1) * 10 + valuesRes.get(line2)) * multipliersRes.get(line3);
            return resistance;
        } else if (lines == 5) {
            resistance = (valuesRes.get(line1) * 100 + valuesRes.get(line2) * 10 + valuesRes.get(line3)) * multipliersRes.get(line4);
            return resistance;
        }
        return 0.0;
    }

    public String getTolerance() {
        String tolerance;
        if (lines == 4) {
            tolerance = "+/- " + tolerancesRes.get(line4) + "%";
            return tolerance;
        } else if (lines == 5) {
            tolerance = "+/- " + tolerancesRes.get(line5) + "%";
            return tolerance;
        }
        return "N/A";
    }

    @Override
    public String toString() {
        return getResistance() + " Ohm. Tolerance: " + getTolerance();
    }
}
