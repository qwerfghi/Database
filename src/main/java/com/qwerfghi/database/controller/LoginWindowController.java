package com.qwerfghi.database.controller;

import com.qwerfghi.database.Main;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.model.dao.DAOFactory;
import com.qwerfghi.database.model.dao.UserDAO;
import com.qwerfghi.database.model.entity.UserEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {

    private MyConnection connection = Main.connection;
    private Main main;

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;


    @FXML
    private void initialize() {
    }

    @FXML
    private void onLogIn() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
        UserDAO userDAO = factory.getUserDAO();
        String username = loginField.getText();
        String password = passwordField.getText();
        if (!username.equals("") || !password.equals("")) {
            UserEntity user = userDAO.getUser(username, password);
            if (user == null) {
                showErrorDialog("Неверный логин или пароль.");
            } else if (user.getPrivilegeEntity().getId() == 1) {
                main.initAdminWindowController();
            } else {
                connection.user = user;
                main.initLogOnViewController();
            }
        } else {
            showErrorDialog("Введите логин и пароль");
        }
    }

    @FXML
    private void onGuest() {
        main.initGuestLayout();
    }

    @FXML
    private void onRegistration() {
        main.initRegisterLayout();
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setMain(Main app) {
        this.main = app;
    }
}