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
import org.springframework.context.ApplicationContext;

public class EmployeeViewController {
    private Main main;
    private ObservableList<StaffEntity> list;
    private static String date;

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
        ApplicationContext ctx = main.getContext();
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
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

    public void OnEmployee () {
        if (eDate.getValue() != null) {
            date = eDate.getValue().toString();
            date = date.replace("-","");
        }
        //connection.addEmployee(eName.getText(), eLName.getText(), ePatronymic.getText(), date, ePosition.getText(), ePassport.getText(), ePhone.getText(), eEmail.getText());
        initialize();
    }

    public void OnDelete () {
        //connection.deleteEmployee(table.getSelectionModel().getSelectedItem().passportProperty().getValue());
        initialize();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}