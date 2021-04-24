package Leonid;

import java.util.HashMap;


public class Resistor {
    protected final HashMap<String, Double> valuesRes = new HashMap<>() {{
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

    protected final HashMap<String, Double> multipliersRes = new HashMap<>() {{
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

    protected final HashMap<String, Double> tolerancesRes = new HashMap<>() {{
        put("silver", 10.0);
        put("gold", 5.0);
        put("brown", 1.0);
        put("red", 2.0);
        put("green", 0.5);
        put("blue", 0.25);
        put("violet", 0.1);
        put("gray", 0.05);
    }};
    private final double num1, num2, num3, multiplier, tolerance;

    protected Resistor(String line1, String line2, String line3) {
        num1 = 0.0;
        num2 = setValue(line1, valuesRes);
        num3 = setValue(line2, valuesRes);
        multiplier = setValue(line3, multipliersRes);
        tolerance = 0.0;
    }

    protected Resistor(String line1, String line2, String line3, String line4) {
        num1 = 0.0;
        num2 = setValue(line1, valuesRes);
        num3 = setValue(line2, valuesRes);
        multiplier = setValue(line3, multipliersRes);
        tolerance = setValue(line4, tolerancesRes);
    }

    protected Resistor(String line1, String line2, String line3, String line4, String line5) {
        num1 = setValue(line1, valuesRes);
        num2 = setValue(line2, valuesRes);
        num3 = setValue(line3, valuesRes);
        multiplier = setValue(line4, multipliersRes);
        tolerance = setValue(line5, tolerancesRes);
    }

    public double setValue(String key, HashMap<String, Double> dict) {
        if (!dict.containsKey(key))
            throw new NullPointerException("Use correct fields for values");
        return dict.get(key);
    }

    public double getResistance() {
        return (num1 * 100 + num2 * 10 + num3) * multiplier;
    }

    public double getTolerance() {
        return tolerance;
    }

    @Override
    public String toString() {
        if (tolerance != 0.0) {
            return getResistance() + " Oom +/- " + getTolerance() + " %";
        } else {
            return getResistance() + " Oom";
        }
    }
}
