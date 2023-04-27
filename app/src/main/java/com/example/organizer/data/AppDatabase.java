package com.example.organizer.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.organizer.models.Note;
import com.example.organizer.models.Student;

@Database(entities = {Note.class, Student.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
    public abstract Student studentDao();
}
