package com.company;


import java.awt.geom.Rectangle2D.Double;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    public Mandelbrot() {
    }

    public void getInitialRange(Double var1) {
        var1.x = -2.0;
        var1.y = -1.5;
        var1.width = 3.0;
        var1.height = 3.0;
    }

    public int numIterations(double var1, double var3) {
        int i = 0;
        double re = 0;
        double im = 0;

        while ((i < MAX_ITERATIONS) && ((re * re + im * im) < 4)) {
            double rp = re * re - im * im + var1;
            double ip = 2 * re * im + var3;
            re = rp;
            im = ip;
            i += 1;
        }
        if (i == MAX_ITERATIONS)
            return -1;
        else
            return i;
    }
}
