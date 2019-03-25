package com.twq.basic.rpc.socket.socketHomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest{

    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(5679);
            Socket client = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            while (true){
                String str = reader.readLine();
                System.out.println("client says: "+str);
                if(str.equals("end")){
                    System.out.println("client says end the program ! so we stop!");
                    break;
                }else if(str.equals("hello")){
                    out.println("hello world");
                }else{
                    out.println("I don't understand what you saying,try it again!");
                }
                out.flush();
            }
            client.close();
            server.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
