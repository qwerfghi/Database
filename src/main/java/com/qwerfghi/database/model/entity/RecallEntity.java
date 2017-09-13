package com.qwerfghi.database.model.entity;

import javax.persistence.*;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "recall", schema = "hostel")
public class RecallEntity {
    private short idrecall;
    private String email;
    private int mark;
    private String recall;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idrecall")
    public short getIdrecall() {
        return idrecall;
    }

    public void setIdrecall(short idrecall) {
        this.idrecall = idrecall;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mark")
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "recall")
    public String getRecall() {
        return recall;
    }

    public void setRecall(String recall) {
        this.recall = recall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecallEntity that = (RecallEntity) o;

        if (idrecall != that.idrecall) return false;
        if (mark != that.mark) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (recall != null ? !recall.equals(that.recall) : that.recall != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idrecall;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) mark;
        result = 31 * result + (recall != null ? recall.hashCode() : 0);
        return result;
    }
}