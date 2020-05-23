package com.codecool.file_part_reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilePartReader {

    public void setup(String filePath, int fromLine, int toLine) {

        if (toLine < fromLine) throw  new IllegalArgumentException("toLine is smaller");

        if (fromLine < 1) throw new IllegalArgumentException("fromLine can't be lower than 1");

        ArrayList<String> file = read(filePath);

        String result = readLines(file, fromLine, toLine);

        System.out.println(result);
    }

    public ArrayList<String> read(String filePath){
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
            System.err.format("file not found" + e);
            return null;
        }


    }

    public String readLines(ArrayList<String> file, int fromLine, int toLine){
        StringBuilder result = new StringBuilder();
        for (int line = fromLine; line < toLine; line++ ){
            result.append(file.get(line));
        }
        return result.toString();
    }

}
