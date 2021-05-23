package com.company;

import java.awt.geom.Rectangle2D.Double;

public abstract class FractalGenerator {
    public FractalGenerator() {
    }

    public static double getCoord(double var0, double var2, int var4, int var5) {
        assert var4 > 0;

        assert var5 >= 0 && var5 < var4;

        double var6 = var2 - var0;
        return var0 + var6 * (double)var5 / (double)var4;
    }

    public abstract void getInitialRange(Double var1);

    public void recenterAndZoomRange(Double var1, double var2, double var4, double var6) {
        double var8 = var1.width * var6;
        double var10 = var1.height * var6;
        var1.x = var2 - var8 / 2.0;
        var1.y = var4 - var10 / 2.0;
        var1.width = var8;
        var1.height = var10;
    }

    public abstract int numIterations(double var1, double var3);
}
