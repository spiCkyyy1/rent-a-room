package com.example.rentrooms.Manager;

import com.example.rentrooms.DataHandler.RoomsDataHandler;
import com.example.rentrooms.Table.TableColumns;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerController implements Initializable {
    @FXML
    private TextField roomNumberField;
    @FXML
    private TextField roomSizeField;
    @FXML
    private TextField roomTypeField;
    @FXML
    private ListView<String> statusField;
    String[] statuses = {"Available", "Unavailable"};
    String selectedStatus;
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
    @FXML
    protected void addRoom(ActionEvent event){

        roomsView.getItems().add(new RoomsDataHandler(
                Integer.parseInt(roomNumberField.getText()),
                Integer.parseInt(roomSizeField.getText()),
                roomTypeField.getText(),
                selectedStatus));

        roomNumberField.setText("");
        roomSizeField.setText("");
        roomTypeField.setText("");
        selectedStatus = null;
    }
    public void setList(ObservableList<RoomsDataHandler> myList) {
        list = myList;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            TableColumns tableColumns = new TableColumns(roomsView, roomnumber, size, type, status);
            tableColumns.initiateCols();
            roomsView.setItems(list);
            statusField.getItems().addAll(statuses);
            statusField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    selectedStatus = statusField.getSelectionModel().getSelectedItem();
                }
            });
        });
    }
}