package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.Employeer;
import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeViewController implements FragmentController {
    private LayoutController parent;
    private MyConnection connection;
    private ObservableList<Employeer> list;
    private static String date;

    @FXML
    private TableView<Employeer> table;
    @FXML
    private TableColumn<Employeer, String> NameColumn;
    @FXML
    private TableColumn<Employeer, String> lNameColumn;
    @FXML
    private TableColumn<Employeer, String> PatronymicColumn;
    @FXML
    private TableColumn<Employeer, String> DateColumn;
    @FXML
    private TableColumn<Employeer, String> positionColumn;
    @FXML
    private TableColumn<Employeer, String> PassportColumn;
    @FXML
    private TableColumn<Employeer, String> PhoneNumColumn;
    @FXML
    private TableColumn<Employeer, String> EmailColumn;
    @FXML
    private TextField eName;
    @FXML
    private TextField eLName;
    @FXML
    private TextField ePatronymic;
    @FXML
    private TextField ePassport;
    @FXML
    private TextField ePhone;
    @FXML
    private TextField eEmail;
    @FXML
    private TextField ePosition;
    @FXML
    private DatePicker eDate;



    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getAllEmployeers();
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().employee_nameProperty());
        lNameColumn.setCellValueFactory(cellData -> cellData.getValue().employee_last_nameProperty());
        PatronymicColumn.setCellValueFactory(cellData -> cellData.getValue().employee_patronymicProperty());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().daterecProperty());
        positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        PassportColumn.setCellValueFactory(cellData -> cellData.getValue().passportProperty());
        PhoneNumColumn.setCellValueFactory(cellData -> cellData.getValue().phone_numProperty());
        EmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        table.setItems(list);
    }

    public void OnEmployee () {
        if (eDate.getValue() != null) {
            date = eDate.getValue().toString();
            date = date.replace("-","");
        }
        connection.addEmployee(eName.getText(), eLName.getText(), ePatronymic.getText(), date, ePosition.getText(), ePassport.getText(), ePhone.getText(), eEmail.getText());
        initialize();
    }

    public void OnDelete () {
        connection.deleteEmployee(table.getSelectionModel().getSelectedItem().passportProperty().getValue());
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