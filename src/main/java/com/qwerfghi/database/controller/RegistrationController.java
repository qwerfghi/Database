package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.dao.*;
import com.qwerfghi.database.model.entity.AddressEntity;
import com.qwerfghi.database.model.entity.Discount;
import com.qwerfghi.database.model.entity.OwnerEntity;
import com.qwerfghi.database.model.entity.UserEntity;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationController {

    private MyConnection connection;
    private Main app;
    public static String select_pet = "Собака";

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
        connection = Main.connection;
        animalType.setItems(FXCollections.
                observableArrayList("Собака", "Кот", "Хомяк", "Черепаха", "Змея"));
        animalType.getSelectionModel().selectFirst();
        animalType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.intValue()) {
                case 0:
                    select_pet = "собака";
                    break;
                case 1:
                    select_pet = "кот";
                    break;
                case 2:
                    select_pet = "хомяк";
                    break;
                case 3:
                    select_pet = "черепаха";
                    break;
                case 4:
                    select_pet = "змея";
                    break;
            }
        });
    }

    @FXML
    private void onRegistration() {
//        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
//        PrivilegeDAO privilegeDAO = factory.getPrivilegeDAO();
//        OwnerDAO ownerDAO = factory.getOwnerDAO();
//        ownerDAO.add(getOwnerEntity(privilegeDAO));
    }

    private OwnerEntity getOwnerEntity(PrivilegeDAO privilegeDAO) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setDiscount(Discount.ZERO);
        ownerEntity.setEmail(email.getText());
        ownerEntity.setOwnerLastName(lastName.getText());
        ownerEntity.setOwnerName(firstName.getText());
        ownerEntity.setOwnerPatronymic(patronymic.getText());
        ownerEntity.setPassport(passNum.getText());
        ownerEntity.setPhoneNum(phoneNum.getText());
        ownerEntity.setAddress(getAddressEntity());
        ownerEntity.setUser(getUserEntity(privilegeDAO));
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

    private UserEntity getUserEntity(PrivilegeDAO privilegeDAO) {
        UserEntity user = new UserEntity();
        user.setUsername(loginField.getText());
        user.setPassword(passwordField_1.getText());
        user.setPrivilegeEntity(privilegeDAO.getUserPrivilege());
        return user;
    }

    @FXML
    private void onLogIn() {
        app.initLogin();
    }

    @FXML
    private void onPet() {
        String petN = petName.getText();
        if (petN.equals("")) petN = "NULL";
        else petN = "\'" + petN + "\'";
        if (select_pet.equals("")) select_pet = "NULL";
        else select_pet = "\'" + select_pet + "\'";
        if (connection.addPet(petN, select_pet, Integer.parseInt(petAge.getText()), petNotice.getText())) {
            showDialog("Животное добавлено.", Alert.AlertType.INFORMATION);
        }
    }

    public void setApp(Main app) {
        this.app = app;
    }

    private void showDialog(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}