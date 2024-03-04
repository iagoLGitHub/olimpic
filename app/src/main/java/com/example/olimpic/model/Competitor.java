package com.example.olimpic.model;

public class Competitor {

    private int idCompetitor;
    private String name;
    private String lastName1;
    private String lastName2;
    private String aka;
    private String Category;

    public Competitor(int idCompetitor, String name, String lastName1, String lastName2, String aka, String category) {
        this.idCompetitor = idCompetitor;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.aka = aka;
        Category = category;
    }

    public int getIdCompetitor() {
        return idCompetitor;
    }

    public void setIdCompetitor(int idCompetitor) {
        this.idCompetitor = idCompetitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
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
                "idCompetitor=" + idCompetitor +
                ", name='" + name + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", aka='" + aka + '\'' +
                ", Category='" + Category + '\'' +
                '}';
    }
}
