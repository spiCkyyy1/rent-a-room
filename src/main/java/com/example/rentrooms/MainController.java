package com.example.rentrooms;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage primaryStage2) throws IOException {

        Runnable managerThread = new ManagerThread();
        Thread thread1 = new Thread(managerThread, "ManagerThread");
        thread1.run();
        System.out.println(thread1.getName());

//        Runnable clerksThread = new ClerksThread();
//        Thread thread2 = new Thread(clerksThread, "ClerksThread");
//        thread2.run();
//        System.out.println(thread2.getName());
    }



    public static void main(String[] args) {
        launch();
    }
}