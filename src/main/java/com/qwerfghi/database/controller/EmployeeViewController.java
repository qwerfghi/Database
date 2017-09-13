package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.entity.Staff;
import com.qwerfghi.database.service.AdminService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeViewController {
    private ObservableList<Staff> list;
    private AdminService adminService;

    @FXML
    private TableView<Staff> table;
    @FXML
    private TableColumn<Staff, String> firstNameColumn;
    @FXML
    private TableColumn<Staff, String> lastNameColumn;
    @FXML
    private TableColumn<Staff, String> patronymicColumn;
    @FXML
    private TableColumn<Staff, String> dateColumn;
    @FXML
    private TableColumn<Staff, String> positionColumn;
    @FXML
    private TableColumn<Staff, String> passportColumn;
    @FXML
    private TableColumn<Staff, String> phoneNumColumn;
    @FXML
    private TableColumn<Staff, String> emailColumn;
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
        adminService = Main.getContext().getBean(AdminService.class);
        updateTable();
    }

    private void updateTable() {
        list = FXCollections.observableList(adminService.getAllStaff());
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
        Staff staff = new Staff();
        staff.setEmployeeName(firstNameField.getText());
        staff.setEmployeeLastName(lastNameField.getText());
        staff.setEmployeePatronymic(patronymicField.getText());
        staff.setPassport(passportField.getText());
        staff.setPhoneNum(phoneField.getText());
        staff.setEmail(emailField.getText());
        staff.setPosition(positionField.getText());
        staff.setDateRec(Helper.convertLocalDateToDate(datePicker.getValue()));
        adminService.addStaff(staff);
        updateTable();
    }

    public void deleteEmployee() {
        adminService.deleteStaff(table.selectionModelProperty().get().getSelectedItem().getIdstaff());
        updateTable();
    }
}