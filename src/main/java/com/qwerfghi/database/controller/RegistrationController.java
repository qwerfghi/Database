package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.*;
import com.qwerfghi.database.model.service.GuestService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegistrationController {
    private Main main;
    private GuestService guestService;
    private OwnerEntity ownerEntity;

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField_1;
    @FXML
    private PasswordField passwordField_2;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField patronymic;
    @FXML
    private TextField passNum;
    @FXML
    private TextField phoneNum;
    @FXML
    private TextField email;
    @FXML
    private TextField region;
    @FXML
    private TextField locality;
    @FXML
    private TextField street;
    @FXML
    private TextField houseNum;
    @FXML
    private TextField apartmentNum;
    @FXML
    private TextField petName;
    @FXML
    private TextField petAge;
    @FXML
    private TextArea petNotice;
    @FXML
    private ChoiceBox<String> animalType;

    @FXML
    private void initialize() {
        guestService = Main.getContext().getBean(GuestService.class);
        animalType.setItems(FXCollections.observableArrayList("собака", "кот", "хомяк", "черепаха", "змея"));
        animalType.getSelectionModel().selectFirst();
    }

    @FXML
    private void onRegistration() {
        UserEntity entity = getUserEntity();
        OwnerEntity ownerEntity1 = getOwnerEntity();
        guestService.addUser(entity, ownerEntity1, getAddressEntity());
        Main.setUser(entity);
        ownerEntity = ownerEntity1;
    }

    private OwnerEntity getOwnerEntity() {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setDiscount(Discount.ZERO);
        ownerEntity.setEmail(email.getText());
        ownerEntity.setOwnerLastName(lastName.getText());
        ownerEntity.setOwnerName(firstName.getText());
        ownerEntity.setOwnerPatronymic(patronymic.getText());
        ownerEntity.setPassport(passNum.getText());
        ownerEntity.setPhoneNum(phoneNum.getText());
        return ownerEntity;
    }

    private AddressEntity getAddressEntity() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setApartmentNum(Short.parseShort(apartmentNum.getText()));
        addressEntity.setHouseNum(Byte.parseByte(houseNum.getText()));
        addressEntity.setLocality(locality.getText());
        addressEntity.setRegion(region.getText());
        addressEntity.setStreet(street.getText());
        return addressEntity;
    }

    private UserEntity getUserEntity() {
        UserEntity user = new UserEntity();
        user.setUsername(loginField.getText());
        user.setPassword(passwordField_1.getText());
        return user;
    }

    @FXML
    private void onLogIn() {
        main.initLogin();
    }

    @FXML
    private void onPet() {
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setNotice(petNotice.getText());
        animalEntity.setAnimalName(petName.getText());
        animalEntity.setAge(Byte.parseByte(petAge.getText()));
        animalEntity.setAnimalType(AnimalType.fromCode(animalType.getValue()));
        animalEntity.setOwner(ownerEntity);
        guestService.addAnimal(animalEntity);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}