package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.Information;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class InformationViewController implements FragmentController {
    private LayoutController parent;
    private MyConnection connection;
    private ObservableList<Information> list;

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
    private TableView<Information> table;
    @FXML
    private TableColumn<Information, String> animalNameColumn;
    @FXML
    private TableColumn<Information, String> animalTypeColumn;
    @FXML
    private TableColumn<Information, Integer> ageColumn;
    @FXML
    private TableColumn<Information, String> noticeColumn;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getInformation();
        name.setText(list.get(0).getName());
        lastName.setText(list.get(0).getLastName());
        patronymic.setText(list.get(0).getPatronymic());
        passNum.setText(list.get(0).getPassNum());
        phoneNum.setText(list.get(0).getPhoneNum());
        email.setText(list.get(0).getEmail());
        discount.setText(list.get(0).getDiscount());
        region.setText(list.get(0).getRegion());
        locality.setText(list.get(0).getLocality());
        street.setText(list.get(0).getStreet());
        houseNum.setText(String.valueOf(list.get(0).getHouseNum()));
        apartNum.setText(String.valueOf(list.get(0).getApartNum()));
        animalNameColumn.setCellValueFactory(cellData -> cellData.getValue().animalNameProperty());
        animalTypeColumn.setCellValueFactory(cellData -> cellData.getValue().animalTypeProperty());
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        noticeColumn.setCellValueFactory(cellData -> cellData.getValue().noticeProperty());
        table.setItems(list);
    }

    public void setParent(LayoutController parent) {
        this.parent = parent;
    }


    @Override
    public FragmentController getChild() {
        return null;
    }
}