package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "model")
public class Model {
//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    private int picImg;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "descriere")
    private String descriere;
    @ColumnInfo(name = "post_img")
    private int postImg;

    public Model(int picImg, String userName, String descriere, int postImg) {
        this.picImg = picImg;
        this.userName = userName;
        this.descriere = descriere;
        this.postImg = postImg;
    }

    @Ignore
    public Model(String userName, String descriere) {
        this.userName = userName;
        this.descriere = descriere;
    }

    public int getPicImg() {
        return picImg;
    }

    public void setPicImg(int picImg) {
        this.picImg = picImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getPostImg() {
        return postImg;
    }

    public void setPostImg(int postImg) {
        this.postImg = postImg;
    }

    @Override
    public String toString() {
        return "Model{" +
                "picImg='" + picImg + '\'' +
                ", userName='" + userName + '\'' +
                ", descriere='" + descriere + '\'' +
                ", postImg='" + postImg + '\'' +
                '}';
    }
}
