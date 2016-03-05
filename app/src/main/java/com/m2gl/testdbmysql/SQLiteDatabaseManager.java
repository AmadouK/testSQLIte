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

    public SQLiteDatabaseManager(Context context) {
        helper = new SQLHelper(context);
    }

    /**
     * Ajoute un utilisateur à la table
     *
     * @param user l'utilsiateur
     * @return -1 si l'ajout ne s'est pas effectué, 1 si oui
     */
    public Long addUser(User user) {
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

    /**
     * Retourne l'ensemble des utilsateurs de la base de données
     *
     * @return liste des utilisateurs
     */
    public ArrayList<User> getUsers() {
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

        while (cursor.moveToNext()) {
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

    /**
     * Récupère un utilisateur en se basant sur son email
     *
     * @param email adresse e-mail de l'utilisateur
     * @return un utilisateur
     */
    public User getUserByEmail(String email) {
        SQLiteDatabase db = helper.getReadableDatabase();

        User user = null;
        String[] args = {email};

        Cursor cursor = db.query(SQLHelper.USER_TABLE, null, SQLHelper.USER_EMAIL + " = ?", args,
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

        while (cursor.moveToNext()) {
            user = new User(cursor.getInt(indexId), cursor.getString(indexName),
                    cursor.getString(indexLastName), cursor.getString(indexSex),
                    cursor.getInt(indexAge), cursor.getDouble(indexHeight),
                    cursor.getDouble(indexWeight), cursor.getString(indexEmail),
                    cursor.getString(indexPassword), cursor.getString(indexStatus));
        }
        return user;
    }

    /**
     * Récupère un utilisateur en se basant sur son id
     *
     * @param id identifiant de l'utilisateur
     * @return un utilisateur
     */
    public User getUserById(int id) {
        SQLiteDatabase db = helper.getReadableDatabase();

        User user = null;
        String[] args = {id + ""};

        Cursor cursor = db.query(SQLHelper.USER_TABLE, null, SQLHelper.USER_ID + " = ?", args,
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

        while (cursor.moveToNext()) {
            user = new User(cursor.getInt(indexId), cursor.getString(indexName),
                    cursor.getString(indexLastName), cursor.getString(indexSex),
                    cursor.getInt(indexAge), cursor.getDouble(indexHeight),
                    cursor.getDouble(indexWeight), cursor.getString(indexEmail),
                    cursor.getString(indexPassword), cursor.getString(indexStatus));
        }
        return user;
    }

    /**
     * Ajoute un programe à la base de données
     *
     * @param program le programme à ajouter
     * @return 1 en cas de succès, -1 en cas d'échec
     */
    public Long addProgram(Program program) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLHelper.PROGRAM_ID, program.getId());
        contentValues.put(SQLHelper.PROGRAM_TITLE, program.getTitle());
        contentValues.put(SQLHelper.PROGRAM_TYPE, program.getType());
        contentValues.put(SQLHelper.PROGRAM_OBJECTIVE, program.getObjective());
        long result = db.insert(SQLHelper.PROGRAM_TABLE, null, contentValues);
        db.close();

        return result;
    }

    /**
     * Récupère la liste des programmes
     *
     * @return liste des programmes
     */
    public ArrayList<Program> getPrograms() {
        SQLiteDatabase db = helper.getReadableDatabase();

        ArrayList<Program> programs = new ArrayList<>();

        Cursor cursor = db.query(SQLHelper.PROGRAM_TABLE, null, null, null, null, null, null);

        int indexId = cursor.getColumnIndex(SQLHelper.PROGRAM_ID);
        int indexTitle = cursor.getColumnIndex(SQLHelper.PROGRAM_TITLE);
        int indexType = cursor.getColumnIndex(SQLHelper.PROGRAM_TYPE);
        int indexObjective = cursor.getColumnIndex(SQLHelper.PROGRAM_OBJECTIVE);

        while (cursor.moveToNext()) {
            programs.add(
                    new Program(cursor.getInt(indexId), cursor.getString(indexTitle),
                            cursor.getString(indexType), cursor.getString(indexObjective))
                    //Penser à rajouter le nombre de séance pour chaque programme
            );
        }
        return programs;
    }

    public Program getProgramById(int id) {
        SQLiteDatabase db = helper.getReadableDatabase();

        Program program = null;
        String[] args = {id + ""};

        Cursor cursor = db.query(SQLHelper.PROGRAM_TABLE, null, SQLHelper.PROGRAM_ID + " = ?",
                args, null, null, null);

        int indexId = cursor.getColumnIndex(SQLHelper.PROGRAM_ID);
        int indexTitle = cursor.getColumnIndex(SQLHelper.PROGRAM_TITLE);
        int indexType = cursor.getColumnIndex(SQLHelper.PROGRAM_TYPE);
        int indexObjective = cursor.getColumnIndex(SQLHelper.PROGRAM_OBJECTIVE);

        while (cursor.moveToNext()) {

                program = new Program(cursor.getInt(indexId), cursor.getString(indexTitle),
                        cursor.getString(indexType), cursor.getString(indexObjective)
                //Penser à rajouter le nombre de séance pour chaque programme
            );
        }
        return program;
    }

    public ArrayList<Program> getProgramsByType(String type) {
        SQLiteDatabase db = helper.getReadableDatabase();

        ArrayList<Program> programs = new ArrayList<>();
        String[] args = {type};

        Cursor cursor = db.query(SQLHelper.PROGRAM_TABLE, null, SQLHelper.PROGRAM_TYPE + " = ?",
                args, null, null, null);

        int indexId = cursor.getColumnIndex(SQLHelper.PROGRAM_ID);
        int indexTitle = cursor.getColumnIndex(SQLHelper.PROGRAM_TITLE);
        int indexType = cursor.getColumnIndex(SQLHelper.PROGRAM_TYPE);
        int indexObjective = cursor.getColumnIndex(SQLHelper.PROGRAM_OBJECTIVE);

        while (cursor.moveToNext()) {
            programs.add(
                    new Program(cursor.getInt(indexId), cursor.getString(indexTitle),
                            cursor.getString(indexType), cursor.getString(indexObjective))
                    //Penser à rajouter le nombre de séance pour chaque programme
            );
        }
        return programs;
    }
}
