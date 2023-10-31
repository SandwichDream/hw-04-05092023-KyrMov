package com.example_sql.demo.model;

public class User {

    private int id;
    private String name;
    private int roleID;

    public User(int id, String name, int roleID) {
        this.id = id;
        this.name = name;
        this.roleID = roleID;
    }

    public User() {
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoleID() {
        return roleID;
    }
}
