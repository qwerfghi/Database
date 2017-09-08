package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.entity.AnimalType;
import com.qwerfghi.database.model.service.AdminService;
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
    private ObservableList<AnimalEntity> list;

    @FXML
    private TableView<AnimalEntity> table;
    @FXML
    private TableColumn<AnimalEntity, Integer> idOwnerColumn;
    @FXML
    private TableColumn<AnimalEntity, String> animalNameColumn;
    @FXML
    private TableColumn<AnimalEntity, String> animalTypeColumn;
    @FXML
    private TableColumn<AnimalEntity, Integer> animalAgeColumn;
    @FXML
    private TableColumn<AnimalEntity, String> noticeColumn;
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
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setOwner(adminService.getOwnerById(Integer.parseInt(idOwner.getText())));
        animalEntity.setAge(Byte.parseByte(animalAge.getText()));
        animalEntity.setAnimalName(animalName.getText());
        animalEntity.setAnimalType(AnimalType.fromCode(animalType.getValue()));
        animalEntity.setNotice(notice.getText());
        adminService.addAnimal(animalEntity);
        updateTable();
    }

    @FXML
    private void onDeleteAnimal () {
        adminService.deleteAnimal(table.getSelectionModel().getSelectedItem().getIdanimal());
        updateTable();
    }
}