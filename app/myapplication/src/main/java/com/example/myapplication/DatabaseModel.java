package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Model.class}, version = 1, exportSchema = false)
public abstract class DatabaseModel extends RoomDatabase {
    public abstract ModelDAO modelDAO();
}
