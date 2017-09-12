package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RoomViewController {

    private UserService userService;

    @FXML
    private TableView<RoomEntity> table;
    @FXML
    private TableColumn<RoomEntity, Integer> roomNumColumn;
    @FXML
    private TableColumn<RoomEntity, String> roomTypeColumn;
    @FXML
    private TableColumn<RoomEntity, String> dateEnterColumn;
    @FXML
    private TableColumn<RoomEntity, String> dateOutColumn;
    @FXML
    private TableColumn<RoomEntity, Integer> roomCostColumn;

    private ObservableList<RoomEntity> list;

    @FXML
    public void initialize() {
        userService = Main.getContext().getBean(UserService.class);
        list = FXCollections.observableArrayList(userService.getAllFreeRooms(AnimalType.DOG));
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        dateEnterColumn.setCellValueFactory(new PropertyValueFactory<>("dateBeg"));
        dateOutColumn.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
        roomCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        table.setItems(list);
    }
}
