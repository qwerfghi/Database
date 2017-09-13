package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.entity.RoomEntity;
import com.qwerfghi.database.model.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationViewController {
    private UserService userService;
    private ObservableList<RoomEntity> list;
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
        list = FXCollections.observableList(userService.getAllFreeRooms(getAnimal().getAnimalType()));
        roomNumColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        roomCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        table.setItems(list);
    }

    public void reserveRoom() {
        RoomEntity roomEntity = table.getSelectionModel().getSelectedItem();
        roomEntity.setDateBeg(Helper.convertLocalDateToDate(dateInPicker.getValue()));
        roomEntity.setDateEnd(Helper.convertLocalDateToDate(dateOutPicker.getValue()));
        AnimalEntity animalEntity = getAnimal();
        animalEntity.setCut(cut.isSelected());
        animalEntity.setVetInspection(vet_inspection.isSelected());
        animalEntity.setZootaxi(taxi.isSelected());
        userService.reserveRoom(roomEntity, animalEntity);
        searchRoom();
    }

    private AnimalEntity getAnimal() {
        return animals.stream()
                .filter(animalEntity -> animalEntity.getAnimalName().equals(animalName.getValue()))
                .findFirst()
                .orElse(new AnimalEntity());
    }
}