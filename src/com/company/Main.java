package com.company;

public class Main {
    public static void main(String[] args) {
        double step=1.5;
        double[] cordinates={1,-3,0.5,-4,8};
        MetodaSpadku method=new MetodaSpadku(cordinates, step);
        method.steps();
        method.printX();
    }
}
