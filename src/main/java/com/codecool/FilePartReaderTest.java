package com.codecool;

import com.codecool.file_part_reader.FilePartReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testIsReadFileThrowsIOExcepction(){
        final FilePartReader filePartReader = new FilePartReader();
        assertThrows(IOException.class, () -> filePartReader.read("text.txt"));
    }

    @Test
    public void testIsFromLineBelow1ThrowsIllegalArgumentException(){
        final FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("text.txt", 0, 5));
    }


    @Test
    public void testIsToLineBelowFromLineThrowsIllegalArgumentException(){
        final FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("text.txt", 5, 2));
    }

}