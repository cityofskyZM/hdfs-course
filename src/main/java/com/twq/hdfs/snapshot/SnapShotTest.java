package com.twq.hdfs.snapshot;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.client.HdfsAdmin;

import java.io.IOException;
import java.net.URI;

public class SnapShotTest {

    public static void main(String[] args) throws IOException {
        String dest = "hdfs://master:9999/user/hadoop-twq/cmd/";

        Configuration configuration = new Configuration();


        HdfsAdmin admin = new HdfsAdmin(URI.create(dest), configuration);
        admin.allowSnapshot(new Path(dest));

        admin.disallowSnapshot(new Path(dest));


        FileSystem fileSystem = FileSystem.get(URI.create(dest), configuration);
        fileSystem.createSnapshot(new Path(dest), "cmd-20180326-snapshots");
        fileSystem.deleteSnapshot(new Path(dest), "cmd-20180326-snapshots");

        fileSystem.renameSnapshot(new Path(dest), "cmd-20180326-snapshots", "new_snapshots");

        ((DistributedFileSystem)fileSystem).getSnapshotDiffReport(new Path(dest), "cmd-20180326-snapshots", "cmd-20180327-snapshots");


    }
}
