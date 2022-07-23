package edu.school21.printer.app;

import com.beust.jcommander.JCommander;

import edu.school21.printer.logic.Converter;
public class Main {
    private static final String FILE_NAME = "it.bmp";

    public static void main(String[] args) {

        try {
            Parser parser = new Parser();
            JCommander commander = JCommander.newBuilder()
                    .addObject(parser)
                    .build();

            commander.parse(args);
            Converter c = new Converter(FILE_NAME, parser.getBlack(), parser.getWhite());
            c.convertImage();
        } catch (Exception e) {
            System.out.println("To run program you should add color arguments for changing black and white colors, in README.txt");
        }


    }

}
