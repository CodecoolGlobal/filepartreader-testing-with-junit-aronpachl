package com.codecool;

import com.codecool.file_part_reader.FilePartReader;
import com.codecool.file_part_reader.FileWordAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testIsWordsAreOrdered() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        String readLines = filePartReader.readLines("/home/aron/Codecool/OOP/FilePartReader/filepartreader-testing-with-junit-aronpachl/src/main/resources/text.txt", 2, 5);
        List<String> readLinesList = Collections.singletonList(readLines);
        Collections.sort(readLinesList);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        List<String> ordered =  fileWordAnalyzer.getWordsOrderedAlphabetically();

        assertSame(readLinesList, ordered);

    }

    @Test
    public void testIsContainingSubstring() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        List<String> contains = new ArrayList<>();
        contains.add("carrot");

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> carrot = fileWordAnalyzer.getWordsContainingSubstring("carrot");

        assertSame(contains, carrot);

    }

}