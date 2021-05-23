package com.company;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JComponent;

public class JImageDisplay extends JComponent {
    private BufferedImage bImage;

    public JImageDisplay(int var1, int var2) {
        this.bImage = new BufferedImage(var1, var2, BufferedImage.TYPE_INT_RGB);
        super.setPreferredSize(new Dimension(var1, var2));
    }

    public void paintComponent(Graphics var1) {
        super.paintComponents(var1);
        var1.drawImage(this.bImage, 0, 0, this.bImage.getWidth(), this.bImage.getHeight(), (ImageObserver)null);
    }

    public void clearImage() {
        for(int var1 = 0; var1 < this.bImage.getWidth(); ++var1) {
            for(int var2 = 0; var2 < this.bImage.getHeight(); ++var2) {
                this.bImage.setRGB(var1, var2, 0);
            }
        }

    }

    public void drawPixel(int var1, int var2, int var3) {
        this.bImage.setRGB(var1, var2, var3);
    }
}
