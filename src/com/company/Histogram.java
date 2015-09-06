package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Luthfi on 9/6/2015.
 */
public class Histogram {
    private BufferedImage image;
    private RgbFreq rgbFreq;
    private CumulativeTable cumulativeTable;


    public Histogram () {
        rgbFreq = new RgbFreq();
    }

    public Histogram (BufferedImage image) {
        this.image = image;
        rgbFreq = new RgbFreq();
    }

    public Histogram (File imageFile) throws IOException {
        this.image = ImageIO.read(imageFile);
        rgbFreq = new RgbFreq();
    }

    public void generateHistogram () {
        for (int y = 0;y < image.getHeight();y++)
        {
            for (int x = 0;x < image.getWidth();x++)
            {
                int rgb = image.getRGB(x,y);
                rgbFreq.addColor(rgb);
            }
        }
    }

    public void generateCumulativeTable (float parameter)
    {
        cumulativeTable = new CumulativeTable(parameter);
        cumulativeTable.generateTable(rgbFreq);
    }

    public BufferedImage getGeneratedImage ()
    {
        BufferedImage generatedImage = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB);
        for (int y = 0;y < image.getHeight();y++)
        {
            for (int x = 0;x < image.getWidth();x++)
            {
                Color color = cumulativeTable.getColorFromTable(image.getRGB(x,y));
                int rgb = color.getRGB();
                generatedImage.setRGB(x,y,rgb);
            }
        }
        return generatedImage;
    }
}
