package com.example.lab10;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    //initialize socket and io streams
    private static Socket sock = null;
    private static DataOutputStream dout = null;

    public Client(Socket socket){
        try {
            this.sock = socket;
            dout = new DataOutputStream(sock.getOutputStream());
        }
        catch(IOException e){
            System.out.println(e);

        }
    }

    public void writeMessage(String message){
       try {
           dout.writeUTF(message);

       }
       catch(IOException e){
           System.out.println(e);
       }
    }

    public static void exit(){
        try {
            dout.close();
            sock.close();
            System.out.println("Client has closed");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }


}