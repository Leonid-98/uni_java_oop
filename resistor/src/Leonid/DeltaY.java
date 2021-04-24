package Leonid;

public class DeltaY {
    private double sum;
    private double r12, r23, r31;

    public DeltaY(double r1, double r2, double r3) {
        sum = r1 + r2 + r3;
        r12 = (r1 * r2) / sum;
        r23 = (r2 * r3) / sum;
        r31 = (r3 * r1) / sum;
    }

    public double getR12() {
        return round(r12);
    }

    public double getR23() {
        return round(r23);
    }

    public double getR31() {
        return round(r31);
    }

    public double round(double val) {
        val = val * 1000;
        val = Math.round(val);
        return val / 1000;
    }
}
