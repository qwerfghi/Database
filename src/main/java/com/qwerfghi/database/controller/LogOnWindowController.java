package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.LayoutController;
import javafx.fxml.FXML;

public class LogOnWindowController implements LayoutController {
    private Main main;
    @FXML
    private void initialize() {

    }

    @FXML
    public void onLogin (){
        main.initLogin();
    }

    @FXML
    public void onReservation () {
        main.setReservationElement(this);
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

    @Override
    public Main getApp() {
        return main;
    }
}
