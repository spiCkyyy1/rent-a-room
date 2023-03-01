package com.example.rentrooms.Clerks;

import com.example.rentrooms.DataHandler.RoomsDataHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ClerksThread implements Runnable{
    ObservableList<RoomsDataHandler> list;
    private final int numberOfClerks = 3;
    public ClerksThread(ObservableList<RoomsDataHandler> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 1; i <= numberOfClerks; i++) {
            Stage secondaryStage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene((Parent) createClerksContent());
                ClerksController clerksController = new ClerksController();
                clerksController.setList(list);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clerks.fxml"));
        root.setCenter(fxmlLoader.load());
        return root;
    }
}
