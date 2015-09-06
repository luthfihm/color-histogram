package com.company;

import java.awt.*;

/**
 * Created by Luthfi on 9/6/2015.
 */
public class CumulativeTable {
    int[] red;
    int[] green;
    int[] blue;
    float parameter;

    public CumulativeTable(float parameter) {
        red = new int[256];
        green = new int[256];
        blue = new int[256];
        this.parameter = parameter;
    }

    public void generateTable (RgbFreq rgbFreq) {
        generateRedTable(rgbFreq.getRedFreq());
        generateGreenTable(rgbFreq.getGreenFreq());
        generateBlueTable(rgbFreq.getBlueFreq());
    }

    public Color getColorFromTable (int rgb) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = (rgb >> 0) & 0xff;

        Color color = new Color(r,g,b);

        return color;
    }

    public Color getColorFromTable (int r,int g,int b) {
        Color color = new Color(r,g,b);

        return color;
    }

    private void generateRedTable (int[] redFreq) {
        int series = 0;
        int size = redFreq.length;
        for (int i = 0;i < size;i++) {
            float f = redFreq[i] * parameter;
            series += Math.round(f);
            red[i] = series;
        }
        if (red[255] > 255) {
            for (int i = 0;i < size;i++) {
                red[i] = (red[i] * 255) / series;
            }
        }
    }

    private void generateGreenTable (int[] greenFreq) {
        int series = 0;
        int size = greenFreq.length;
        for (int i = 0;i < size;i++) {
            float f = greenFreq[i] * parameter;
            series += Math.round(f);
            green[i] = series;
        }
        if (green[255] > 255) {
            for (int i = 0;i < size;i++) {
                green[i] = (green[i] * 255) / series;
            }
        }
    }

    private void generateBlueTable (int[] blueFreq) {
        int series = 0;
        int size = blueFreq.length;
        for (int i = 0;i < size;i++) {
            float f = blueFreq[i] * parameter;
            series += Math.round(f);
            blue[i] = series;
        }
        if (blue[255] > 255) {
            for (int i = 0;i < size;i++) {
                blue[i] = (blue[i] * 255) / series;
            }
        }
    }
}
