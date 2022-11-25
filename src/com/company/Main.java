package com.company;

public class Main {
    public static void main(String[] args) {
        double step=1.5;
        double[] cordinates={1,5,0.3,7,0.5};
        MetodaSpadku method=new MetodaSpadku(cordinates, step);
        method.steps();
        method.printX();
    }
}
