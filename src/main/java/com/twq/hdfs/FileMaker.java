package com.twq.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import java.net.URI;

import java.io.IOException;

public class FileMaker {

    public static void main(String[] args) throws IOException {

        Configuration configuration = new Configuration();

        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://master:9999/"),configuration);

       fileSystem.mkdirs(new Path("hdfs://master:9999/user/hadoop-twq/cmd/java"));

       fileSystem.mkdirs(new Path("hdfs://master:9999/user/hadoop-twq/cmd/tmp"), new FsPermission(FsAction.ALL, FsAction.EXECUTE, FsAction.NONE));
    }
}
