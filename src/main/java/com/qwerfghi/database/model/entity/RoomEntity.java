package com.qwerfghi.database.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "room", schema = "hostel")
public class RoomEntity {
    private short idrooms;
    private short number;
    private AnimalType animalType;
    private Date dateBeg;
    private Date dateEnd;
    private short cost;

    @Id
    @Column(name = "idrooms")
    public short getIdrooms() {
        return idrooms;
    }

    public void setIdrooms(short idrooms) {
        this.idrooms = idrooms;
    }

    @Basic
    @Column(name = "number")
    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "animal_type")
    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Basic
    @Column(name = "date_beg")
    public Date getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(Date dateBeg) {
        this.dateBeg = dateBeg;
    }

    @Basic
    @Column(name = "date_end")
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "cost")
    public short getCost() {
        return cost;
    }

    public void setCost(short cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (idrooms != that.idrooms) return false;
        if (number != that.number) return false;
        if (cost != that.cost) return false;
        if (animalType != null ? !animalType.equals(that.animalType) : that.animalType != null) return false;
        if (dateBeg != null ? !dateBeg.equals(that.dateBeg) : that.dateBeg != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idrooms;
        result = 31 * result + (int) number;
        result = 31 * result + (animalType != null ? animalType.hashCode() : 0);
        result = 31 * result + (dateBeg != null ? dateBeg.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) cost;
        return result;
    }
}
