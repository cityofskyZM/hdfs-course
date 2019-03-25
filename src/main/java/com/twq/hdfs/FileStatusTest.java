package com.twq.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Random;

public class FileStatusTest {

    public static void main(String[] args) throws IOException {

        Configuration configuration = new Configuration();

        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://master:9999/"),configuration);

        //查看一个文件的状态信息
        FileStatus fileStatus = fileSystem.getFileStatus(new Path("hdfs://master:9999/user/hadoop-twq/cmd/word.txt"));
        System.out.println(fileStatus.getPath());
        System.out.println(fileStatus.getBlockSize());
        System.out.println(fileStatus.getLen()); //总大小
        System.out.println(fileStatus.getReplication());
        Random random = new Random();

        System.out.println(fileStatus.isDirectory());
        System.out.println(fileStatus.isFile());

        System.out.println(fileStatus.getOwner());
        System.out.println(fileStatus.getGroup());
        System.out.println(fileStatus.getPermission());

        //查看一个目录下所有的文件信息
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("hdfs://master:9999/user/hadoop-twq/cmd"));

        for (FileStatus temp : fileStatuses) {
            System.out.println(temp.getPath());
            System.out.println(temp.getBlockSize());
            System.out.println(temp.getLen()); //总大小
            System.out.println(temp.getReplication());

            System.out.println(temp.isDirectory());
            System.out.println(temp.isFile());

            System.out.println(temp.getOwner());
            System.out.println(temp.getGroup());
            System.out.println(temp.getPermission());
        }

    }
}
