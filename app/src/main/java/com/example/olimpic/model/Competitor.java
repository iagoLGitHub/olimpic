package com.example.olimpic.model;

public class Competitor {

    private String name;
    private String lastName;

    private String aka;
    private String Category;

    public Competitor(String name, String lastName, String aka, String category) {
        this.name = name;
        this.lastName = lastName;
        this.aka = aka;
        Category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", aka='" + aka + '\'' +
                ", Category='" + Category + '\'' +
                '}';
    }
}
