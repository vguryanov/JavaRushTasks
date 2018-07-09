package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("http://orig10.deviantart.net/d920/f/2014/063/c/4/ergo_proxy___re_l_mayer__02__by_beethy-d78v1y4.jpg", Paths.get("C:\\Users\\User2\\Contacts"));

//        for (String line : Files.readAllLines(passwords)) {
//            System.out.println(line);
//        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url=new URL(urlString);
        InputStream inputStream=url.openStream();
        Path tmp=Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream,tmp);
        String fileName=urlString.substring(urlString.lastIndexOf("/"));
        String dir=downloadDirectory.toString();
        Path moveTo=Paths.get(dir+fileName);
        Files.move(tmp,moveTo);
        return Paths.get(downloadDirectory.toString()+urlString.substring(urlString.lastIndexOf("/")));
    }
}
