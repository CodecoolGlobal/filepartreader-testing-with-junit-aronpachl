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
        ArrayList<String> predictedResult = new ArrayList<>();
        predictedResult.add("am");
        predictedResult.add("carrot");
        predictedResult.add("heeh");
        predictedResult.add("i");
        predictedResult.add("tomato");

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/text.txt", 1, 6);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        ArrayList<String> ordered =  fileWordAnalyzer.getWordsOrderedAlphabetically();

        assertEquals(predictedResult, ordered);

    }

    @Test
    public void testIsContainingSubstring() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/text.txt", 1, 6);
        List<String> contains = new ArrayList<>();
        contains.add("carrot");

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        ArrayList<String> carrot = fileWordAnalyzer.getWordsContainingSubstring("carrot");

        assertEquals(contains, carrot);

    }

    @Test
    public void testIsPalindromesCorrect() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/text.txt", 1, 6);
        List<String> contains = new ArrayList<>();
        contains.add("heeh");
        contains.add("i");
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        ArrayList<String> result = fileWordAnalyzer.getStringsWhichPalindromes();

        assertEquals(contains, result);
    }

}