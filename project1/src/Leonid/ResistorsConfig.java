/*
IEC 60062
https://www.electronicshub.org/resistor-color-code/
https://stackoverflow.com/questions/8261075/adding-multiple-entries-to-a-hashmap-at-once-in-one-statement
 */

package Leonid;
import java.util.*;

public abstract class ResistorsConfig {
    public static final HashMap<String, Double> values = new HashMap<String, Double>() {{
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

    public static final HashMap<String, Double> multipliers = new HashMap<String, Double>() {{
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

    public static final HashMap<String, Double> tolerances = new HashMap<String, Double>() {{
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
