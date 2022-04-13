package com.example.lab10;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable{

    @FXML
    public TextArea messageBox;

    @FXML
    Button exitButton;

    @FXML
    AnchorPane anchorPane;

    Stage stage;
    private Server server;
    private ServerSocket serve = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            server = new Server(new ServerSocket(1234), messageBox);
            new Thread(server).start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setExitButton(ActionEvent event) throws IOException{
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

}
