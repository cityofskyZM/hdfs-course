package com.twq.local;

import java.io.*;

public class LocalFileReader {

    public static void main(String[] args) throws IOException {
        String dest = "c:\\java_writer.txt";

        FileInputStream fileInputStream = new FileInputStream(dest);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        fileInputStream.close();
    }
}
