package com.example.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_FILENAME = "baza1.sqlite";


    public Database(Context context) {
        super(context, DATABASE_FILENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL1 = String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                User.USER_TABLE_NAME, User.USER_FIELD_ID,
                User.USER_FIELD_NAME, User.USER_FIELD_SURNAME, User.USER_FIELD_USERNAME, User.USER_FIELD_PASSWORD,User.USER_FIELD_BIRTH,User.USER_FIELD_EMAIL);


        db.execSQL(SQL1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(String.format("DROP TABLE IF EXISTS %s", User.USER_TABLE_NAME));

    }

    public void addUser(String name, String surname, String username, String password,String birth,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User.USER_FIELD_NAME, name);
        cv.put(User.USER_FIELD_SURNAME, surname);
        cv.put(User.USER_FIELD_USERNAME, username);
        cv.put(User.USER_FIELD_PASSWORD, password);
        cv.put(User.USER_FIELD_BIRTH, birth);
        cv.put(User.USER_FIELD_EMAIL, email);

        db.insert(User.USER_TABLE_NAME, null, cv);
    }

    public void editUser(int id,String name, String surname, String username, String password,String birth,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User.USER_FIELD_NAME, name);
        cv.put(User.USER_FIELD_SURNAME, surname);
        cv.put(User.USER_FIELD_USERNAME, username);
        cv.put(User.USER_FIELD_PASSWORD, password);
        cv.put(User.USER_FIELD_BIRTH, birth);
        cv.put(User.USER_FIELD_EMAIL, email);

        db.update(User.USER_TABLE_NAME, cv, User.USER_FIELD_ID+" = ?", new String[]{String.valueOf(id)} );
    }


    public int deleteUser(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(User.USER_TABLE_NAME, User.USER_FIELD_ID+" = ?", new String[]{String.valueOf(id)});
    }


    public User getUserById(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();



        String SQL = String.format("SELECT * from %s WHERE %s = '%d'", User.USER_TABLE_NAME, User.USER_FIELD_ID, id);
        Cursor res = db.rawQuery(SQL, null);
        if (res.moveToFirst())
        {

            String name = res.getString(res.getColumnIndex(User.USER_FIELD_NAME));
            String surname = res.getString(res.getColumnIndex(User.USER_FIELD_SURNAME));
            String username = res.getString(res.getColumnIndex(User.USER_FIELD_USERNAME));
            String password = res.getString(res.getColumnIndex(User.USER_FIELD_PASSWORD));
            String birth = res.getString(res.getColumnIndex(User.USER_FIELD_BIRTH));
            String email = res.getString(res.getColumnIndex(User.USER_FIELD_EMAIL));

            return new User(id, name, surname,username, password, birth, email);

        }else
        {
            return null;
        }

    }

    public List<User> getAllUsers()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String SQL = String.format("SELECT * from %s", User.USER_TABLE_NAME);

        Cursor res = db.rawQuery(SQL, null);

        res.moveToFirst();

        List<User> listaKor = new ArrayList<>(res.getCount());

        while(!res.isAfterLast())
        {
            int id = res.getInt(res.getColumnIndex(User.USER_FIELD_ID));
            String name = res.getString(res.getColumnIndex(User.USER_FIELD_NAME));
            String surname = res.getString(res.getColumnIndex(User.USER_FIELD_SURNAME));
            String username = res.getString(res.getColumnIndex(User.USER_FIELD_USERNAME));
            String password = res.getString(res.getColumnIndex(User.USER_FIELD_PASSWORD));
            String birth = res.getString(res.getColumnIndex(User.USER_FIELD_BIRTH));
            String email = res.getString(res.getColumnIndex(User.USER_FIELD_EMAIL));

            listaKor.add(new User(id, name, surname,username, password, birth, email));
            res.moveToNext();
        }

        return listaKor;

    }

    public User getUserByUsername(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();



        String SQL = String.format("SELECT * from %s WHERE %s = '%s'", User.USER_TABLE_NAME, User.USER_FIELD_USERNAME, username);
        Cursor res = db.rawQuery(SQL, null);
        if (res.moveToFirst())
        {

            int id = res.getInt(res.getColumnIndex(User.USER_FIELD_ID));
            String name = res.getString(res.getColumnIndex(User.USER_FIELD_NAME));
            String surname = res.getString(res.getColumnIndex(User.USER_FIELD_SURNAME));
            String password = res.getString(res.getColumnIndex(User.USER_FIELD_PASSWORD));
            String birth = res.getString(res.getColumnIndex(User.USER_FIELD_BIRTH));
            String email = res.getString(res.getColumnIndex(User.USER_FIELD_EMAIL));

            return new User(id, name, surname, username, password,birth,email);

        }else
        {
            return null;
        }

    }

}