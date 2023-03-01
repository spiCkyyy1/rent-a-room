package com.example.rentrooms.Table;

import com.example.rentrooms.DataHandler.RoomsDataHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableColumns {
    private final TableView<RoomsDataHandler> roomsView;
    private final TableColumn<RoomsDataHandler, Integer> roomnumber;
    private final TableColumn<RoomsDataHandler, Integer> size;
    private final TableColumn<RoomsDataHandler, String> type;
    private final TableColumn<RoomsDataHandler, Boolean> status;

    public TableColumns(TableView<RoomsDataHandler> roomsView, TableColumn<RoomsDataHandler, Integer> roomnumber, TableColumn<RoomsDataHandler, Integer> size, TableColumn<RoomsDataHandler, String> type, TableColumn<RoomsDataHandler, Boolean> status) {
        this.roomsView = roomsView;
        this.roomnumber = roomnumber;
        this.size = size;
        this.type = type;
        this.status = status;
    }
    public void initiateCols(){
        roomsView.setEditable(true);
        roomnumber.setCellValueFactory(new PropertyValueFactory<>("roomNum"));
        size.setCellValueFactory(new PropertyValueFactory<>("roomSize"));
        type.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        status.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        addButtonToTable();
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
