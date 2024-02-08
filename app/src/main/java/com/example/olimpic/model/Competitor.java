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
