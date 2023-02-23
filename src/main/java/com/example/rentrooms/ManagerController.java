package com.example.rentrooms;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
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
    ObservableList<RoomsDataHandler> list = FXCollections.observableArrayList();
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
    private TableColumn<RoomsDataHandler, Button> actions;
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

        System.out.println("Added a new room in Table");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusField.getItems().addAll(statuses);
        statusField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectedStatus = statusField.getSelectionModel().getSelectedItem();

                System.out.println(selectedStatus);
            }
        });
        initiateCols();
        loadData();
    }

    private void initiateCols(){
        roomsView.setEditable(true);
        roomnumber.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        size.setCellValueFactory(new PropertyValueFactory<>("roomSize"));
        type.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        status.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
//        actions.setCellValueFactory(new PropertyValueFactory<>("actions"));
        addButtonToTable();
    }

    private void loadData(){
        list.removeAll(list);
        list.addAll(new RoomsDataHandler(100, 10, "computer lab", "Available"), new RoomsDataHandler(101, 20, "Theatre", "Unavailable"));
        roomsView.getItems().addAll(list);
    }

    private void addButtonToTable() {
        TableColumn<RoomsDataHandler, Void> colBtn = new TableColumn<>("Actions");

        Callback<TableColumn<RoomsDataHandler, Void>, TableCell<RoomsDataHandler, Void>> cellFactory = new Callback<TableColumn<RoomsDataHandler, Void>, TableCell<RoomsDataHandler, Void>>() {
            @Override
            public TableCell<RoomsDataHandler, Void> call(final TableColumn<RoomsDataHandler, Void> param) {
                final TableCell<RoomsDataHandler, Void> cell = new TableCell<RoomsDataHandler, Void>() {

                    private final Button btn = new Button("Delete");

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                            btn.setOnAction((ActionEvent event) -> {
                                RoomsDataHandler data = getTableView().getItems().get(getIndex());
                                roomsView.getItems().remove(data);
                            });
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        roomsView.getColumns().add(colBtn);

    }
}