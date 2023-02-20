package com.example.rentrooms;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClerksThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            Stage secondaryStage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene((Parent) createClerksContent(), 800, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            secondaryStage.setTitle("Clerk " + i);
            secondaryStage.setScene(scene);
            secondaryStage.show();
        }
    }

    public Node createClerksContent() throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader fxmlLoader = new FXMLLoader(ClerksController.class.getResource("Clerks/clerks.fxml"));
        root.setCenter(fxmlLoader.load());
        return root;
    }
}
