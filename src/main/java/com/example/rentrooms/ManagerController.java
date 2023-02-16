package com.example.rentrooms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event){
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        System.out.println(data);
        welcomeText.setText("You have selected: "+data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}