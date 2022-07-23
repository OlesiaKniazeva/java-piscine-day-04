package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class Converter {

    private final String white;
    private final String black;
    private int[][] array;

    private final String pathToImg;
    private int arrHeight;
    private int arrWidth;

    public Converter(String fileName, String black, String white) {
        this.pathToImg = "/resources/" + fileName;
        this.white = white.toUpperCase();
        this.black = black.toUpperCase();
    }

    public void convertImage() {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(Converter.class.getResource(pathToImg)));

            arrWidth = image.getWidth();
            arrHeight = image.getHeight();

            array = new int[arrHeight][arrWidth];

            ColoredPrinter colorWhite = new ColoredPrinter.Builder(1, false)
                    .background(Ansi.BColor.valueOf(white))
                    .build();

            ColoredPrinter colorBlack = new ColoredPrinter.Builder(1, false)
                    .background(Ansi.BColor.valueOf(black))
                    .build();

            for (int y = 0; y < arrHeight; ++y) {
                for (int x = 0; x < arrWidth; ++x) {
                    int color = image.getRGB(x, y);
                    if (color == Color.BLACK.getRGB()) {
                        colorBlack.print(" ");
                    } else if (color == Color.WHITE.getRGB()) {
                        colorWhite.print(" ");
                    } else {
                        System.out.println("Image is not black and while");
                        System.exit(1);
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Problem with image");
            System.exit(1);
        }
    }

}
