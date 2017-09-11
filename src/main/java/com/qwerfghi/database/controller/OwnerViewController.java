package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.Discount;
import com.qwerfghi.database.model.entity.OwnerEntity;
import com.qwerfghi.database.model.service.AdminService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OwnerViewController {
    private ObservableList<OwnerEntity> list;
    private AdminService adminService;

    @FXML
    private TableView<OwnerEntity> table;
    @FXML
    private TableColumn<OwnerEntity, Integer> idGuestColumn;
    @FXML
    private TableColumn<OwnerEntity, String> NameColumn;
    @FXML
    private TableColumn<OwnerEntity, String> lNameColumn;
    @FXML
    private TableColumn<OwnerEntity, String> PatronymicColumn;
    @FXML
    private TableColumn<OwnerEntity, String> passNumColumn;
    @FXML
    private TableColumn<OwnerEntity, String> phoneNumColumn;
    @FXML
    private TableColumn<OwnerEntity, String> emailColumn;
    @FXML
    private TableColumn<OwnerEntity, String> discountColumn;
    @FXML
    private TableColumn<OwnerEntity, String> regionColumn;
    @FXML
    private TableColumn<OwnerEntity, String> localityColumn;
    @FXML
    private TableColumn<OwnerEntity, String> streetColumn;
    @FXML
    private TableColumn<OwnerEntity, String> houseNumberColumn;
    @FXML
    private TableColumn<OwnerEntity, String> apartmentNumberColumn;
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
        regionColumn.setCellValueFactory(new PropertyValueFactory<>("addresswsfg"));
        table.setItems(list);
    }

    @FXML
    private void OnAddUser () {

        //connection.addGuest(nameField.getText(), lastNameField.getText(), patronymicField.getText(),  passportField.getText(), phoneField.getText(), emailField.getText());
        updateTable();
    }

    @FXML
    private void OnDeleteUser () {
        //connection.deleteGuest(table.getSelectionModel().getSelectedItem().idownerProperty().getValue());
        updateTable();
    }

    @FXML
    private void OnChangeDiscount () {
        int id = table.getSelectionModel().getSelectedItem().getIdowner();
        Discount currentDiscount = Discount.fromCode(this.discount.getSelectionModel().getSelectedItem());
        adminService.changeDiscount(id , currentDiscount);
        updateTable();
    }
}