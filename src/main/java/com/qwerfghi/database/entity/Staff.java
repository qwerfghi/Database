package com.qwerfghi.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "staff", schema = "hostel")
public class Staff {
    private int idstaff;
    private String employeeName;
    private String employeeLastName;
    private String employeePatronymic;
    private Date dateRec;
    private String passport;
    private String phoneNum;
    private String email;
    private String position;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idstaff")
    public int getIdstaff() {
        return idstaff;
    }

    public void setIdstaff(int idstaff) {
        this.idstaff = idstaff;
    }

    @Basic
    @Column(name = "employee_name")
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Basic
    @Column(name = "employee_last_name")
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    @Basic
    @Column(name = "employee_patronymic")
    public String getEmployeePatronymic() {
        return employeePatronymic;
    }

    public void setEmployeePatronymic(String employeePatronymic) {
        this.employeePatronymic = employeePatronymic;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date_rec")
    public Date getDateRec() {
        return dateRec;
    }

    public void setDateRec(Date dateRec) {
        this.dateRec = dateRec;
    }

    @Basic
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "phone_num")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff that = (Staff) o;

        if (idstaff != that.idstaff) return false;
        if (employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null) return false;
        if (employeeLastName != null ? !employeeLastName.equals(that.employeeLastName) : that.employeeLastName != null)
            return false;
        if (employeePatronymic != null ? !employeePatronymic.equals(that.employeePatronymic) : that.employeePatronymic != null)
            return false;
        if (dateRec != null ? !dateRec.equals(that.dateRec) : that.dateRec != null) return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idstaff;
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (employeeLastName != null ? employeeLastName.hashCode() : 0);
        result = 31 * result + (employeePatronymic != null ? employeePatronymic.hashCode() : 0);
        result = 31 * result + (dateRec != null ? dateRec.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}