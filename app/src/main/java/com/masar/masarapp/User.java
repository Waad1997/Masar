package com.masar.masarapp;

import android.widget.RadioButton;

import java.util.Date;

public class User {

    private String Name;
    private String Birthday;
    private String Gender;

    public User() {

    }

    public User(String name, String birthday, String gender) {
        Name = name;
        Birthday = birthday;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}


