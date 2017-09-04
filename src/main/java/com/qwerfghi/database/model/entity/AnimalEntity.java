package com.qwerfghi.database.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "animal", schema = "hostel", catalog = "")
public class AnimalEntity {
    private short idanimal;
    private String animalName;
    private Serializable animalKind;
    private byte age;
    private byte vetInspection;
    private byte zootaxi;
    private byte cut;
    private String notice;

    @Id
    @Column(name = "idanimal")
    public short getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(short idanimal) {
        this.idanimal = idanimal;
    }

    @Basic
    @Column(name = "animal_name")
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Basic
    @Column(name = "animal_kind")
    public Serializable getAnimalKind() {
        return animalKind;
    }

    public void setAnimalKind(Serializable animalKind) {
        this.animalKind = animalKind;
    }

    @Basic
    @Column(name = "age")
    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Basic
    @Column(name = "vet_inspection")
    public byte getVetInspection() {
        return vetInspection;
    }

    public void setVetInspection(byte vetInspection) {
        this.vetInspection = vetInspection;
    }

    @Basic
    @Column(name = "zootaxi")
    public byte getZootaxi() {
        return zootaxi;
    }

    public void setZootaxi(byte zootaxi) {
        this.zootaxi = zootaxi;
    }

    @Basic
    @Column(name = "cut")
    public byte getCut() {
        return cut;
    }

    public void setCut(byte cut) {
        this.cut = cut;
    }

    @Basic
    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalEntity that = (AnimalEntity) o;

        if (idanimal != that.idanimal) return false;
        if (age != that.age) return false;
        if (vetInspection != that.vetInspection) return false;
        if (zootaxi != that.zootaxi) return false;
        if (cut != that.cut) return false;
        if (animalName != null ? !animalName.equals(that.animalName) : that.animalName != null) return false;
        if (animalKind != null ? !animalKind.equals(that.animalKind) : that.animalKind != null) return false;
        if (notice != null ? !notice.equals(that.notice) : that.notice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idanimal;
        result = 31 * result + (animalName != null ? animalName.hashCode() : 0);
        result = 31 * result + (animalKind != null ? animalKind.hashCode() : 0);
        result = 31 * result + (int) age;
        result = 31 * result + (int) vetInspection;
        result = 31 * result + (int) zootaxi;
        result = 31 * result + (int) cut;
        result = 31 * result + (notice != null ? notice.hashCode() : 0);
        return result;
    }
}
