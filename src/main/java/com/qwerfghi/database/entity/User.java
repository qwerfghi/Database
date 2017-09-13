package com.qwerfghi.database.entity;

import javax.persistence.*;

/**
 * Created by Павел on 21.06.2017.
 */
@Entity
@Table(name = "user", schema = "hostel")
public class User {
    private int iduser;
    private String username;
    private String password;
    private Privileges privilegeEntity;
    private Owner owner;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
    public Privileges getPrivilegeEntity() {
        return privilegeEntity;
    }

    public void setPrivilegeEntity(Privileges privilegeEntity) {
        this.privilegeEntity = privilegeEntity;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idowner", foreignKey = @ForeignKey(name = "fk_owner_id"))
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}