package com.example.lab10;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    Button sendButton;
    @FXML
    Button exitButton;

    @FXML
    TextField messageText;
    @FXML
    TextField nameText;

    @FXML
    AnchorPane anchorPane;

    Stage stage;
    private Client client;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.client = new Client(new Socket("localhost", 1234));
            System.out.println("Connected to server");

        }

        catch(IOException e){
            System.out.println(e);
        }
    }

    public void sendButtonClick(ActionEvent event) throws IOException{
        this.client.writeMessage(nameText.getText()+": "+messageText.getText());
    }

    public void setExitButton(ActionEvent event) throws IOException{
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        Client.exit();
    }

}