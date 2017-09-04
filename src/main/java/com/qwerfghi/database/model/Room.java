package com.qwerfghi.database.model;

import javafx.beans.property.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Room {
    private MyConnection connection;
    private StringProperty roomType;
    private IntegerProperty roomCost;
    private IntegerProperty roomNum;
    private StringProperty dateEnter;
    private StringProperty dateOut;

    public String getDateEnter() {
        return dateEnter.get();
    }

    public StringProperty dateEnterProperty() {
        return dateEnter;
    }

    public String getDateOut() {
        return dateOut.get();
    }

    public StringProperty dateOutProperty() {
        return dateOut;
    }

    public MyConnection getConnection() {
        return connection;
    }

    public String getRoomType() {
        return roomType.get();
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

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

    Room(MyConnection connection, String roomType, String dateEnter, int roomCost, int roomNum, String dateOut) {
        this.connection = connection;
        this.roomType = new SimpleStringProperty(roomType);
        this.dateEnter = new SimpleStringProperty(dateEnter);
        this.roomCost = new SimpleIntegerProperty(roomCost);
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.dateOut = new SimpleStringProperty(dateOut);
    }
    Room(MyConnection connection, int roomNum, String dateEnter, String dateOut, int roomCost  ) {
        this.connection = connection;
        this.dateEnter = new SimpleStringProperty(dateEnter);
        this.roomCost = new SimpleIntegerProperty(roomCost);
        this.roomNum = new SimpleIntegerProperty(roomNum);
        this.dateOut = new SimpleStringProperty(dateOut);
    }
}
