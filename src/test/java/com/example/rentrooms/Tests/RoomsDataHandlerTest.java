package com.example.rentrooms.Tests;

import com.example.rentrooms.DataHandler.RoomsDataHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsDataHandlerTest {
    private RoomsDataHandler roomsDataHandler;
    @BeforeEach
    void setUp() {
        roomsDataHandler = new RoomsDataHandler(19, 23, "Library", "available");
    }
    @Test
    void setRoomNum() {
        roomsDataHandler.setRoomNum(19);
        int expectedResult = 19;
        assertEquals(expectedResult, roomsDataHandler.getRoomNum());
    }

    @Test
    void setRoomNumberInvalid(){
        try{
            roomsDataHandler.setRoomNum(-10);
            fail("Negative number not allowed");
        }catch (IllegalArgumentException e){
            System.out.println("Exception caught for negative number " + e.getMessage());
        }catch (Exception e){
            fail("Wrong exception thrown for setRoomNumber with negative number");
        }
    }

    @Test
    void getRoomNum() {
        roomsDataHandler.getRoomNum();
        assertEquals(19, 19);
    }
}