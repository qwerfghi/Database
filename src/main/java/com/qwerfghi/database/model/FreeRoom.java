package com.qwerfghi.database.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class FreeRoom {
    private IntegerProperty roomCost;
    private IntegerProperty roomNum;

    public String getRoomType() {
        return roomType.get();
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

    private StringProperty roomType;

    public int getRoomCost() {
        return roomCost.get();
    }

    public IntegerProperty roomCostProperty() {
        return roomCost;
    }

    public int getRoomNum() {
        return roomNum.get();
    }

    public IntegerProperty roomNumProperty() {
        return roomNum;
    }

    FreeRoom(int roomNum, int roomCost, String roomType) {
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.roomCost = new SimpleIntegerProperty(roomCost);
        this.roomType = new SimpleStringProperty(roomType);
    }
}
