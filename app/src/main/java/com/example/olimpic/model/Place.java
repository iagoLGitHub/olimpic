package com.example.olimpic.model;

public class Place {

    int idPlace;
    private String place;


    public Place(int idPlace, String place) {
        this.idPlace = idPlace;
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return place;
    }
}
