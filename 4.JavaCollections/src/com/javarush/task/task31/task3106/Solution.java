package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        String resultFileName = args[0];

        List<String> fileList = new ArrayList<>();

        fileList.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileList);

        List<FileInputStream> fileInputStreamList = new ArrayList<>();

        for (int i = 0; i < fileList.size(); i++) {

            try {
                fileInputStreamList.add(new FileInputStream(fileList.get(i)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fileInputStreamList));

        ZipInputStream zipInStream = new ZipInputStream(sequenceInputStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];

        while (zipInStream.getNextEntry() != null) {

            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }

        sequenceInputStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}