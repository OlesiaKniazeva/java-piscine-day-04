package edu.school21.printer.app;

import edu.school21.printer.logic.Converter;
public class Main {
    private static final String FILE_NAME = "it.bmp";
    private static char S1;
    private static char S2;

    public static void main(String[] args) {
        checkArgs(args);

        Converter c = new Converter(FILE_NAME, S1, S2);
        c.convertImage();
        c.printImage();
    }

    private static void checkArgs(String[] args) {
        if (args.length != 2) {
            System.out.println("You should add 2 symbols to print");
            System.exit(1);
        }
        if (args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("You should enter two symbols as arguments");
            System.exit(1);
        }

        S1 = args[0].charAt(0);
        S2 = args[1].charAt(0);

    }

}
