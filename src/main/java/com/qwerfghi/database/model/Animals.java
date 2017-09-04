package com.qwerfghi.database.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Animals {
    private MyConnection connection;
    private StringProperty animalName, animalType, notice;
    private IntegerProperty age, idOwner;

    public int getIdOwner() {
        return idOwner.get();
    }

    public IntegerProperty idOwnerProperty() {
        return idOwner;
    }

    public MyConnection getConnection() {
        return connection;
    }

    public String getAnimalName() {
        return animalName.get();
    }

    public StringProperty animalNameProperty() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType.get();
    }

    public StringProperty animalTypeProperty() {
        return animalType;
    }

    public String getNotice() {
        return notice.get();
    }

    public StringProperty noticeProperty() {
        return notice;
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }
    Animals (MyConnection connection, int idOwner, String animalName, String animalType, int age, String notice) {
        this.connection = connection;
        this.idOwner = new SimpleIntegerProperty(idOwner);
        this.animalName = new SimpleStringProperty(animalName);
        this.animalType = new SimpleStringProperty(animalType);
        this.age = new SimpleIntegerProperty(age);
        this.notice = new SimpleStringProperty(notice);
    }
}
