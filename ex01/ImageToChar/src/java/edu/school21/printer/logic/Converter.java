package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Converter {

    private final char s1;
    private final char s2;
    private char[][] array;

    private final String pathToImg;
    private int arrHeight;
    private int arrWidth;

    public Converter(String fileName, char s1, char s2) {
        this.pathToImg = "/resources/" + fileName;
        this.s1 = s1;
        this.s2 = s2;
    }

    public void convertImage() {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(Converter.class.getResource(pathToImg)));

            arrWidth = image.getWidth();
            arrHeight = image.getHeight();

            array = new char[arrHeight][arrWidth];

            for (int y = 0; y < arrHeight; ++y) {
                for (int x = 0; x < arrWidth; ++x) {
                    int color = image.getRGB(x, y);

                    if (color == Color.BLACK.getRGB()) {
                        array[y][x] = s1;
                    } else if (color == Color.WHITE.getRGB()) {
                        array[y][x] = s2;
                    } else {
                        System.out.println("Image is not black and while");
                        System.exit(1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Problem with image");
            System.exit(1);
        }
    }

    public char[][] getArray() {
        return array;
    }

    public void printImage() {
        for (int y = 0; y < arrHeight; ++y) {
            for (int x = 0; x < arrWidth; ++x) {
                System.out.print(array[y][x]);
            }
            System.out.println();
        }
    }


}
