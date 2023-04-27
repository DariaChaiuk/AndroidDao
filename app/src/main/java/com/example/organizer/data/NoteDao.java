package com.example.organizer.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.OnConflictStrategy;

import com.example.organizer.models.Note;
import java.util.List;

@SuppressWarnings("ALL")
@Dao
public interface NoteDao {
    @Query("select * from Note")
    List<Note> getAll();

    @Query("select * from Note")
    LiveData<List<Note>> getAllLiveData();

    @Query("select * from Note where id in (:noteIds)")
    List<Note> getAllByIds(int[] noteIds);

    @Query("select * from Note where id=:id limit 1")
    Note findById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
