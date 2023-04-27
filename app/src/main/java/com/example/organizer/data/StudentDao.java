package com.example.organizer.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.organizer.models.Student;

import java.util.List;

@SuppressWarnings("ALL")
@Dao
public interface StudentDao {
        @Query("select * from Student")
        List<Student> getAll();

        @Query("select * from Student")
        LiveData<List<Student>> getAllLiveData();

        @Query("select * from Student where id in (:noteIds)")
        List<Student> getAllByIds(int[] studentIds);

        @Query("select * from Student where id=:id limit 1")
        Student findById(int id);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Student note);

        @Update
        void update(Student note);

        @Delete
        void delete(Student note);
}
