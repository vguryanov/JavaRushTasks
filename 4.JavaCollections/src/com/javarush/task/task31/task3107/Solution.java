package com.javarush.task.task31.task3107;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path filepath = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(filepath), Files.isExecutable(filepath), Files.isDirectory(filepath), Files.isWritable(filepath));
        } catch (Exception f) {
            fileData = new NullFileData(f);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
