package com.codecool;

import com.codecool.file_part_reader.FilePartReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testIsReadFileThrowsIOException(){
        final FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("text.txt", 4,7);
        assertThrows(IOException.class, filePartReader::read);
    }

    @Test
    public void testIsFromLineBelow1ThrowsIllegalArgumentException(){
        final FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/text.txt", 0, 5));
    }


    @Test
    public void testIsToLineBelowFromLineThrowsIllegalArgumentException(){
        final FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("src/main/resources/text.txt", 5, 2));
    }

    @Test
    public void testReadLinesGetCorrectSize() throws IOException {
        final FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/text.txt", 4,7);
        List<String> textWords = Arrays.asList(filePartReader.readLines().split(" "));
        assertEquals(3, textWords.size());
    }

}