package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.MyConnection;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class RecallWindowController {
    private Main main;
    private MyConnection connection;
    private static int mark = 1;
    private static String email = "";
    private static String recall = "";

    @FXML
    private TextField emailPicker;

    @FXML
    private ChoiceBox markPicker;

    @FXML
    private javafx.scene.control.TextArea recallPicker;

    @FXML
    private void initialize() {
        markPicker.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        markPicker.getSelectionModel().selectFirst();
        markPicker.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue.intValue()){
                case 0:
                    mark = 1;
                    break;
                case 1:
                    mark = 2;
                    break;
                case 2:
                    mark = 3;
                    break;
                case 3:
                    mark = 4;
                    break;
                case 4:
                    mark = 5;
                    break;
                case 5:
                    mark = 6;
                    break;
                case 6:
                    mark = 7;
                    break;
                case 7:
                    mark = 8;
                    break;
                case 8:
                    mark = 9;
                    break;
                case 9:
                    mark = 10;
                    break;
            }
        });
    }

    @FXML
    public void onLogin (){
        main.initLogin();
    }

    @FXML
    private void onRecall() {
        connection = Main.connection;
        if (emailPicker.getText()!=null) {
            email = emailPicker.getText();
        }
        if (recallPicker.getText()!=null) {
            recall = recallPicker.getText();
        }
        connection.addRecall(email, mark, recall);
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
