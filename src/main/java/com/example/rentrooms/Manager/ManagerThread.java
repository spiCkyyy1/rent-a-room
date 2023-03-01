package com.example.rentrooms.Manager;

import com.example.rentrooms.DataHandler.RoomsDataHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class ManagerThread implements Runnable{
    ObservableList<RoomsDataHandler> list;
    public ManagerThread(ObservableList<RoomsDataHandler> myList) {
        list = myList;
    }

    @Override
    public void run() {
        Stage primaryStage = new Stage();
        Scene scene = null;
        try {
            scene = new Scene((Parent) createManagerContent());
            ManagerController managerController = new ManagerController();
            managerController.setList(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.setTitle("Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node createManagerContent() throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manager.fxml"));
        root.setCenter(fxmlLoader.load());
        return root;
    }
}
