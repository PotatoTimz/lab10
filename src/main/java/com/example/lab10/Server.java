package com.example.lab10;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server extends Thread{

    private ServerSocket serversocket = null;
    private Socket socket;
    private TextArea messagebox = null;

    public Server(ServerSocket serverSock, TextArea messagebox) throws SocketException {
        this.serversocket = serverSock;
        this.messagebox = messagebox;
        this.serversocket = serverSock;
        this.serversocket.setReuseAddress(true);
    }
    public void run(){
        try{
            System.out.println("Starting server...");
            System.out.println("Waiting for client connection...");
            while(true) {
                this.socket = serversocket.accept();
                System.out.println("Client is connected " + socket.getInetAddress().getHostAddress()); //this will display the host address of client
                ClientHandler client = new ClientHandler(socket, messagebox);
                new Thread(client).start();
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

}