package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public class Model2Firebase implements Serializable {

    public String userName;
    public String descriere;

    public Model2Firebase(String userName, String descriere) {
        this.userName = userName;
        this.descriere = descriere;
    }

    public Model2Firebase() {
    }

    @Override
    public String toString() {
        return "Model2Firebase{" +
                "userName='" + userName + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
