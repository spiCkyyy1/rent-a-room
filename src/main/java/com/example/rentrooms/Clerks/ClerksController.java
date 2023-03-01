package com.example.rentrooms.Clerks;

import com.example.rentrooms.DataHandler.RoomsDataHandler;
import com.example.rentrooms.Table.TableColumns;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class ClerksController implements Initializable {
    public static ObservableList<RoomsDataHandler> list = FXCollections.observableArrayList();
    @FXML
    private TableView<RoomsDataHandler> roomsView;
    @FXML
    private TableColumn<RoomsDataHandler, Integer> roomnumber;
    @FXML
    private TableColumn<RoomsDataHandler, Integer> size;
    @FXML
    private TableColumn<RoomsDataHandler, String> type;
    @FXML
    private TableColumn<RoomsDataHandler, Boolean> status;

    public void setList(ObservableList<RoomsDataHandler> myList) {
        list = myList;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            TableColumns tableColumns = new TableColumns(roomsView, roomnumber, size, type, status);
            tableColumns.initiateCols();
            roomsView.setItems(list);
        });
    }
}
