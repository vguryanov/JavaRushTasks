package com.javarush.task.task31.task3102;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();

        Stack<File> stack = new Stack();
        stack.push(new File(root));

        while (!stack.empty()) {
            File file = stack.pop();

            if (file.isDirectory()) for (File f : file.listFiles()) stack.push(f);
            else if (file.isFile()) list.add(file.getAbsolutePath());
        }

        return list;
    }

    public static void main(String[] args) {
        try {
            for (String s : getFileTree("C:\\Users\\User2\\Music")) System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
