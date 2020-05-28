package com.codecool.file_part_reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;
    List<String> textList;

    public FileWordAnalyzer(FilePartReader filePartReader) throws IOException {
        this.filePartReader = filePartReader;
        textList = Arrays.asList(filePartReader.readLines().split(" "));
    }

    public ArrayList<String> getWordsOrderedAlphabetically() {
        Collections.sort(textList);
        return new ArrayList<>(textList);
    }


    public List<String> getWordsContainingSubstring(String subString) {
        ArrayList<String> resultWords = new ArrayList<>();
        for(String word : textList){
            if (word.contains(subString)){
                resultWords.add(word);
            }
        }
        return resultWords;
    }

    public ArrayList<String> getStringsWhichPalindromes() throws IOException {
        ArrayList<String> resultWords = new ArrayList<>();
        for(String word : textList){
            StringBuilder reversed = new StringBuilder();
            for(int i = word.length() -1; i >= 0; i--){
                reversed.append(word.charAt(i));
            }
            if(word.equals(reversed.toString())){
                resultWords.add(word);
            }
        }
        return resultWords;
    }

}
