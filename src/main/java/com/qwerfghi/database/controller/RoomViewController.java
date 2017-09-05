package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.Room;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RoomViewController {
    private MyConnection connection;

    @FXML
    private TableView<Room> table;
    @FXML
    private TableColumn<Room, Integer> roomNumColumn;
    @FXML
    private TableColumn<Room, String> roomTypeColumn;
    @FXML
    private TableColumn<Room, String> dateEnterColumn;
    @FXML
    private TableColumn<Room, String> dateOutColumn;
    @FXML
    private TableColumn<Room, Integer> roomCostColumn;

    private ObservableList<Room> list;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getAllRooms();
        roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty().asObject());
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        dateEnterColumn.setCellValueFactory(cellData -> cellData.getValue().dateEnterProperty());
        dateOutColumn.setCellValueFactory(cellData -> cellData.getValue().dateOutProperty());
        roomCostColumn.setCellValueFactory(cellData -> cellData.getValue().roomCostProperty().asObject());
        table.setItems(list);
    }
}
