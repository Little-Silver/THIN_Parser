package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/test.txt";
    private static final String OUTPUT_FILE = "src/main/resources/output.txt";

    public static void main(String[] args) throws IOException {

        File file = new File(INPUT_FILE);

        try {
            Parser parser = new Parser(LineReader.readFile(file));
            try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
                for (String str : parser.getLineList()) {
                    writer.write(str + System.lineSeparator());
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
