package com.hillel.crm.entity;

public class User {

    private int iD;
    private String name;
    private String password;
    private UserRole userRole;

    public User(int iD, String name, String password, UserRole userRole) {
        this.iD = iD;
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
