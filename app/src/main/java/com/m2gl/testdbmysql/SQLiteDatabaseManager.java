package com.m2gl.testdbmysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Hamza on 29/02/2016.
 */
public class SQLiteDatabaseManager {

    SQLHelper helper;

    public SQLiteDatabaseManager(Context context){
        helper = new SQLHelper(context);
    }


    public long insertData(String userid, String name, String lastName, String email, String password,
                           double weight, double lenght, int age, String statut, String sexe){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLHelper.USER_ID, userid);
        contentValues.put(SQLHelper.USER_NAME, name);
        contentValues.put(SQLHelper.USER_LASTNAME, lastName);
        contentValues.put(SQLHelper.USER_EMAIL, email);
        contentValues.put(SQLHelper.USER_PASSWORD, password);
        contentValues.put(SQLHelper.USER_WEIGHT, weight);
        contentValues.put(SQLHelper.USER_HEIGHT, lenght);
        contentValues.put(SQLHelper.USER_AGE, age);
        contentValues.put(SQLHelper.USER_STATUS, statut);
        contentValues.put(SQLHelper.USER_SEX, sexe);
        long id = db.insert(SQLHelper.USER_TABLE, null, contentValues);
        db.close();

        return id;
    }

    public long insertChallenge(String title){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLHelper.CHALLENGE_TITLE, title);

        long id = db.insert(SQLHelper.CHALLENGE_TABLE, null, contentValues);

        db.close();

        return id;
    }

    public String getData(){
        SQLiteDatabase db = helper.getReadableDatabase();
        //Select * from users

        String[] columns = {SQLHelper.USER_NAME, SQLHelper.USER_ID, SQLHelper.USER_LASTNAME,
                SQLHelper.USER_HEIGHT};

        Cursor cursor = db.query(SQLHelper.USER_TABLE, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();

        while(cursor.moveToNext()){
            int indexName = cursor.getColumnIndex(SQLHelper.USER_NAME);
            int indexLastName = cursor.getColumnIndex(SQLHelper.USER_LASTNAME);
            int indexId = cursor.getColumnIndex(SQLHelper.USER_ID);
            int indexheight = cursor.getColumnIndex(SQLHelper.USER_HEIGHT);

            String name = cursor.getString(indexName);
            String lastName = cursor.getString(indexLastName);
            String id = cursor.getString(indexId);
            double lenght = cursor.getDouble(indexheight);


            buffer.append(id+":");
        }

        return buffer.toString();
    }

    public String getChallenge(){
        SQLiteDatabase db = helper.getReadableDatabase();
        //Select * from users

        String[] columns = {SQLHelper.CHALLENGE_TITLE};

        Cursor cursor = db.query(SQLHelper.CHALLENGE_TABLE, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();

        while(cursor.moveToNext()){
            int indextitle = cursor.getColumnIndex(SQLHelper.CHALLENGE_TITLE);

            String name = cursor.getString(indextitle);


            buffer.append(name+":");
        }

        return buffer.toString();
    }

    public Long addUser(User user){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLHelper.USER_ID, user.getId());
        contentValues.put(SQLHelper.USER_NAME, user.getName());
        contentValues.put(SQLHelper.USER_LASTNAME, user.getLastName());
        contentValues.put(SQLHelper.USER_EMAIL, user.getEmail());
        contentValues.put(SQLHelper.USER_PASSWORD, user.getPassword());
        contentValues.put(SQLHelper.USER_WEIGHT, user.getWeight());
        contentValues.put(SQLHelper.USER_HEIGHT, user.getHeight());
        contentValues.put(SQLHelper.USER_AGE, user.getAge());
        contentValues.put(SQLHelper.USER_STATUS, user.getStatus());
        contentValues.put(SQLHelper.USER_SEX, user.getSex());
        long result = db.insert(SQLHelper.USER_TABLE, null, contentValues);
        db.close();

        return result;
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = helper.getReadableDatabase();
        //Select * from users

        ArrayList<User> users = new ArrayList<>();

        String[] columns = {SQLHelper.USER_NAME, SQLHelper.USER_ID, SQLHelper.USER_LASTNAME,
                SQLHelper.USER_HEIGHT};

        Cursor cursor = db.query(SQLHelper.USER_TABLE, null, null, null, null, null, null);

        while(cursor.moveToNext()){
            int indexId = cursor.getColumnIndex(SQLHelper.USER_ID);
            int indexName = cursor.getColumnIndex(SQLHelper.USER_NAME);
            int indexLastName = cursor.getColumnIndex(SQLHelper.USER_LASTNAME);
            int indexSex = cursor.getColumnIndex(SQLHelper.USER_SEX);
            int indexAge = cursor.getColumnIndex(SQLHelper.USER_AGE);
            int indexWeight = cursor.getColumnIndex(SQLHelper.USER_WEIGHT);
            int indexHeight = cursor.getColumnIndex(SQLHelper.USER_HEIGHT);
            int indexEmail = cursor.getColumnIndex(SQLHelper.USER_EMAIL);
            int indexPassword = cursor.getColumnIndex(SQLHelper.USER_STATUS);
            int indexStatus = cursor.getColumnIndex(SQLHelper.USER_STATUS);

            users.add(
                    new User(cursor.getInt(indexId), cursor.getString(indexName),
                    cursor.getString(indexLastName), cursor.getString(indexSex),
                    cursor.getInt(indexAge), cursor.getDouble(indexHeight),
                    cursor.getDouble(indexWeight), cursor.getString(indexEmail),
                    cursor.getString(indexPassword), cursor.getString(indexStatus))
            );
        }
        return users;
    }
}
