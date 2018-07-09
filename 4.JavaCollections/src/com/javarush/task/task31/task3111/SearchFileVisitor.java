package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = Integer.MIN_VALUE;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File file1 = new File(file.toString());

        String fileContent = new String(Files.readAllBytes(file), Charset.defaultCharset());

        if (file1.getName().contains(partOfName) && fileContent.contains(partOfContent) && file1.length() > minSize && file1.length() < maxSize) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
