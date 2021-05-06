package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Reads every line in a file.
 *
 * @author Pascal Isliker
 */
public class LineReader {

    private LineReader() {
        throw new IllegalStateException("Should not create instance of LineReader");
    }

    /**
     * Extracts the file content line by line into a String list
     *
     * @param file to read from
     * @return the file content line by line
     * @throws FileNotFoundException if there is an error reading the file
     */
    public static List<String> readFile(File file) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

}
