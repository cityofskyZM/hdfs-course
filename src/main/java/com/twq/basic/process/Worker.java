package com.twq.basic.process;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Worker {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(args.length);

        System.out.println("the args[0] is : " + args[0]);

        //读取java opts中的-Dtest=testValue参数
        String testProp = System.getProperty("test");
        System.out.println("test property value is : " + testProp);

        Long sleepDuration = Long.parseLong(System.getProperty("sleepDuration", "2"));
        System.out.println("sleepDuration property value is : " + sleepDuration);
        TimeUnit.SECONDS.sleep(sleepDuration);
    }
}
