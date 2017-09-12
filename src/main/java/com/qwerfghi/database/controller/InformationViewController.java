package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.AddressEntity;
import com.qwerfghi.database.model.entity.AnimalEntity;
import com.qwerfghi.database.model.entity.OwnerEntity;
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
    private TableView<AnimalEntity> table;
    @FXML
    private TableColumn<AnimalEntity, String> animalNameColumn;
    @FXML
    private TableColumn<AnimalEntity, String> animalTypeColumn;
    @FXML
    private TableColumn<AnimalEntity, Integer> ageColumn;
    @FXML
    private TableColumn<AnimalEntity, String> noticeColumn;

    @FXML
    public void initialize() {
        OwnerEntity ownerEntity = Main.getUser().getOwnerEntity();
        name.setText(ownerEntity.getOwnerName());
        lastName.setText(ownerEntity.getOwnerLastName());
        patronymic.setText(ownerEntity.getOwnerPatronymic());
        passNum.setText(ownerEntity.getPassport());
        phoneNum.setText(ownerEntity.getPhoneNum());
        email.setText(ownerEntity.getEmail());
        discount.setText(ownerEntity.getDiscount().getDiscount());
        AddressEntity addressEntity = ownerEntity.getAddress();
        region.setText(addressEntity.getRegion());
        locality.setText(addressEntity.getLocality());
        street.setText(addressEntity.getStreet());
        houseNum.setText(String.valueOf(addressEntity.getHouseNum()));
        apartNum.setText(String.valueOf(addressEntity.getApartmentNum()));
        animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("animalName"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        noticeColumn.setCellValueFactory(new PropertyValueFactory<>("notice"));
        table.setItems(FXCollections.observableArrayList(ownerEntity.getAnimalEntityList()));
    }
}