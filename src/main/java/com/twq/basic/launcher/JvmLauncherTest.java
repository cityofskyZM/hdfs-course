package com.twq.basic.launcher;


import java.util.concurrent.TimeUnit;

/**
 * Created by tangweiqun on 2017/9/15.
 *
 java -cp C:\\bigdata-course\\workspace\\zookeeper-course\\target\\zookeeper-course-1.0-SNAPSHOT.jar -Dname=yellow -DsleepDuration=5 com.twq.launcher.JvmLauncherTest
 */
public class JvmLauncherTest {

    public static void main(String[] args) throws InterruptedException {
        String name = System.getProperty("name");

        Long sleepDuration = Long.parseLong(System.getProperty("sleepDuration", "10"));

        System.out.println("sleepDuration = " + sleepDuration);

        LauncherParam launcherParam = new LauncherParam();
        launcherParam.setName(name);

        System.out.println(launcherParam);

        TimeUnit.SECONDS.sleep(sleepDuration);
    }

}