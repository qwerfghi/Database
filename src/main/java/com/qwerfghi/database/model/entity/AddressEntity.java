package com.qwerfghi.database.model.entity;

import javax.persistence.*;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "address", schema = "hostel")
public class AddressEntity {
    private int idaddress;
    private String region;
    private String locality;
    private String street;
    private int houseNum;
    private int apartmentNum;

    @Id
    @GeneratedValue
    @Column(name = "idaddress")
    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "locality")
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house_num")
    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    @Basic
    @Column(name = "apartment_num")
    public int getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(int apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (idaddress != that.idaddress) return false;
        if (houseNum != that.houseNum) return false;
        if (apartmentNum != that.apartmentNum) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (locality != null ? !locality.equals(that.locality) : that.locality != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idaddress;
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + houseNum;
        result = 31 * result + apartmentNum;
        return result;
    }
}