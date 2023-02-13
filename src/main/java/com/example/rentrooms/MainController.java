package com.example.rentrooms;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene((Parent) createManagerContent(), 800, 600);
        stage.setTitle("Rent Rooms!");
        stage.setScene(scene);
        stage.show();


//        scene = new Scene((Parent) createClerksContent(), 800, 600);
//        stage.setTitle("Rent Rooms!");
//        stage.setScene(scene);
//        stage.show();
    }
    public void handle(ActionEvent event) {
        System.out.println("Hello World!");

        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(4, new Label("Second window"))));
        secondStage.show();

    }

    public Node createManagerContent() throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("manager.fxml"));
        root.setCenter(fxmlLoader.load());
        return root;
    }

    public Node createClerksContent() throws IOException {
        BorderPane root = new BorderPane();
        FXMLLoader fxmlLoader = new FXMLLoader(ClerksController.class.getResource("Clerks/clerks.fxml"));
        root.setCenter(fxmlLoader.load());
        return root;
    }



    public static void main(String[] args) {
        launch();
    }
}