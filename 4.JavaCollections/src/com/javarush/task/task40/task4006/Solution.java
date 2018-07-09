package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://youcomedy.me/user/neroninaolya"));
    }

    public static void getSite(URL url) {
        try {
            Socket socket = new Socket(url.getHost(), url.getDefaultPort());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
//            System.out.println("GET " + url.getPath() + " HTTP/1.1\r\n");
            pw.print("GET " + url.getPath() + " HTTP/1.1\r\n");
            pw.print("Host: " + url.getHost() + "\r\n");
            pw.print("Accept: text/plain, text/html, text/*\r\n");
            pw.print("\r\n");
            pw.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}