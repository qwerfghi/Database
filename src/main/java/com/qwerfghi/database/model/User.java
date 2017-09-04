package com.qwerfghi.database.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private MyConnection connection;
    private StringProperty name, lastName, patronymic, passNum, phoneNum, email, discount;
    private IntegerProperty idowner;

    public MyConnection getConnection() {
        return connection;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic.get();
    }

    public StringProperty patronymicProperty() {
        return patronymic;
    }

    public String getPassNum() {
        return passNum.get();
    }

    public StringProperty passNumProperty() {
        return passNum;
    }

    public String getPhoneNum() {
        return phoneNum.get();
    }

    public StringProperty phoneNumProperty() {
        return phoneNum;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getDiscount() {
        return discount.get();
    }

    public int getIdowner() {
        return idowner.get();
    }

    public IntegerProperty idownerProperty() {
        return idowner;
    }

    public StringProperty discountProperty() {
        return discount;

    }

    User (MyConnection connection, int idowner, String name, String lastName, String patronymic, String passNum, String phoneNum, String email, String discount) {
        this.connection = connection;
        this.idowner = new SimpleIntegerProperty(idowner);
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.patronymic = new SimpleStringProperty(patronymic);
        this.passNum = new SimpleStringProperty(passNum);
        this.phoneNum = new SimpleStringProperty(phoneNum);
        this.email = new SimpleStringProperty(email);
        this.discount = new SimpleStringProperty(discount);
    }
}
