package com.m2gl.testdbmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabaseManager sqLiteDatabaseManager;

    public List<User> users;
    public List<Program> programs;

    EditText email;
    EditText id;
    EditText programId;
    EditText programType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabaseManager = new SQLiteDatabaseManager(this);

        email = (EditText) findViewById(R.id.email);
        id = (EditText) findViewById(R.id.id);
        programId = (EditText) findViewById(R.id.programId);
        programType = (EditText) findViewById(R.id.programType);

        populateUsers();
        populatePrograms();
    }

    public void addUsers(View view) {
        for (User u : users) {
            sqLiteDatabaseManager.addUser(u);
        }
    }

    public void getUsers(View view) throws JSONException {
        String result = JSONConverter.usersToJSON(sqLiteDatabaseManager.getUsers());

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Log.d("USERS", users.toString());
    }

    public void getUserByEmail(View view) throws JSONException {
        String result = JSONConverter.userToJSON(sqLiteDatabaseManager.getUserByEmail
                (String.valueOf(email.getText())));

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Log.d("USER", users.toString());
    }

    public void getUserById(View view) throws JSONException {
        String result = JSONConverter.userToJSON(sqLiteDatabaseManager.getUserById
                (Integer.parseInt(String.valueOf(id.getText()))));

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Log.d("USER", users.toString());
    }

    public void addPrograms(View view) {
        for(Program p: programs){
            sqLiteDatabaseManager.addProgram(p);
        }
    }

    public void getPrograms(View view) throws JSONException {
        String result = JSONConverter.programsToJSON(sqLiteDatabaseManager.getPrograms());

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Log.d("PROGRAMS", result);
    }

    public void populateUsers() {
        users = new ArrayList<>();
        User u1 = new User(1, "Hamza", "HABCHI", "M", 25, 1.73, 75, "hamza0habchi@gmail.com",
                "hamzahabchi", "sportif");
        User u2 = new User(2, "Amadou", "KANE", "M", 25, 1.80, 75, "amadoukane@gmail.com",
                "amadoukane", "sportif");
        User u3 = new User(3, "Hamza", "ZOUDANI", "M", 25, 1.70, 75, "hamzazoudani@gmail.com",
                "hamzazoudani", "sportif");
        User u4 = new User(4, "Mustapha", "FEKARI", "M", 25, 1.70, 75, "mustaphafekari@gmail.com",
                "mustaphafekari", "sportif");
        User u5 = new User(5, "Amal", "WESLATI", "M", 25, 1.50, 120, "amalweslati@gmail.com",
                "amalweslati", "boulangère");
        User u6 = new User(6, "Nourhane", "KHALED", "", 0, 0, 0, "", "", "");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
    }

    public void populatePrograms() {
        programs = new ArrayList<>();
        Program p1 = new Program(1, "Programme Superman", "pre", "cardio");
        Program p2 = new Program(2, "Programme Batman", "cre", "endurance");
        Program p3 = new Program(3, "Programme Aquaman", "pre", "Respiration");
        Program p4 = new Program(4, "Programme Wonderwoman", "cre", "endurance");
        Program p5 = new Program(5, "Programme Flash", "pre", "vitesse");
        Program p6 = new Program(6, "Programme Greenlatern", "cre", "imagination");
        Program p7 = new Program(7, "Programme Cyborg", "pre", "sentiment");
        Program p8 = new Program(8, "Programme Atom", "cre", "intelligence");
        Program p9 = new Program(9, "Programme Greearrow", "pre", "precision");
        Program p10 = new Program(10, "Programme Hawkman", "pre", "force");
        programs.add(p1);
        programs.add(p2);
        programs.add(p3);
        programs.add(p4);
        programs.add(p5);
        programs.add(p6);
        programs.add(p7);
        programs.add(p8);
        programs.add(p9);
        programs.add(p10);
    }


    public void getProgramById(View view) throws JSONException {
        String result = JSONConverter.programToJSON(sqLiteDatabaseManager.getProgramById(
                Integer.parseInt(String.valueOf(programId.getText()))
        ));
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Log.d("PROGRAM", result);
    }

    public void getProgramsByType(View view) throws JSONException {
        String result = JSONConverter.programsToJSON(sqLiteDatabaseManager.getProgramsByType(
                String.valueOf(programType.getText())
        ));
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        Log.d("PROGRAMS", result);
    }
}
