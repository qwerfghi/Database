package com.qwerfghi.database;

import com.qwerfghi.database.model.FragmentController;
import com.qwerfghi.database.model.LayoutController;
import com.qwerfghi.database.model.MyConnection;
import com.qwerfghi.database.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static MyConnection connection;
    private Stage stage;
    private BorderPane root;
    private ApplicationContext context;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Base");
        this.context = new GenericXmlApplicationContext("classpath:root-context.xml");
        initLogin();
    }

    public void initGuestLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/guest_window.fxml"));
            root = loader.load();
            GuestWindowController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL url = getClass().getClassLoader().getResource("view/login_window.fxml");
            loader.setLocation(url);
            root = loader.load();
            LoginWindowController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initRecall() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/recall_window.fxml"));
            root = loader.load();
            Stage dialog = new Stage();
            dialog.setTitle("Оставить отзыв");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(stage);
            dialog.setScene(new Scene(root));
            dialog.setResizable(false);
            RecallWindowController controller = loader.getController();
            dialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        connection = new MyConnection();
        connection.connect();
        launch();
    }

    public void initRegisterLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/register_window.fxml"));
            root = loader.load();

            RegistrationController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initLogOnViewController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/logon_view.fxml"));
            root = loader.load();

            LogOnWindowController controller = loader.getController();
            controller.setApp(this);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FragmentController setReservationElement(LayoutController parent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/reservation_view.fxml"));
            BorderPane element = loader.load();
            ReservationViewController controller = loader.getController();
            controller.setParent(parent);
            root.setCenter(element);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public FragmentController setRoomElement(LayoutController parent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/room_view.fxml"));
            BorderPane element = loader.load();
            RoomViewController controller = loader.getController();
            controller.setParent(parent);
            root.setCenter(element);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public FragmentController setInformationElement(LayoutController parent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/information_view.fxml"));
            BorderPane element = loader.load();
            InformationViewController controller = loader.getController();
            controller.setParent(parent);
            root.setCenter(element);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initAdminWindowController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/admin_window.fxml"));
            root = loader.load();
            AdminWindowController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FragmentController setEmployeeElement(LayoutController parent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/employee_view.fxml"));
            BorderPane element = loader.load();
            EmployeeViewController controller = loader.getController();
            controller.setParent(parent);
            root.setCenter(element);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FragmentController setOwnerElement(LayoutController parent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/owner_view.fxml"));
            BorderPane element = loader.load();
            OwnerViewController controller = loader.getController();
            controller.setParent(parent);
            root.setCenter(element);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FragmentController setAnimalsElement(LayoutController parent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/animal_view.fxml"));
            BorderPane element = loader.load();
            AnimalViewController controller = loader.getController();
            controller.setParent(parent);
            root.setCenter(element);
            return controller;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ApplicationContext getContext() {
        return context;
    }
}