package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.dao.RoomDAO;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.service.GuestService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class GuestWindowController {

    private Main main;
    private MyConnection connection;
    private ObservableList<RoomEntity> list;
    public static AnimalType select = AnimalType.DOG;
    public static String date = "20961225";

    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> animalType;
    @FXML
    private TableView<RoomEntity> table;
    @FXML
    private TableColumn<RoomEntity, Integer> roomNumColumn;
    @FXML
    private TableColumn<RoomEntity, String> dateEnterColumn;
    @FXML
    private TableColumn<RoomEntity, String> dateOutColumn;
    @FXML
    private TableColumn<RoomEntity, Integer> roomCostColumn;


    @FXML
    private void initialize() {
        animalType.setItems(FXCollections.
                observableArrayList("для собаки", "для кота", "для хомяка", "для черепахи", "для змеи"));
        animalType.getSelectionModel().selectFirst();
        animalType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.intValue()){
                case 0:
                    select = AnimalType.DOG;
                    break;
                case 1:
                    select = AnimalType.CAT;
                    break;
                case 2:
                    select = AnimalType.HAMSTER;
                    break;
                case 3:
                    select = AnimalType.TURTLE;
                    break;
                case 4:
                    select = AnimalType.SNAKE;
                    break;
            }
        });
    }

    @FXML
    public void onLogin (){
        main.initLogin();
    }

    @FXML
    public void onShow(){
        ApplicationContext ctx = main.getContext();
        GuestService guestService = ctx.getBean(GuestService.class);
        list = guestService.getAllFreeRooms(select, convertDate(datePicker.getValue()));
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        dateEnterColumn.setCellValueFactory(new PropertyValueFactory<>("dateBeg"));
        dateOutColumn.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
        roomCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        table.setItems(list);
    }

    @FXML
    public void onRecall(){
        main.initRecall();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private static Date convertDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }
}