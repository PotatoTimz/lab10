package com.example.lab10;

import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    private Socket socket;
    private static DataInputStream inStream = null;
    private TextArea messageBox;


    public ClientHandler(Socket socket, TextArea messageBox) {
        try {
            this.socket = socket;
            //this.clients = clients;
            this.inStream = new DataInputStream(socket.getInputStream());
            this.messageBox = messageBox;
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public void run() {
        try {
            while (socket.isConnected()) {
                    String messageFromClient = inStream.readUTF();
                    String previousMessages = messageBox.getText();
                    System.out.println(messageFromClient);
                    messageBox.setText(previousMessages + "\n" + messageFromClient);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
