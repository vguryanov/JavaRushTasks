package com.javarush.task.task31.task3108;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Исследуем Path
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("C:\\Users\\User2\\Contacts\\amigo.txt");
        Path path2 = Paths.get("D:/test/data/secondDir/third");
//        Path resultPath = getDiffBetweenTwoPaths(path1, path2);
//        System.out.println(resultPath);   //expected output '../secondDir/third' or '..\secondDir\third'

        Properties properties = new Properties();
        properties.load(new FileReader(path1.toString()));

        for (String propertyName:properties.stringPropertyNames()) System.out.println(properties.getProperty(propertyName));
    }

    public static Path getDiffBetweenTwoPaths(Path path1, Path path2) {
        return path1.relativize(path2);
    }
}
