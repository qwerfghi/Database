package com.qwerfghi.database;

import com.qwerfghi.database.controller.*;
import com.qwerfghi.database.entity.User;
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

    private Stage stage;
    private BorderPane root;
    private static User user;
    private static ApplicationContext context;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Main.user = user;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Base");
        context = new GenericXmlApplicationContext("classpath:root-context.xml");
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
        launch();
    }

    public void initRegisterLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/register_window.fxml"));
            root = loader.load();

            RegistrationController controller = loader.getController();
            controller.setMain(this);

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

    public void setReservationElement() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/reservation_view.fxml"));
            BorderPane element = loader.load();
            root.setCenter(element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRoomElement() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/room_view.fxml"));
            BorderPane element = loader.load();
            root.setCenter(element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setInformationElement() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/information_view.fxml"));
            BorderPane element = loader.load();
            root.setCenter(element);
        } catch (IOException e) {
            e.printStackTrace();
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

    public void setEmployeeElement() {
        try {
            root.setCenter(FXMLLoader.load(getURL("view/employee_view.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setOwnerElement() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/owner_view.fxml"));
            BorderPane element = loader.load();
            root.setCenter(element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAnimalsElement() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getURL("view/animal_view.fxml"));
            BorderPane element = loader.load();
            root.setCenter(element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ApplicationContext getContext() {
        return context;
    }

    private URL getURL (String path) {
        return getClass().getClassLoader().getResource(path);
    }
}