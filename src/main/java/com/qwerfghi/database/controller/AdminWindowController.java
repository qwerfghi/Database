package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import javafx.fxml.FXML;

public class AdminWindowController {
    private Main main;

    @FXML
    private void onEmployee () {
        main.setEmployeeElement();
    }

    @FXML
    private void OnGuest () {
        main.setOwnerElement();
    }

    @FXML
    private void OnExit () {
        main.initLogin();
    }

    @FXML
    private void OnAnimals () {
        main.setAnimalsElement();
    }

    public void setApp(Main main) {
        this.main = main;
    }
}