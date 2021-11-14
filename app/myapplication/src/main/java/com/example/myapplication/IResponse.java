package com.example.myapplication;

import java.util.List;

public interface IResponse {
    void onSuccess(List<Model> modele);

    void onError(String mesaj);
}
