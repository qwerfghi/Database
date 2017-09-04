package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.Animals;
import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AnimalViewController implements FragmentController {

    private LayoutController parent;
    private MyConnection connection;
    private ObservableList<Animals> list;
    public static String select_pet1 = "Собака";

    @FXML
    private TableView<Animals> table;
    @FXML
    private TableColumn<Animals, Integer> idOwnerColumn;
    @FXML
    private TableColumn<Animals, String> animalNameColumn;
    @FXML
    private TableColumn<Animals, String> animalTypeColumn;
    @FXML
    private TableColumn<Animals, Integer> animalAgeColumn;
    @FXML
    private TableColumn<Animals, String> noticeColumn;
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
        connection = Main.connection;
        list = connection.getAllAnimals();
        idOwnerColumn.setCellValueFactory(cellData -> cellData.getValue().idOwnerProperty().asObject());
        animalNameColumn.setCellValueFactory(cellData -> cellData.getValue().animalNameProperty());
        animalTypeColumn.setCellValueFactory(cellData -> cellData.getValue().animalTypeProperty());
        animalAgeColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        noticeColumn.setCellValueFactory(cellData -> cellData.getValue().noticeProperty());
        table.setItems(list);
        animalType.setItems(FXCollections.
                observableArrayList("Собака", "Кот", "Хомяк", "Черепаха", "Змея"));
        animalType.getSelectionModel().selectFirst();
        animalType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.intValue()){
                case 0:
                    select_pet1 = "собака";
                    break;
                case 1:
                    select_pet1 = "кот";
                    break;
                case 2:
                    select_pet1 = "хомяк";
                    break;
                case 3:
                    select_pet1 = "черепаха";
                    break;
                case 4:
                    select_pet1 = "змея";
                    break;
            }
        });
    }

    @FXML
    private void onAddAnimal () {
        connection.addPet(Integer.parseInt(idOwner.getText()), animalName.getText(), animalType.getValue(), Integer.parseInt(animalAge.getText()), notice.getText());
        initialize();
    }

    @FXML
    private void onDeleteAnimal () {
        connection.deletePet(table.getSelectionModel().getSelectedItem().idOwnerProperty().getValue(), table.getSelectionModel().getSelectedItem().animalNameProperty().getValue(), table.getSelectionModel().getSelectedItem().animalTypeProperty().getValue(), table.getSelectionModel().getSelectedItem().ageProperty().getValue());
        initialize();
    }

    public void setParent(LayoutController parent) {
        this.parent = parent;
    }

    @Override
    public FragmentController getChild() {
        return null;
    }
}
