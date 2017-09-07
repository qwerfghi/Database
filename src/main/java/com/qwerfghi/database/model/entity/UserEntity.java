package com.qwerfghi.database.model.entity;

import javax.persistence.*;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "user", schema = "hostel")
public class UserEntity {
    private int iduser;
    private String username;
    private String password;
    private PrivilegesEntity privilegeEntity;

    @Id
    @GeneratedValue
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "privilege_id", foreignKey = @ForeignKey(name = "fk_privilege_id"))
    public PrivilegesEntity getPrivilegeEntity() {
        return privilegeEntity;
    }

    public void setPrivilegeEntity(PrivilegesEntity privilegeEntity) {
        this.privilegeEntity = privilegeEntity;
    }
}