package edu.school21.printer.app;

import edu.school21.printer.logic.Converter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static String PATH;
    private static char S1;
    private static char S2;

    public static void main(String[] args) {
        checkArgs(args);

        Converter c = new Converter(PATH, S1, S2);
        c.convertImage();
        c.printImage();
    }

    private static void checkArgs(String[] args) {
        if (args.length != 3) {
            System.out.println("You should add 2 symbols to print " +
                    "image and absolute path to it");
            System.exit(1);
        }
        if (args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("You should enter two symbols as arguments");
            System.exit(1);
        }

        S1 = args[0].charAt(0);
        S2 = args[1].charAt(0);

        Path absPath = Paths.get(args[2]);

        if (!absPath.isAbsolute() || !Files.exists(absPath) || !Files.isReadable(absPath)) {
            System.out.println("Problem with image");
            System.exit(1);
        }
        PATH = args[2];
    }
}
