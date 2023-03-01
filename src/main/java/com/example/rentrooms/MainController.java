package com.example.rentrooms;
import com.example.rentrooms.DataHandler.RoomsDataHandler;
import com.example.rentrooms.Clerks.ClerksThread;
import com.example.rentrooms.Manager.ManagerThread;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {
    public static ObservableList<RoomsDataHandler> list = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage2) throws IOException {
        list.add(new RoomsDataHandler(200, 50, "Testing", "Available"));
        list.addAll(new RoomsDataHandler(100, 10, "computer lab", "Available"), new RoomsDataHandler(101, 20, "Theatre", "Unavailable"));

        Platform.runLater(() -> {
            Runnable managerThread = new ManagerThread(list);
            Thread thread1 = new Thread(managerThread, "ManagerThread");
            thread1.run();
        });

        Platform.runLater(() -> {
            Runnable clerksThread = new ClerksThread(list);
            Thread thread2 = new Thread(clerksThread, "ClerksThread");
            thread2.run();
        });


        list.addListener((ListChangeListener<RoomsDataHandler>) change -> {
            while (change.next()){
                System.out.println("Was added? " + change.wasAdded());
                System.out.println("Was removed? " + change.wasRemoved());
                System.out.println("Was replaced? " + change.wasReplaced());
                System.out.println("Was permutated? " + change.wasPermutated());
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}