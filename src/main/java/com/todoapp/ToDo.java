package com.todoapp;

import java.sql.Timestamp;

public class ToDo {
    private int id;
    private String title;
    private boolean status;
    private Timestamp createdAt;

    // Constructors, getters, and setters
    public ToDo() {}

    public ToDo(String title) {
        this.title = title;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
