package edu.school21.printer.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Parser {
    @Parameter (names = "--white", description = "How to change white color", required = true)

    private String white;

    @Parameter (names = "--black", description = "How to change black color", required = true)

    private String black;

    public String getBlack() {
        return black;
    }

    public String getWhite() {
        return white;
    }
}