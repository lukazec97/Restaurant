package com.example.restaurant;

public class User {

    public static final String USER_TABLE_NAME = "users";
    public static final String USER_FIELD_ID = "id";
    public static final String USER_FIELD_NAME = "name";
    public static final String USER_FIELD_SURNAME = "surname";
    public static final String USER_FIELD_USERNAME = "username";
    public static final String USER_FIELD_PASSWORD = "password";
    public static final String USER_FIELD_BIRTH = "birth";
    public static final String USER_FIELD_EMAIL = "email";


    private String name, surname, username, password,birth,email;
    private int userID;



    public User(int userID, String name, String surname, String username, String password, String birth,String email) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.birth=birth;
        this.email = email;

    }

    public User(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getBirth() { return birth; }

    public void setBirth(String birth) { this.birth = birth; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}