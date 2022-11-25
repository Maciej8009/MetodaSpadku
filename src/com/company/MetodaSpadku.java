package com.company;

import java.util.NoSuchElementException;

public class MetodaSpadku {
    double[] x0;
    double[] x;
    double[] y;
    double vector;
    double f1;
    double f2;
    double f3;
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
        y[0]+=1;
        while ((x0!=y)||(licznik<50)) {
            for (int i = 0; i < x0.length; i++) {
//            System.out.println("przed vectorem");
//            printX(x);
                temp = x[i];
                tempVector = vector;
                System.arraycopy(x0, 0, y, 0, x0.length);
                f1 = polymian(x0);
                x[i] += vector;
                f2 = polymian(x);
//            System.out.println("po vectorze");
//            printX(x);
                if (f1 < f2) {
                    vector *= (-1);
                    x[i] = temp;
                    x[i] += vector;
                    f2 = polymian(x);
//                System.out.println("Krok nie jest lepszy1");
//                printX(x);
                    if (f1 < f2) {
                        vector = tempVector;
//                    System.out.println("Krok nie jest lepszy2");
//                    printX(x);
                    } else {
                        System.arraycopy(x, 0, x0, 0, x.length);
//                    System.out.println("Krok jest lepszy1");
//                    printX(x);
                    }
                } else {
                    System.arraycopy(x, 0, x0, 0, x.length);
//                System.out.println("Krok jest lepszy2");
//                printX(x);
                }
                System.arraycopy(x0, 0, x, 0, x0.length);
                vector = tempVector;
                licznik++;
//            System.out.println("X0 po iteracji pętli "+(int)(i+1));
//            printX(x0);
            }
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

