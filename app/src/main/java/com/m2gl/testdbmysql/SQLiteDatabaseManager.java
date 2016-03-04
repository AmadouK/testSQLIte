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

    //Select * from users
    public ArrayList<User> getUsers(){
        SQLiteDatabase db = helper.getReadableDatabase();

        ArrayList<User> users = new ArrayList<>();

        Cursor cursor = db.query(SQLHelper.USER_TABLE, null, null, null, null, null, null);

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

        while(cursor.moveToNext()){
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

    //Select * from user where email = ?
    public User getUserByEmail(String email){
        SQLiteDatabase db = helper.getReadableDatabase();

        User user = null;
        String[] args = {email};

        Cursor cursor = db.query(SQLHelper.USER_TABLE, null, SQLHelper.USER_EMAIL+" = ?", args,
                null, null, null);

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

        while(cursor.moveToNext()){
            user = new User(cursor.getInt(indexId), cursor.getString(indexName),
                    cursor.getString(indexLastName), cursor.getString(indexSex),
                    cursor.getInt(indexAge), cursor.getDouble(indexHeight),
                    cursor.getDouble(indexWeight), cursor.getString(indexEmail),
                    cursor.getString(indexPassword), cursor.getString(indexStatus));
        }
        return user;
    }
}
