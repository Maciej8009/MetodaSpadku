package com.company;

import java.util.NoSuchElementException;

public class MetodaSpadku {
    double[] x0;
    double[] x;
    double[] y;
    double vector;
    double f1;
    double f2;
    double temp;
    double tempVector;

    public MetodaSpadku(double[] x0, double vector) {
        this.x0=x0;
        this.x=x0;
        this.y=x0;
        this.vector=vector;
    }

    private double polymian(double[] x0) {
        return (Math.pow(x0[0], 5) + Math.sqrt(x0[1])*Math.sin(x0[2])-Math.pow(x0[3], 2)-x0[4]);
    }
    public void steps() {
        int licznik=0;
        while (licznik<1000) {
            System.arraycopy(x0, 0, y, 0,x0.length);
            for (int i = 0; i < x0.length; i++) {
                temp = x[i];
                tempVector = vector;
                System.arraycopy(x0, 0, y, 0, x0.length);
                f1 = polymian(x0);
                x[i] += vector;
                f2 = polymian(x);
                if (f1 < f2) {
                    vector *= (-1);
                    x[i] = temp;
                    x[i] += vector;
                    f2 = polymian(x);

                    if (f1 < f2) {
                        vector = tempVector;

                    } else {
                        System.arraycopy(x, 0, x0, 0, x.length);
                    }
                } else {
                    System.arraycopy(x, 0, x0, 0, x.length);

                }
                System.arraycopy(x0, 0, x, 0, x0.length);
                vector = tempVector;
            }
            licznik++;
        }
    }

    public void printX() {
        System.out.println("optymalne wartosci \n");
        for (int i=0; i<x0.length; i++) {
            System.out.print(+x0[i]+" ");
        }
        System.out.println("\n");
    }
}

