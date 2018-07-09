package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path path = null;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            path = Paths.get(bufferedReader.readLine());
        }

        if (Files.isDirectory(path)) {
            MyFileVisitor myFileVisitor = new MyFileVisitor();
            EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

            Files.walkFileTree(path, options, Integer.MAX_VALUE, myFileVisitor);

            System.out.println("Всего папок - " + myFileVisitor.dirCount);
            System.out.println("Всего файлов - " + myFileVisitor.fileCount);
            System.out.println("Общий размер - " + myFileVisitor.size);
        } else System.out.println(path + " - не папка");
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private int size = 0;
        private int fileCount = 0;
        private int dirCount = -1;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            size += Files.size(file);
            fileCount++;
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            dirCount++;
            return super.postVisitDirectory(dir, exc);
        }
    }
}
