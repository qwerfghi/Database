package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OwnerViewController implements FragmentController {
    private LayoutController parent;
    private MyConnection connection;
    private ObservableList<User> list;
    private static String select_d = "0%";

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, Integer> idGuestColumn;
    @FXML
    private TableColumn<User, String> NameColumn;
    @FXML
    private TableColumn<User, String> lNameColumn;
    @FXML
    private TableColumn<User, String> PatronymicColumn;
    @FXML
    private TableColumn<User, String> passNumColumn;
    @FXML
    private TableColumn<User, String> phoneNumColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> discountColumn;
    @FXML
    private TextField addName;
    @FXML
    private TextField addLName;
    @FXML
    private TextField addPatronymic;
    @FXML
    private TextField passNum;
    @FXML
    private TextField phoneNum;
    @FXML
    private TextField Email;
    @FXML
    private ChoiceBox<String> Discount;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getAllUsers();
        idGuestColumn.setCellValueFactory(cellData -> cellData.getValue().idownerProperty().asObject());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        lNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        PatronymicColumn.setCellValueFactory(cellData -> cellData.getValue().patronymicProperty());
        passNumColumn.setCellValueFactory(cellData -> cellData.getValue().passNumProperty());
        phoneNumColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        discountColumn.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
        table.setItems(list);

        Discount.setItems(FXCollections.observableArrayList("0%", "5%", "10%", "20%"));
        Discount.getSelectionModel().selectFirst();
        Discount.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.intValue()){
                case 0:
                    select_d = "0%";
                    break;
                case 1:
                    select_d = "5%";
                    break;
                case 2:
                    select_d = "10%";
                    break;
                case 3:
                    select_d = "20%";
                    break;
            }
        });
    }

    @FXML
    private void OnAddUser () {
        connection.addGuest(addName.getText(), addLName.getText(), addPatronymic.getText(),  passNum.getText(), phoneNum.getText(), Email.getText());
        initialize();
    }

    @FXML
    private void OnDeleteUser () {
        connection.deleteGuest(table.getSelectionModel().getSelectedItem().idownerProperty().getValue());
        initialize();
    }

    @FXML
    private void OnChangeDiscount () {
        connection.updateDis(table.getSelectionModel().getSelectedItem().getIdowner(), select_d);
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