package com.codecool.file_part_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    String filePath;
    int fromLine;
    int toLine;

    public void setup(String filePath, int fromLine, int toLine) {

        this.filePath = filePath;

        if (toLine < fromLine) throw  new IllegalArgumentException("toLine is smaller");
        else this.toLine = toLine;

        if (fromLine < 1) throw new IllegalArgumentException("fromLine can't be lower than 1");
        else this.fromLine = fromLine;
    }

    public String read() throws IOException {
        StringBuilder text = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                text.append(line);
                text.append(" ");
            }
            reader.close();
            return text.toString();
        } catch (IOException e) {
            throw  new IOException("file not found!");
        }


    }

    public String readLines() throws IOException {
        StringBuilder result = new StringBuilder();
        List<String> file = Arrays.asList(read().split(" "));

        for (int line = fromLine; line < toLine; line++ ){
            result.append(file.get(line));
            result.append(" ");
        }
        return result.toString();
    }

}
