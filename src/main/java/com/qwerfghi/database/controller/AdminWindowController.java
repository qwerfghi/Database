package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import javafx.fxml.FXML;


public class AdminWindowController implements LayoutController {
    private Main main;
    private MyConnection connection;

    @FXML
    private void initialize() {

    }

    @FXML
    private void onEmployee () {
        main.setEmployeeElement(this);
    }

    @FXML
    private void OnGuest () {
        main.setOwnerElement(this);
    }

    @FXML
    private void OnExit () {
        main.initLogin();
    }

    @FXML
    private void OnAnimals () {
        main.setAnimalsElement(this);
    }

    public void setApp(Main main) {
        this.main = main;
    }

    @Override
    public Main getApp() {
        return main;
    }
}