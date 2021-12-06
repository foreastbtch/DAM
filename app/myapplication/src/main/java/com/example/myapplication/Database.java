package com.example.myapplication;

import android.content.Context;

import androidx.room.Room;

public class Database {
    private static Database database;
    private DatabaseModel databaseModel;

    private Database(Context context) {
//        databaseModel = Room.databaseBuilder(context, DatabaseModel.class, "model-database").allowMainThreadQueries().build();
        databaseModel = Room.databaseBuilder(context, DatabaseModel.class, "model-database").build();
    }

    public static Database getInstance(Context context) {
        if (database == null) {
            database = new Database(context);
//            database.getDatabase(context);
        }
        return database;
    }

    public DatabaseModel getDatabase() {
        return databaseModel;
    }

//    public ModelDAO getModelDAO(){
//        return databaseModel.modelDAO();
//    }
}
