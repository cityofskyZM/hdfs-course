package com.twq.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * 需要执行
 * hadoop fs -chmod 757 hdfs://master:9999/user/hadoop-twq/cmd/
 */

public class FileWriter {

    public static void main(String[] args) throws IOException {
        String content = "this is an example";
        String dest = "/user/hadoop-twq/cmd/java_writer.txt";

        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        FSDataOutputStream out = fileSystem.create(new Path(dest));

        out.write(content.getBytes("UTF-8"));

        out.close();
    }
}
