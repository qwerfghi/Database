package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import javafx.fxml.FXML;

public class LogOnWindowController {
    private Main main;

    @FXML
    public void onLogin (){
        main.initLogin();
    }

    @FXML
    public void onReservation () {
        main.setReservationElement();
    }

    @FXML
    public void onRoom () {
        main.setRoomElement();
    }

    @FXML
    public void onInformation () {
        main.setInformationElement();
    }

    @FXML
    public void onRecall () {
        main.initRecall();
    }

    public void setApp(Main main) {
        this.main = main;
    }
}