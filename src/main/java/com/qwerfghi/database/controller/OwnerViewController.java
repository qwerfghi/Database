package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.Address;
import com.qwerfghi.database.entity.Discount;
import com.qwerfghi.database.entity.Owner;
import com.qwerfghi.database.service.AdminService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OwnerViewController {
    private ObservableList<Owner> list;
    private AdminService adminService;

    @FXML
    private TableView<Owner> table;
    @FXML
    private TableColumn<Owner, Integer> idGuestColumn;
    @FXML
    private TableColumn<Owner, String> NameColumn;
    @FXML
    private TableColumn<Owner, String> lNameColumn;
    @FXML
    private TableColumn<Owner, String> PatronymicColumn;
    @FXML
    private TableColumn<Owner, String> passNumColumn;
    @FXML
    private TableColumn<Owner, String> phoneNumColumn;
    @FXML
    private TableColumn<Owner, String> emailColumn;
    @FXML
    private TableColumn<Owner, String> discountColumn;
    @FXML
    private TableColumn<Owner, String> regionColumn;
    @FXML
    private TableColumn<Owner, String> localityColumn;
    @FXML
    private TableColumn<Owner, String> streetColumn;
    @FXML
    private TableColumn<Owner, String> houseNumberColumn;
    @FXML
    private TableColumn<Owner, String> apartmentNumberColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField patronymicField;
    @FXML
    private TextField passportField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField region;
    @FXML
    private TextField locality;
    @FXML
    private TextField street;
    @FXML
    private TextField houseNumber;
    @FXML
    private TextField apartmentNumber;
    @FXML
    private ChoiceBox<String> discount;

    @FXML
    public void initialize() {
        adminService = Main.getContext().getBean(AdminService.class);
        discount.setItems(FXCollections.observableArrayList("0%", "5%", "10%", "20%"));
        discount.getSelectionModel().selectFirst();
        updateTable();
    }

    private void updateTable() {
        list = FXCollections.observableArrayList(adminService.getAllOwners());
        idGuestColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("ownerLastName"));
        PatronymicColumn.setCellValueFactory(new PropertyValueFactory<>("ownerPatronymic"));
        passNumColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        localityColumn.setCellValueFactory(new PropertyValueFactory<>("locality"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        houseNumberColumn.setCellValueFactory(new PropertyValueFactory<>("houseNum"));
        apartmentNumberColumn.setCellValueFactory(new PropertyValueFactory<>("apartmentNum"));
        table.setItems(list);
    }

    @FXML
    private void addUser() {
        Address address = new Address();
        address.setStreet(street.getText());
        address.setRegion(region.getText());
        address.setLocality(locality.getText());
        address.setApartmentNum(Integer.parseInt(apartmentNumber.getText()));
        address.setHouseNum(Integer.parseInt(houseNumber.getText()));
        Owner owner = new Owner();
        owner.setPhoneNum(phoneField.getText());
        owner.setPassport(passportField.getText());
        owner.setOwnerPatronymic(patronymicField.getText());
        owner.setOwnerName(nameField.getText());
        owner.setOwnerLastName(lastNameField.getText());
        owner.setEmail(emailField.getText());
        owner.setDiscount(Discount.fromCode(discount.getValue()));
        adminService.addOwner(owner, address);
        updateTable();
    }

    @FXML
    private void deleteUser() {
        adminService.deleteOwner(table.getSelectionModel().getSelectedItem().getIdowner());
        updateTable();
    }

    @FXML
    private void changeDiscount() {
        int id = table.getSelectionModel().getSelectedItem().getIdowner();
        Discount currentDiscount = Discount.fromCode(this.discount.getSelectionModel().getSelectedItem());
        adminService.changeDiscount(id, currentDiscount);
        updateTable();
    }
}