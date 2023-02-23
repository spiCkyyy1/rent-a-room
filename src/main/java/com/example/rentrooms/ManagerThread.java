package com.example.rentrooms;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ManagerThread implements Runnable{
    @Override
    public void run() {
        Stage primaryStage = new Stage();
        Scene scene = null;
        try {
            scene = new Scene((Parent) createManagerContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setTitle("Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("Running the thread");
    }

    private Node createManagerContent() throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader fxmlLoader = new FXMLLoader(ManagerController.class.getResource("manager.fxml"));
        root.setCenter(fxmlLoader.load());
        return root;
    }
}
