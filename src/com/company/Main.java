package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        String fileName = "NFS-Tools.jpg";
        File imageFile = new File(fileName);
        Histogram histogram = new Histogram(imageFile);
        histogram.generateHistogram();
        histogram.generateCumulativeTable(0.0002f);
        BufferedImage generatedImage = histogram.getGeneratedImage();
        ImageIO.write(generatedImage, "jpg", new File("out.jpg"));
    }
}
