package com.twq.local;

import java.io.*;

public class LocalFileWriter {

    public static void main(String[] args) throws IOException {
        String content = "this is an example";
        String dest = "D:\\workspace\\java_writer.txt";

        File file = new File(dest);


        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(content.getBytes("UTF-8"));

        fileOutputStream.close();
    }
}
