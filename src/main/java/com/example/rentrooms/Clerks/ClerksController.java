package com.example.rentrooms.Clerks;

import com.example.rentrooms.DataHandler.BookingDetails;
import com.example.rentrooms.DataHandler.RoomsDataHandler;
import com.example.rentrooms.Table.TableColumns;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClerksController implements Initializable {
    public static ObservableList<RoomsDataHandler> list = FXCollections.observableArrayList();
    public static ObservableList<BookingDetails> bookingDetails = FXCollections.observableArrayList();
    @FXML
    private TextField owner;
    @FXML
    private TextField contact;
    @FXML
    private TextField notes;
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
    private TextField searchField;
    public void setList(ObservableList<RoomsDataHandler> myList) {
        list = myList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            TableColumns tableColumns = new TableColumns(roomsView, roomnumber, size, type, status);
            tableColumns.initiateCols();
            roomsView.setItems(list);
            searchField.textProperty().addListener((obs, oldText, newText) -> {
//                searchField.setDisable(newText.isEmpty());
                roomsView.setItems(filterList(list, newText));
                roomsView.refresh();
            });
        });
    }
    private boolean searchFindsOrder(RoomsDataHandler roomsDataHandler, String searchText){
        return (roomsDataHandler.getRoomStatus().toLowerCase().contains(searchText.toLowerCase())) ||
                (roomsDataHandler.getRoomType().toLowerCase().contains(searchText.toLowerCase()));
    }
    private ObservableList<RoomsDataHandler> filterList(List<RoomsDataHandler> list, String searchText){
        List<RoomsDataHandler> filteredList = new ArrayList<>();
        for (RoomsDataHandler order : list){
            if(searchFindsOrder(order, searchText)) filteredList.add(order);
        }
        return FXCollections.observableList(filteredList);
    }

    public void addBookingDetails(ActionEvent event) {
        bookingDetails.add(new BookingDetails(owner.getText(), contact.getText(), notes.getText()));
        owner.setText("");
        contact.setText("");
        notes.setText("");
        System.out.println(bookingDetails);
    }
}
