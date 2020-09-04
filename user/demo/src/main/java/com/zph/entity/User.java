package com.zph.entity;

import java.util.Date;

public class User {
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Date  createBy;
    private Date modifiedBy;
    private Byte idDeleted;

    public User() {

    }

    public User(long id, String username, String password, String email, String phone, Date createBy, Date modifiedBy, Byte idDeleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createBy = createBy;
        this.modifiedBy = modifiedBy;
        this.idDeleted = idDeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Byte getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(Byte idDeleted) {
        this.idDeleted = idDeleted;
    }
}
