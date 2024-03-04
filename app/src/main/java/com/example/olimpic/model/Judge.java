package com.example.olimpic.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Judge implements Parcelable {

    private int idJudge;
    private String name;
    private String lastName1;
    private String lastName2;
    private String dni;
    private String aka;

    public Judge(int idJudge, String name, String lastName1, String lastName2, String dni, String aka) {
        this.idJudge = idJudge;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.dni = dni;
        this.aka = aka;
    }

    protected Judge(Parcel in) {
        idJudge = in.readInt();
        name = in.readString();
        lastName1 = in.readString();
        lastName2 = in.readString();
        dni = in.readString();
        aka = in.readString();
    }

    public static final Creator<Judge> CREATOR = new Creator<Judge>() {
        @Override
        public Judge createFromParcel(Parcel in) {
            return new Judge(in);
        }

        @Override
        public Judge[] newArray(int size) {
            return new Judge[size];
        }
    };

    public int getIdJudge() {
        return idJudge;
    }

    public void setIdJudge(int idJudge) {
        this.idJudge = idJudge;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    @Override
    public String toString() {
        return "Judge{" +
                "idJudge=" + idJudge +
                ", name='" + name + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", dni='" + dni + '\'' +
                ", aka='" + aka + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int i) {
        dest.writeInt(idJudge);
        dest.writeString(name);
        dest.writeString(lastName1);
        dest.writeString(lastName2);
        dest.writeString(dni);
        dest.writeString(aka);
    }


}