package Leonid;

import java.util.*;

public abstract class ResistorsConfig {
    public static final HashMap<String, Double> value = new HashMap<String, Double>() {{
        put("black", 0.0);
        put("brown", 1.0);
        put("red", 2.0);
        put("orange", 3.0);
        put("yellow", 4.0);
        put("green", 5.0);
        put("blue", 6.0);
        put("violet", 7.0);
        put("grey", 8.0);
        put("white", 9.0);
    }};

    public static final HashMap<String, Double> multiplier = new HashMap<String, Double>() {{
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
    }};

    public static final HashMap<String, Double> tolerance = new HashMap<String, Double>() {{
        put("silver", 10.0);
        put("brown", 5.0);
        put("red", 1.0);
        put("green", 0.5);
        put("blue", 0.25);
        put("violet", 0.1);
    }};

    public static final HashMap<String, Double> tempConst = new HashMap<String, Double>() {{
        put("black", 200.0);
        put("brown", 100.0);
        put("red", 50.0);
        put("orange", 15.0);
        put("yellow", 25.0);
        put("blue", 10.0);
        put("violet", 5.0);
        put("gray", 1.0);
    }};
}


/*
https://stackoverflow.com/questions/8261075/adding-multiple-entries-to-a-hashmap-at-once-in-one-statement
 */
