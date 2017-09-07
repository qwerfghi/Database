package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.StaffEntity;
import com.qwerfghi.database.model.service.EmployeeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeViewController {
    private ObservableList<StaffEntity> list;
    private EmployeeService employeeService;

    @FXML
    private TableView<StaffEntity> table;
    @FXML
    private TableColumn<StaffEntity, String> firstNameColumn;
    @FXML
    private TableColumn<StaffEntity, String> lastNameColumn;
    @FXML
    private TableColumn<StaffEntity, String> patronymicColumn;
    @FXML
    private TableColumn<StaffEntity, String> dateColumn;
    @FXML
    private TableColumn<StaffEntity, String> positionColumn;
    @FXML
    private TableColumn<StaffEntity, String> passportColumn;
    @FXML
    private TableColumn<StaffEntity, String> phoneNumColumn;
    @FXML
    private TableColumn<StaffEntity, String> emailColumn;
    @FXML
    private TextField firstNameField;
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
    private TextField positionField;
    @FXML
    private DatePicker datePicker;


    @FXML
    public void initialize() {
        employeeService = Main.getContext().getBean(EmployeeService.class);
        updateTable();
    }

    private void updateTable() {
        list = FXCollections.observableList(employeeService.getAll());
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeLastName"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<>("employeePatronymic"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateRec"));
        passportColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        table.setItems(list);
    }

    public void addEmployee() {
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setEmployeeName(firstNameField.getText());
        staffEntity.setEmployeeLastName(lastNameField.getText());
        staffEntity.setEmployeePatronymic(patronymicField.getText());
        staffEntity.setPassport(passportField.getText());
        staffEntity.setPhoneNum(phoneField.getText());
        staffEntity.setEmail(emailField.getText());
        staffEntity.setPosition(positionField.getText());
        staffEntity.setDateRec(Helper.convertLocalDateToDate(datePicker.getValue()));
        employeeService.add(staffEntity);
        updateTable();
    }

    public void deleteEmployee() {
        employeeService.deleteById(table.selectionModelProperty().get().getSelectedItem().getIdstaff());
        updateTable();
    }
}