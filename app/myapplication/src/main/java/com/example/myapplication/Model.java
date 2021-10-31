package com.example.myapplication;

public class Model {
    private int picImg;
    private String userName;
    private String descriere;
    private int postImg;

    public Model(int picImg, String userName, String descriere, int postImg) {
        this.picImg = picImg;
        this.userName = userName;
        this.descriere = descriere;
        this.postImg = postImg;
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
