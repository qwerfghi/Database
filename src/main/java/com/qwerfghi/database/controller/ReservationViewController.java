package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.Animal;
import com.qwerfghi.database.entity.Room;
import com.qwerfghi.database.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationViewController {
    private UserService userService;
    private ObservableList<Room> list;
    private List<Animal> animals;

    @FXML
    private ChoiceBox<String> animalName;
    @FXML
    private TableView<Room> table;
    @FXML
    private TableColumn<Room, Integer> roomNumColumn;
    @FXML
    private TableColumn<Room, Integer> roomCostColumn;
    @FXML
    private TableColumn<Room, String> roomTypeColumn;
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
        animals = Main.getUser().getOwner().getAnimalList();
        animalName.setItems(FXCollections.observableArrayList(animals
                .stream()
                .map(Animal::getAnimalName)
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
        Room room = table.getSelectionModel().getSelectedItem();
        room.setDateBeg(Helper.convertLocalDateToDate(dateInPicker.getValue()));
        room.setDateEnd(Helper.convertLocalDateToDate(dateOutPicker.getValue()));
        Animal animal = getAnimal();
        animal.setCut(cut.isSelected());
        animal.setVetInspection(vet_inspection.isSelected());
        animal.setZootaxi(taxi.isSelected());
        userService.reserveRoom(room, animal);
        searchRoom();
    }

    private Animal getAnimal() {
        return animals.stream()
                .filter(animalEntity -> animalEntity.getAnimalName().equals(animalName.getValue()))
                .findFirst()
                .orElse(new Animal());
    }
}