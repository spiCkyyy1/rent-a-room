package com.example.rentrooms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        System.out.println(data);
        welcomeText.setText("You have selected: "+data);
    }
}