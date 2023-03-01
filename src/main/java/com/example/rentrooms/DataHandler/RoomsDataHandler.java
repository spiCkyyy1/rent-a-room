package com.example.rentrooms.DataHandler;

import javafx.beans.property.*;

public class RoomsDataHandler {
    private IntegerProperty roomNum;
    private IntegerProperty roomSize;
    private StringProperty roomType;
    private StringProperty roomStatus;
    public RoomsDataHandler(Integer roomNum, Integer roomSize, String roomType, String roomStatus){
        setRoomNum(roomNum);
        setRoomSize(roomSize);
        setRoomType(roomType);
        setRoomStatus(roomStatus);
    }

    public IntegerProperty roomnumProperty() {
        if(roomNum == null)
            roomNum = new SimpleIntegerProperty();
        return roomNum;
    }
    public IntegerProperty roomsizeProperty(){
        if(roomSize == null)
            roomSize = new SimpleIntegerProperty();
        return roomSize;
    }
    public StringProperty roomtypeProperty(){
        if(roomType == null)
            roomType = new SimpleStringProperty();
        return roomType;
    }
    public StringProperty roomstatusProperty(){
        if(roomStatus == null)
            roomStatus = new SimpleStringProperty();
        return roomStatus;
    }
    public void setRoomNum(Integer roomNum) {
        roomnumProperty().setValue(roomNum);
    }

    public Integer getRoomNum() {
        return roomnumProperty().get();
    }
    public void setRoomSize(Integer roomSize) {
        roomsizeProperty().setValue(roomSize);
    }
    public Integer getRoomSize() {
        return roomsizeProperty().get();
    }
    public void setRoomType(String roomType) {
        roomtypeProperty().setValue(roomType);
    }
    public String getRoomType() {
        return roomtypeProperty().getValue();
    }
    public void setRoomStatus(String roomStatus) {
        roomstatusProperty().setValue(roomStatus);
    }
    public String getRoomStatus() {
        return roomstatusProperty().getValue();
    }
}
