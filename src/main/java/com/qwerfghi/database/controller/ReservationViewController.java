package com.qwerfghi.database.controller;

import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.FreeRoom;
import com.qwerfghi.database.model.LayoutController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.qwerfghi.database.Main.connection;


public class ReservationViewController implements FragmentController {
    private LayoutController parent;
    private ObservableList<FreeRoom> list;
    public static String res_select = "";
    private static String date_in = "";
    private static String date_out = "";
    private static int taxi_v = 0;
    private static int cut_v = 0;
    private static int vet_v = 0;
    @FXML
    private ChoiceBox<String> animalName;
    @FXML
    private TableView<FreeRoom> table;
    @FXML
    private TableColumn<FreeRoom, Integer> roomNumColumn;
    @FXML
    private TableColumn<FreeRoom, Integer> roomCostColumn;
    @FXML
    private TableColumn<FreeRoom, String> roomTypeColumn;
    @FXML
    private DatePicker dateInPicker;
    @FXML
    private DatePicker dateOutPicker;
    @FXML
    private CheckBox taxi;
    @FXML
    private CheckBox cut;
    @FXML
    private CheckBox vet_inspection;

    @FXML
    public void initialize() {
        animalName.setItems(FXCollections.observableArrayList(connection.userPets()));
        animalName.getSelectionModel().selectFirst();
    }

    public void OnSearchRoom () {
        connection.roomType(animalName.getValue());
        list = connection.getAllFreeRooms();
        roomNumColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty().asObject());
        roomCostColumn.setCellValueFactory(cellData -> cellData.getValue().roomCostProperty().asObject());
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().roomTypeProperty());
        table.setItems(list);
    }

    public void OnReserve () {
        if (dateInPicker.getValue() != null) {
            date_in = dateInPicker.getValue().toString();
            date_in = date_in.replace("-","");
        }
        if (dateOutPicker.getValue() != null) {
            date_out = dateOutPicker.getValue().toString();
            date_out = date_out.replace("-","");
        }
        if (taxi.isSelected()) {
            taxi_v = 1;
        }
        if (cut.isSelected()) {
            cut_v = 1;
        }
        if (vet_inspection.isSelected()) {
            vet_v = 1;
        }
        connection.addRes(date_in, date_out, taxi_v, cut_v, vet_v, table.getSelectionModel().getSelectedItem().roomNumProperty().getValue(), animalName.getValue());
        OnSearchRoom();
    }
    public void setParent (LayoutController parent) {
        this.parent = parent;
    }

    @Override
    public FragmentController getChild() {
        return null;
    }
}
