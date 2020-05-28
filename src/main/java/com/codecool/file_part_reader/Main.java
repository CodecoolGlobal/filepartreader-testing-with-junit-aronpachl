package com.codecool.file_part_reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/text.txt", 1,6);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
    }
}
