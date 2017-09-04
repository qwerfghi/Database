package com.qwerfghi.database.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Information {
    private MyConnection connection;
    private StringProperty name, lastName, patronymic, passNum, phoneNum, email, discount, region, locality, street, animalName, animalType, notice;
    private IntegerProperty houseNum, apartNum, age;

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

    public MyConnection getConnection() {
        return connection;
    }

    public  String getName() {
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

    public StringProperty discountProperty() {
        return discount;
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public String getLocality() {
        return locality.get();
    }

    public StringProperty localityProperty() {
        return locality;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getHouseNum() {
        return houseNum.get();
    }

    public IntegerProperty houseNumProperty() {
        return houseNum;
    }

    public int getApartNum() {
        return apartNum.get();
    }

    public IntegerProperty apartNumProperty() {
        return apartNum;
    }

    Information (MyConnection connection, String name, String lastName, String patronymic, String passNum, String phoneNum, String email, String discount, String region, String locality, String street, int houseNum, int apartNum, String animalName, String animalType, int age, String notice) {
        this.connection = connection;
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.patronymic = new SimpleStringProperty(patronymic);
        this.passNum = new SimpleStringProperty(passNum);
        this.phoneNum = new SimpleStringProperty(phoneNum);
        this.email = new SimpleStringProperty(email);
        this.discount = new SimpleStringProperty(discount);
        this.region = new SimpleStringProperty(region);
        this.locality = new SimpleStringProperty(locality);
        this.street = new SimpleStringProperty(street);
        this.houseNum = new SimpleIntegerProperty(houseNum);
        this.apartNum = new SimpleIntegerProperty(apartNum);
        this.animalName = new SimpleStringProperty(animalName);
        this.animalType = new SimpleStringProperty(animalType);
        this.age = new SimpleIntegerProperty(age);
        this.notice = new SimpleStringProperty(notice);
    }
}
