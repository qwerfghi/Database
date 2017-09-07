package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.Animals;
import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.service.AnimalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AnimalViewController {
    private AnimalService animalService;
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
        animalService = Main.getContext().getBean(AnimalService.class);
        list = FXCollections.observableArrayList(animalService.getAll());
        idOwnerColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        animalAgeColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        noticeColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        table.setItems(list);
        animalType.setItems(FXCollections.observableArrayList("Собака", "Кот", "Хомяк", "Черепаха", "Змея"));
        animalType.getSelectionModel().selectFirst();
    }

    @FXML
    private void onAddAnimal () {
        //connection.addPet(Integer.parseInt(idOwner.getText()), animalName.getText(), animalType.getValue(), Integer.parseInt(animalAge.getText()), notice.getText());
        initialize();
    }

    @FXML
    private void onDeleteAnimal () {
        //connection.deletePet(table.getSelectionModel().getSelectedItem().idOwnerProperty().getValue(), table.getSelectionModel().getSelectedItem().animalNameProperty().getValue(), table.getSelectionModel().getSelectedItem().animalTypeProperty().getValue(), table.getSelectionModel().getSelectedItem().ageProperty().getValue());
        initialize();
    }
}