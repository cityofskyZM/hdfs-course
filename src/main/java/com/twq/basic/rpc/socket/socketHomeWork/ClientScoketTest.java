package com.twq.basic.rpc.socket.socketHomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientScoketTest {

    public static void main(String[] args){
        try{
            Socket socket = new Socket(InetAddress.getLocalHost(),5679);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader write = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String str = write.readLine();
                out.println(str);
                out.flush();

                if(str.equals("end")){
                    System.out.println("i say end the program !");
                    break;
                }
                System.out.println(reader.readLine());
            }
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
