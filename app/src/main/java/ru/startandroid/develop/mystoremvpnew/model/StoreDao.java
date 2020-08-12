package ru.startandroid.develop.mystoremvpnew.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface StoreDao {
    @Insert
    void insert(Store store);

    @Update
    void update(Store store);

    @Delete
    void delete(Store store);

    @Query("DELETE FROM store_table")
    void deleteAllNotes();

    @Query("SELECT * FROM store_table WHERE id=:id")
    LiveData<Store> getItem(int id);

    @Query("SELECT * FROM store_table")
    LiveData<List<Store>> getAllNotes();
}
