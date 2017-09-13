package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.qwerfghi.database.Main.connection;

public class ReservationViewController {
    private UserService userService;
    private ObservableList<RoomEntity> list;
    private static String date_in = "";
    private static String date_out = "";
    private static int taxi_v = 0;
    private static int cut_v = 0;
    private static int vet_v = 0;
    private List<AnimalEntity> animals;

    @FXML
    private ChoiceBox<String> animalName;
    @FXML
    private TableView<RoomEntity> table;
    @FXML
    private TableColumn<RoomEntity, Integer> roomNumColumn;
    @FXML
    private TableColumn<RoomEntity, Integer> roomCostColumn;
    @FXML
    private TableColumn<RoomEntity, String> roomTypeColumn;
    @FXML
    private DatePicker dateInPicker;
    @FXML
    private DatePicker dateOutPicker;
    @FXML
    private CheckBox taxi;
    @FXML
    private CheckBox cut;
    @FXML
    private CheckBox vet_inspection;

    @FXML
    public void initialize() {
        userService = Main.getContext().getBean(UserService.class);
        animals = Main.getUser().getOwnerEntity().getAnimalEntityList();
        animalName.setItems(FXCollections.observableArrayList(animals
                .stream()
                .map(AnimalEntity::getAnimalName)
                .collect(Collectors.toList())));
        animalName.getSelectionModel().selectFirst();
    }

    public void searchRoom() {
        connection.roomType(animalName.getValue());
        list =  FXCollections.observableList(userService.getAllFreeRooms(getAnimalType())) ;
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        roomCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        table.setItems(list);
    }

    public void reserveRoom() {
        if (dateInPicker.getValue() != null) {
            date_in = dateInPicker.getValue().toString();
            date_in = date_in.replace("-", "");
        }
        if (dateOutPicker.getValue() != null) {
            date_out = dateOutPicker.getValue().toString();
            date_out = date_out.replace("-", "");
        }
        if (taxi.isSelected()) {
            taxi_v = 1;
        }
        if (cut.isSelected()) {
            cut_v = 1;
        }
        if (vet_inspection.isSelected()) {
            vet_v = 1;
        }
        //connection.addRes(date_in, date_out, taxi_v, cut_v, vet_v, table.getSelectionModel().getSelectedItem().roomNumProperty().getValue(), animalName.getValue());
        searchRoom();
    }

    private AnimalType getAnimalType() {
        return animals.stream()
                .filter(animalEntity -> animalEntity.getAnimalName()
                        .equals(animalName.getValue()))
                .findFirst()
                .orElse(new AnimalEntity())
                .getAnimalType();
    }
}