package com.example.rentrooms;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {


    @Override
    public void start(Stage primaryStage2) throws IOException {

        Task<Void> openManagerTask = null;
        try {
            openManagerTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Stage primaryStage = new Stage();
                    Scene scene = new Scene((Parent) createManagerContent(), 800, 600);
                    primaryStage.setTitle("Manager");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    return null;
                }
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        openManagerTask.setOnCancelled(e -> {
            System.out.println("Cancelled!");
        });

        openManagerTask.setOnSucceeded(e -> {
            System.out.println("Succeeded");
        });

        openManagerTask.setOnRunning(e -> {
            System.out.println("Im running");
        });

        Task<Void> openClerksTask = null;
        try {
            openClerksTask = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    for (int i = 1; i <= 3; i++) {
                        Stage secondaryStage = new Stage();
                        Scene scene = new Scene((Parent) createClerksContent(), 800, 600);
                        secondaryStage.setTitle("Clerk " + i);
                        secondaryStage.setScene(scene);
                        secondaryStage.show();
                    }
                    return null;
                }
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        openClerksTask.setOnCancelled(e -> {
            System.out.println("Cancelled!");
        });

        openClerksTask.setOnSucceeded(e -> {
            System.out.println("Succeeded");
        });

        openClerksTask.setOnRunning(e -> {
            System.out.println("Im running");
        });

        new Thread(openManagerTask).run();
        new Thread(openClerksTask).run();
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