package com.codecool.file_part_reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> wordsList = returnWordsFromLines();
        Collections.sort(wordsList);
        return wordsList;
    }


    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> wordsList = returnWordsFromLines();
        List<String> result = new ArrayList<>();
        for(String word : wordsList){
            if (word.contains(subString)){
                result.add(word);
            }
        }
        return result;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> wordsList = returnWordsFromLines();
        List<String> result = new ArrayList<>();
        for(String word : wordsList){
            String reversed = "";
            for(int i = word.length() -1; i >= 0; i--){
                reversed = reversed + word.charAt(i);
            }
            if(word.equals(reversed)){
                result.add(word);
            }
        }
        return result;
    }

    public List<String> returnWordsFromLines() throws IOException {
        String lines = filePartReader.readLines("text.txt", 2, 5);
        String[] words = lines.split("");
        return Arrays.asList(words);
    }
}
