package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.Room;
import com.qwerfghi.database.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RoomViewController {

    private UserService userService;

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
        userService = Main.getContext().getBean(UserService.class);
        list = FXCollections.observableArrayList(userService.getAllRooms());
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        dateEnterColumn.setCellValueFactory(new PropertyValueFactory<>("dateBeg"));
        dateOutColumn.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
        roomCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        table.setItems(list);
    }
}