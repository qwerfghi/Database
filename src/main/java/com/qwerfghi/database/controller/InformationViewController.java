package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.Address;
import com.qwerfghi.database.entity.Animal;
import com.qwerfghi.database.entity.Owner;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InformationViewController{

    @FXML
    private Label name;
    @FXML
    private Label lastName;
    @FXML
    private Label patronymic;
    @FXML
    private Label passNum;
    @FXML
    private Label phoneNum;
    @FXML
    private Label email;
    @FXML
    private Label discount;
    @FXML
    private Label region;
    @FXML
    private Label locality;
    @FXML
    private Label street;
    @FXML
    private Label houseNum;
    @FXML
    private Label apartNum;
    @FXML
    private TableView<Animal> table;
    @FXML
    private TableColumn<Animal, String> animalNameColumn;
    @FXML
    private TableColumn<Animal, String> animalTypeColumn;
    @FXML
    private TableColumn<Animal, Integer> ageColumn;
    @FXML
    private TableColumn<Animal, String> noticeColumn;

    @FXML
    public void initialize() {
        Owner owner = Main.getUser().getOwner();
        name.setText(owner.getOwnerName());
        lastName.setText(owner.getOwnerLastName());
        patronymic.setText(owner.getOwnerPatronymic());
        passNum.setText(owner.getPassport());
        phoneNum.setText(owner.getPhoneNum());
        email.setText(owner.getEmail());
        discount.setText(owner.getDiscount().getDiscount());
        Address address = owner.getAddress();
        region.setText(address.getRegion());
        locality.setText(address.getLocality());
        street.setText(address.getStreet());
        houseNum.setText(String.valueOf(address.getHouseNum()));
        apartNum.setText(String.valueOf(address.getApartmentNum()));
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        noticeColumn.setCellValueFactory(new PropertyValueFactory<>("notice"));
        table.setItems(FXCollections.observableArrayList(owner.getAnimalList()));
    }
}