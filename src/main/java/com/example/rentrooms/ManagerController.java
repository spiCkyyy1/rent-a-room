package com.example.rentrooms;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerController implements Initializable {


    ObservableList<RoomsDataHandler> list = FXCollections.observableArrayList();
    public TableColumn actions;
    //    @FXML
//    private Label welcomeText;
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

//    @FXML
//    protected void onHelloButtonClick(ActionEvent event){
//        Node node = (Node) event.getSource();
//        String data = (String) node.getUserData();
//        System.out.println(data);
//        welcomeText.setText("You have selected: "+data);
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateCols();
        loadData();
    }

    private void initiateCols(){
        roomnumber.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        size.setCellValueFactory(new PropertyValueFactory<>("roomSize"));
        type.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        status.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
    }

    private void loadData(){
        list.removeAll(list);
        list.addAll(new RoomsDataHandler(100, 10, "computer lab", Boolean.TRUE));
        roomsView.getItems().addAll(list);
    }


}