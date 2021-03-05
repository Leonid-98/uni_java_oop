package Leonid;

public class Main {
    public static void main(String[] args){
        Resistor res1 = new Resistor("yellow", "yellow", "yellow");
        System.out.println(res1);
        res1.line1 = "brown";
        System.out.println(res1);
    }
}
