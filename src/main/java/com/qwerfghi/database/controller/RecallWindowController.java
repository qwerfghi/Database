package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.entity.RecallEntity;
import com.qwerfghi.database.model.service.GuestService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RecallWindowController {
    private GuestService guestService;

    @FXML
    private TextField emailPicker;

    @FXML
    private ChoiceBox<Integer> markPicker;

    @FXML
    private TextArea recallPicker;

    @FXML
    private void initialize() {
        guestService = Main.getContext().getBean(GuestService.class);
        markPicker.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        markPicker.getSelectionModel().selectFirst();
    }

    @FXML
    private void onRecall() {
        RecallEntity recallEntity = new RecallEntity();
        recallEntity.setEmail(emailPicker.getText());
        recallEntity.setMark(markPicker.getValue());
        recallEntity.setRecall(recallPicker.getText());
        guestService.addRecall(recallEntity);
    }
}