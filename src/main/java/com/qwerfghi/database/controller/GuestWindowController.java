package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.entity.Room;
import com.qwerfghi.database.service.GuestService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GuestWindowController {

    private GuestService guestService;
    private Main main;
    private ObservableList<Room> list;

    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> animalType;
    @FXML
    private TableView<Room> table;
    @FXML
    private TableColumn<Room, Integer> roomNumColumn;
    @FXML
    private TableColumn<Room, String> dateEnterColumn;
    @FXML
    private TableColumn<Room, String> dateOutColumn;
    @FXML
    private TableColumn<Room, Integer> roomCostColumn;


    @FXML
    private void initialize() {
        guestService = Main.getContext().getBean(GuestService.class);
        animalType.setItems(FXCollections.observableArrayList("для собаки", "для кота", "для хомяка", "для черепахи", "для змеи"));
        animalType.getSelectionModel().selectFirst();
    }

    @FXML
    public void onLogin() {
        main.initLogin();
    }

    @FXML
    public void onShow() {
        list = FXCollections.observableList(guestService.getAllFreeRooms(AnimalType.fromCode(animalType.getValue()), Helper.convertLocalDateToDate(datePicker.getValue())));
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        dateEnterColumn.setCellValueFactory(new PropertyValueFactory<>("dateBeg"));
        dateOutColumn.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
        roomCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        table.setItems(list);
    }

    @FXML
    public void onRecall() {
        main.initRecall();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}