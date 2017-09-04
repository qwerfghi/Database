package com.qwerfghi.database.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employeer {
    private MyConnection connection;
    private StringProperty employee_name;
    private StringProperty employee_last_name;
    private StringProperty employee_patronymic;
    private StringProperty daterec;
    private StringProperty position;
    private StringProperty passport;

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    private StringProperty phone_num;
    private StringProperty email;

    public MyConnection getConnection() {
        return connection;
    }

    public String getEmployee_name() {
        return employee_name.get();
    }

    public StringProperty employee_nameProperty() {
        return employee_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name.get();
    }

    public StringProperty employee_last_nameProperty() {
        return employee_last_name;
    }

    public String getEmployee_patronymic() {
        return employee_patronymic.get();
    }

    public StringProperty employee_patronymicProperty() {
        return employee_patronymic;
    }

    public String getDaterec() {
        return daterec.get();
    }

    public StringProperty daterecProperty() {
        return daterec;
    }

    public String getPassport() {
        return passport.get();
    }

    public StringProperty passportProperty() {
        return passport;
    }

    public String getPhone_num() {
        return phone_num.get();
    }

    public StringProperty phone_numProperty() {
        return phone_num;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    Employeer (MyConnection connection, String employee_name, String employee_last_name, String employee_patronymic, String daterec, String position, String passport, String phone_num, String email) {
        this.connection = connection;
        this.employee_name = new SimpleStringProperty(employee_name);
        this.employee_last_name = new SimpleStringProperty(employee_last_name);
        this.employee_patronymic = new SimpleStringProperty(employee_patronymic);
        this.daterec = new SimpleStringProperty(daterec);
        this.position = new SimpleStringProperty(position);
        this.passport = new SimpleStringProperty(passport);
        this.phone_num = new SimpleStringProperty(phone_num);
        this.email = new SimpleStringProperty(email);
    }
}
