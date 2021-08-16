package com.example.haftauc_mobil.models;

public class DataModel {
    int id;
    String name, surname, year;

    public DataModel(int id, String name, String surname, String year) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
