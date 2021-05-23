package com.company;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FractalExplorer extends JFrame {
    private int size;
    private JImageDisplay image;
    private FractalGenerator fg;
    private Double range;

    public FractalExplorer(int var1) {
        this.size = var1;
        this.image = new JImageDisplay(var1, var1);
        this.fg = new Mandelbrot();
        this.range = new Double();
        this.fg.getInitialRange(this.range);
    }

    private void createAndShowGUI() {
        this.setTitle("Fractal Explorer");
        this.setSize(this.size, this.size);
        this.setDefaultCloseOperation(3);
        this.add(this.image);
        JButton var1 = new JButton("Reset Display");
        this.add(var1, "South");
        var1.addActionListener(new FractalExplorer.ButtonEventListener());
        this.image.addMouseListener(new FractalExplorer.MouseEventListener());
        this.setVisible(true);
        this.setResizable(false);
    }

    private void drawFractal() {
        for(int var1 = 0; var1 < this.size; ++var1) {
            for(int var2 = 0; var2 < this.size; ++var2) {
                double var3 = FractalGenerator.getCoord(this.range.x, this.range.x + this.range.width, this.size, var1);
                double var5 = FractalGenerator.getCoord(this.range.y, this.range.y + this.range.height, this.size, var2);
                int var7 = this.fg.numIterations(var3, var5);
                int rgbColor;
                if (var7 == -1) {
                    this.image.drawPixel(var1, var2, 0);
                    rgbColor = Color.HSBtoRGB(0, 0, 0);
                }
                else {
                    float hue = 0.7f + (float) var7 / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }
                this.image.drawPixel(var1, var2,rgbColor);
            }
        }

        this.image.repaint();
    }

    public static void main(String[] var0) {
        FractalExplorer var1 = new FractalExplorer(800);
        var1.createAndShowGUI();
        var1.drawFractal();
        var1.repaint();
    }

    class MouseEventListener implements MouseListener {
        MouseEventListener() {
        }

        public void mouseClicked(MouseEvent var1) {
            int var2 = var1.getX();
            int var3 = var1.getY();
            double var4 = FractalGenerator.getCoord(FractalExplorer.this.range.x, FractalExplorer.this.range.x + FractalExplorer.this.range.width, FractalExplorer.this.size, var2);
            double var6 = FractalGenerator.getCoord(FractalExplorer.this.range.y, FractalExplorer.this.range.y + FractalExplorer.this.range.width, FractalExplorer.this.size, var3);
            FractalExplorer.this.fg.recenterAndZoomRange(FractalExplorer.this.range, var4, var6, 0.5D);
            FractalExplorer.this.drawFractal();
        }

        public void mouseEntered(MouseEvent var1) {
        }

        public void mouseExited(MouseEvent var1) {
        }

        public void mousePressed(MouseEvent var1) {
        }

        public void mouseReleased(MouseEvent var1) {
        }
    }

    class ButtonEventListener implements ActionListener {
        ButtonEventListener() {
        }

        public void actionPerformed(ActionEvent var1) {
            FractalExplorer.this.fg.getInitialRange(FractalExplorer.this.range);
            FractalExplorer.this.image.clearImage();
            FractalExplorer.this.drawFractal();
        }
    }
}
