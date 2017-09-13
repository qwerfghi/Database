package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.*;
import com.qwerfghi.database.service.GuestService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegistrationController {
    private Main main;
    private GuestService guestService;
    private Owner owner;

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
        User entity = getUserEntity();
        Owner owner1 = getOwner();
        guestService.addUser(entity, owner1, getAddressEntity());
        Main.setUser(entity);
        owner = owner1;
    }

    private Owner getOwner() {
        Owner owner = new Owner();
        owner.setDiscount(Discount.ZERO);
        owner.setEmail(email.getText());
        owner.setOwnerLastName(lastName.getText());
        owner.setOwnerName(firstName.getText());
        owner.setOwnerPatronymic(patronymic.getText());
        owner.setPassport(passNum.getText());
        owner.setPhoneNum(phoneNum.getText());
        return owner;
    }

    private Address getAddressEntity() {
        Address address = new Address();
        address.setApartmentNum(Short.parseShort(apartmentNum.getText()));
        address.setHouseNum(Byte.parseByte(houseNum.getText()));
        address.setLocality(locality.getText());
        address.setRegion(region.getText());
        address.setStreet(street.getText());
        return address;
    }

    private User getUserEntity() {
        User user = new User();
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
        Animal animal = new Animal();
        animal.setNotice(petNotice.getText());
        animal.setAnimalName(petName.getText());
        animal.setAge(Byte.parseByte(petAge.getText()));
        animal.setAnimalType(AnimalType.fromCode(animalType.getValue()));
        animal.setOwner(owner);
        guestService.addAnimal(animal);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}