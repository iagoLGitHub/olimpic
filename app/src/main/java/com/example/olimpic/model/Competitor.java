package com.example.olimpic.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class Competitor implements Parcelable {

    private int idCompetitor;
    private String name;
    private String lastName1;
    private String lastName2;

    private String dni;
    private String aka;
    private String category;




    public Competitor(String name, String lastName1, String lastName2, String dni, String aka, String category) {
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.dni = dni;
        this.aka = aka;
        this.category = category;
    }

    public Competitor(int idCompetitor, String name, String lastName1, String lastName2, String dni, String aka, String category) {
        this.idCompetitor = idCompetitor;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.dni = dni;
        this.aka = aka;
        this.category = category;
    }
    protected Competitor(Parcel in) {
        idCompetitor = in.readInt();
        name = in.readString();
        lastName1 = in.readString();
        lastName2 = in.readString();
        dni = in.readString();
        aka = in.readString();
        category=in.readString();
    }
    public static final Creator<Competitor> CREATOR = new Creator<Competitor>() {
        @Override
        public Competitor createFromParcel(Parcel in) {
            return new Competitor(in);
        }

        @Override
        public Competitor[] newArray(int size) {
            return new Competitor[size];
        }
    };
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        return category;
    }

    public void setCategory(String category) {
        category = category;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "idCompetitor=" + idCompetitor +
                ", name='" + name + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", aka='" + aka + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompetitor, name, lastName1, lastName2, dni, aka, category);
    }

    @Override
    public boolean equals(@Nullable Object obj) {

        Competitor that = (Competitor) obj;
        return  Objects.equals(name, that.name) &&
                Objects.equals(lastName1, that.lastName1) &&
                Objects.equals(lastName2, that.lastName2) &&
                Objects.equals(dni, that.dni) &&
                Objects.equals(aka, that.aka) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idCompetitor);
        parcel.writeString(name);
        parcel.writeString(lastName1);
        parcel.writeString(lastName2);
        parcel.writeString(dni);
        parcel.writeString(aka);
        parcel.writeString(category);
    }


}
