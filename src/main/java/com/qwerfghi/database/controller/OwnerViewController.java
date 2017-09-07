package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.entity.OwnerEntity;
import com.qwerfghi.database.model.entity.UserEntity;
import com.qwerfghi.database.model.service.OwnerService;
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
    private OwnerService ownerService;

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
    private ChoiceBox<String> discount;

    @FXML
    public void initialize() {
        ownerService = Main.getContext().getBean(OwnerService.class);
        discount.setItems(FXCollections.observableArrayList("0%", "5%", "10%", "20%"));
        discount.getSelectionModel().selectFirst();
        updateTable();
        //discount.getSelectionModel().getSelectedItem();
    }

    private void updateTable() {
        list = FXCollections.observableArrayList(ownerService.getAll());
        idGuestColumn.setCellValueFactory(new PropertyValueFactory<>("idowner"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("ownerLastName"));
        PatronymicColumn.setCellValueFactory(new PropertyValueFactory<>("ownerPatronymic"));
        passNumColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
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
        //connection.updateDis(table.getSelectionModel().getSelectedItem().getIdowner(), select_d);

        updateTable();
    }
}