package com.m2gl.testdbmysql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Hamza on 01/03/2016.
 */
public class SQLHelper extends SQLiteOpenHelper {

    //Informations général de la base de données
    private static final String DATABASE_NAME = "rasDatabase";
    private static final int DATABSE_VERSION = 1;

    /************************
     * Table Utilisateur
     ***************************/

    //Nom de la table utilisateur
    public static final String USER_TABLE = "USER";
    //Colonnes de la table utilisateur
    public static final String USER_ID = "ID";
    public static final String USER_NAME = "NAME";
    public static final String USER_LASTNAME = "LASTNAME";
    public static final String USER_EMAIL = "EMAIL";
    public static final String USER_PASSWORD = "PASSWORD";
    public static final String USER_AGE = "AGE";
    public static final String USER_WEIGHT = "WEIGHT";
    public static final String USER_HEIGHT = "HEIGHT";
    public static final String USER_STATUS = "STATUS";
    public static final String USER_SEX = "SEX";
    //Requête SQL pour créer la table utilisateur
    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " (" + USER_ID +
            " INTEGER PRIMARY KEY, " + USER_NAME + " VARCHAR(255), " + USER_LASTNAME +
            " VARCHAR(255), " + USER_EMAIL + " VARCHAR(255), " + USER_PASSWORD + " VARCHAR(255), " +
            USER_WEIGHT + " DOUBLE, " + USER_HEIGHT + " DOUBLE, " + USER_AGE + " INTEGER, " + USER_STATUS +
            " VARCHAR(255), " + USER_SEX + " VARCHAR(1));";


    /************************
     * Table Défi
     ***************************/

    //Nom de la table défi
    public static final String CHALLENGE_TABLE = "CHALLENGE";
    //Colonnes de la table défi
    public static final String CHALLENGE_ID = "ID";
    public static final String CHALLENGE_TITLE = "TITLE";
    public static final String CHALLENGE_LIMITDATE = "LIMITDATE";
    public static final String CHALLENGE_TYPE = "TYPE";
    public static final String CHALLENGE_OBJECTIVE = "OBJECTIVE";
    public static final String CHALLENGE_CREATOR = "CREATOR";
    //Requête SQL pour créer la table défi
    private static final String CREATE_CHALLENGE_TABLE = "CREATE TABLE " + CHALLENGE_TABLE + " (" +
            CHALLENGE_ID + " INTEGER PRIMARY KEY, " + CHALLENGE_TITLE + " VARCHAR(255), " + CHALLENGE_LIMITDATE +
            " DATE, " + CHALLENGE_TYPE + " VARCHAR(255), " + CHALLENGE_OBJECTIVE + " VARCHAR(255), " +
            CHALLENGE_CREATOR + " INTEGER);";


    /************************
     * Table Programme
     ***************************/

    //Nom de la table programme
    public static final String PROGRAM_TABLE = "PROGRAM";
    //Colonnes de la table programme
    public static final String PROGRAM_ID = "ID";
    public static final String PROGRAM_TITLE = "TITLE";
    //Objectif : Cardio ...
    public static final String PROGRAM_OBJECTIVE = "OBJECTIVE";
    //Prédéfini ou pas
    public static final String PROGRAM_TYPE = "TYPE";
    //Requête SQL pour créer la table programme
    private static final String CREATE_PROGRAM_TABLE = "CREATE TABLE " + PROGRAM_TABLE + " (" +
            PROGRAM_ID + " INTEGER PRIMARY KEY, " + PROGRAM_TITLE + " VARCHAR(255), " + PROGRAM_TYPE +
            " VARCHAR(255), " + PROGRAM_OBJECTIVE + " VARCHAR(255));";


    /************************
     * Table Séance
     ***************************/

    //Nom de la table séance
    public static final String WORKOUT_TABLE = "WORKOUT";
    //Colonnes de la table séance
    public static final String WORKOUT_ID = "ID";
    public static final String WORKOUT_TITLE = "TITLE";
    public static final String WORKOUT_DATE = "DATE";
    public static final String WORKOUT_TIME = "TIME";
    public static final String WORKOUT_DISTANCE = "DISTANCE";
    public static final String WORKOUT_AVERAGE_SPEED = "AVERAGESPEED";
    public static final String WORKOUT_MAX_SPEED = "MAXSPEED";
    public static final String WORKOUT_MIN_SPEED = "MINSPEED";
    public static final String WORKOUT_AVERAGE_RYTHM = "AVERAGERYTHM";
    public static final String WORKOUT_MAX_RYTHM = "MAXRYTHM";
    public static final String WORKOUT_CALORIES = "CALORIES";
    public static final String WORKOUT_MAX_ALTITUDE = "MAXLALTITUDE";
    public static final String WORKOUT_MIN_ALTITUDE = "MINALTITUDE";
    public static final String WORKOUT_USER_ID = "USERID";
    public static final String WORKOUT_CHALLENGE_ID = "CHALLENGEID";
    public static final String WORKOUT_PROGRAM_ID = "PROGRAMID";
    //Permet de savoir si la séance est faite ou pas encore
    public static final String WORKOUT_DONE = "DONE";
    //Séance libre, prédéfinie, programme, défi
    public static final String WORKOUT_TYPE = "TYPE";
    //Requête SQL pour créer la table séance
    private static final String CREATE_WORKOUT_TABLE = "CREATE TABLE " + WORKOUT_TABLE +" ("+
            WORKOUT_ID+" VARCHAR(255) PRIMARY KEY, "+ WORKOUT_TITLE+ " VARCHAR(255), "+
            WORKOUT_DATE+" VARCHAR(255), "+ WORKOUT_TIME +" VARCHAR(255), "+WORKOUT_DISTANCE+
            " VARCHAR(255), "+WORKOUT_AVERAGE_SPEED+" VARCHAR(255), "+WORKOUT_MAX_SPEED+
            " VARCHAR(255), "+WORKOUT_MIN_SPEED+" VARCHAR(255), "+WORKOUT_AVERAGE_RYTHM+
            " VARCHAR(255), "+WORKOUT_MAX_RYTHM+" VARCHAR(255), "+WORKOUT_CALORIES+" VARCHAR(255), "
            +WORKOUT_MAX_ALTITUDE+" VARCHAR(255), "+WORKOUT_MIN_ALTITUDE+" VARCHAR(255), "+
            WORKOUT_USER_ID+" INTEGER, "+WORKOUT_CHALLENGE_ID+" INTEGER, "+WORKOUT_PROGRAM_ID+
            " INTEGER);";



    /************************
     * Table Geopoint
     ***************************/
    //Nom de la table carte
    public static final String GEOPOINT_TABLE = "GEOPOINT";
    //Colonnes de la table carte
    public static final String GEOPOINT_ID = "ID";
    public static final String GEOPOINT_LATITUDE = "LATITUDE";
    public static final String GEOPOINT_LONGITUDE = "LONGITUDE";
    public static final String GEOPOINT_WORKOUT_ID = "WORKOUTID";
    //Requête SQL pour créer la table GEOPOINT
    private static final String CREATE_GEOPOINT_TABLE = "CREATE TABLE "+ GEOPOINT_TABLE+" ("+
            GEOPOINT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+GEOPOINT_LATITUDE+" double, "+
            GEOPOINT_LONGITUDE+" double, "+GEOPOINT_WORKOUT_ID+" VARCHAR(255));";


    Context context;

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_CHALLENGE_TABLE);
        db.execSQL(CREATE_PROGRAM_TABLE);
        db.execSQL(CREATE_WORKOUT_TABLE);
        db.execSQL(CREATE_GEOPOINT_TABLE);

        Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "onUpgrade is called", Toast.LENGTH_LONG).show();
    }
}