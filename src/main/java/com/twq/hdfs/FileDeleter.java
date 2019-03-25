package com.twq.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class FileDeleter {

    public static void main(String[] args) throws IOException {
        String dest = "hdfs://master:9999/user/hadoop-twq/cmd/java_writer.txt";

        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(dest), configuration);

        fileSystem.delete(new Path(dest), false);

        fileSystem.delete(new Path("hdfs://master:9999/user/hadoop-twq/cmd/tmp"), true);
    }
}
