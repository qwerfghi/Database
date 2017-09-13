package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.Animal;
import com.qwerfghi.database.entity.AnimalType;
import com.qwerfghi.database.service.AdminService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AnimalViewController {
    private AdminService adminService;
    private ObservableList<Animal> list;

    @FXML
    private TableView<Animal> table;
    @FXML
    private TableColumn<Animal, Integer> idOwnerColumn;
    @FXML
    private TableColumn<Animal, String> animalNameColumn;
    @FXML
    private TableColumn<Animal, String> animalTypeColumn;
    @FXML
    private TableColumn<Animal, Integer> animalAgeColumn;
    @FXML
    private TableColumn<Animal, String> noticeColumn;
    @FXML
    private TextField idOwner;
    @FXML
    private TextField animalName;
    @FXML
    private ChoiceBox<String> animalType;
    @FXML
    private TextField animalAge;
    @FXML
    private TextField notice;

    @FXML
    public void initialize() {
        adminService = Main.getContext().getBean(AdminService.class);
        animalType.setItems(FXCollections.observableArrayList("собака", "кот", "хомяк", "черепаха", "змея"));
        animalType.getSelectionModel().selectFirst();
        updateTable();
    }

    private void updateTable() {
        list = FXCollections.observableArrayList(adminService.getAllAnimals());
        idOwnerColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        animalAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        noticeColumn.setCellValueFactory(new PropertyValueFactory<>("notice"));
        table.setItems(list);
    }

    @FXML
    private void onAddAnimal () {
        Animal animal = new Animal();
        animal.setAge(Byte.parseByte(animalAge.getText()));
        animal.setAnimalName(animalName.getText());
        animal.setAnimalType(AnimalType.fromCode(animalType.getValue()));
        animal.setNotice(notice.getText());
        adminService.addAnimal(animal, Integer.parseInt(idOwner.getText()));
        updateTable();
    }

    @FXML
    private void onDeleteAnimal () {
        adminService.deleteAnimal(table.getSelectionModel().getSelectedItem().getIdanimal());
        updateTable();
    }
}