package com.example.olimpic.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PlaceEvent implements Parcelable {

    private int idPlaceEvent;
    private Place place;
    private String address;



    public PlaceEvent(Place place, String address) {
        this.place = place;
        this.address = address;
    }

    public PlaceEvent(int idPlaceEvent, Place place, String address) {
        this.idPlaceEvent = idPlaceEvent;
        this.place = place;
        this.address = address;
    }

    public int getIdPlaceEvent() {
        return idPlaceEvent;
    }

    public void setIdPlaceEvent(int idPlaceEvent) {
        this.idPlaceEvent = idPlaceEvent;
    }

    protected PlaceEvent(Parcel in) {
        address = in.readString();
    }

    public static final Creator<PlaceEvent> CREATOR = new Creator<PlaceEvent>() {
        @Override
        public PlaceEvent createFromParcel(Parcel in) {
            return new PlaceEvent(in);
        }

        @Override
        public PlaceEvent[] newArray(int size) {
            return new PlaceEvent[size];
        }
    };

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PlaceEvent{" +
                "place=" + place +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(address);
    }
}

