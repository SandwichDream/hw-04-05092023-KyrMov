package com.example_sql.demo.model;

public class UserRole {

    private int id;
    private String name;
    private String role;

    public UserRole(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public UserRole() {

    }

    public int getInt() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
