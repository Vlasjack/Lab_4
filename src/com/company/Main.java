package com.company;

public class Main {
    private double x;
    private double iy;

    Main() {
        this.x = 0.0D;
        this.iy = 0.0D;
    }

    Main(double var1, double var3) {
        this.x = var1;
        this.iy = var3;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.iy;
    }

    public void Squaring() {
        double var1 = this.x * this.x - this.iy * this.iy;
        this.iy = 2.0D * this.x * this.iy;
        this.x = var1;
    }

    public double SquarModul() {
        return this.x * this.x + this.iy * this.iy;
    }

    public void AddComlp(Main var1) {
        this.x += var1.getX();
        this.iy += var1.getY();
    }
}
