package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ModelDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Model... m);

    @Delete
    void delete(Model m);

    @Query("SELECT * FROM model")
    public List<Model> getAll();

    @Query("SELECT * FROM model WHERE picImg > :nr")
    List<Model> getModelsHigh(int nr);
}
