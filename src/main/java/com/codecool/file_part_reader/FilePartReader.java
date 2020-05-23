package com.codecool.file_part_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilePartReader {

    public void setup(String filePath, int fromLine, int toLine) {

        if (toLine < fromLine) throw  new IllegalArgumentException("toLine is smaller");

        if (fromLine < 1) throw new IllegalArgumentException("fromLine can't be lower than 1");

    }

    public ArrayList<String> read(String filePath) throws IOException {
        ArrayList<String> records = new ArrayList<String>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (IOException e) {
            throw  new IOException("file not found!");
        }


    }

    public String readLines(String filePath, int fromLine, int toLine) throws IOException {
        StringBuilder result = new StringBuilder();
        ArrayList<String> file = read(filePath);

        for (int line = fromLine; line < toLine; line++ ){
            result.append(file.get(line));
        }
        return result.toString();
    }

}
