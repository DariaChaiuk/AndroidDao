package com.example.organizer.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Student implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "firstName")
    public String firstName;

    @ColumnInfo(name = "lastName")
    public String lastName;

    @ColumnInfo(name = "birthday")
    public Long birthday;

    @ColumnInfo(name = "groupName")
    public String groupName;

    protected Student(){
    }

    protected Student(int id, String firstName, String lastName, Long birthday, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.groupName = groupName;
    }

    protected Student(Parcel in) {
        id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        if (in.readByte() == 0) {
            birthday = null;
        } else {
            birthday = in.readLong();
        }
        groupName = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        if (birthday == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(birthday);
        }
        parcel.writeString(groupName);
    }
}
