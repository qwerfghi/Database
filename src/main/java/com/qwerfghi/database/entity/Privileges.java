package com.qwerfghi.database.entity;

import javax.persistence.*;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "privileges", schema = "hostel")
public class Privileges {
    private int id;
    private String privilegeName;
    private String password;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "privilege_name")
    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privileges that = (Privileges) o;

        if (id != that.id) return false;
        if (privilegeName != null ? !privilegeName.equals(that.privilegeName) : that.privilegeName != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (privilegeName != null ? privilegeName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}