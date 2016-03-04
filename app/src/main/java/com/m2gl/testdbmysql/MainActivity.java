package com.m2gl.testdbmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabaseManager sqLiteDatabaseManager;

    public List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabaseManager = new SQLiteDatabaseManager(this);

        users = new ArrayList<>();
        User u1 = new User(1, "Hamza", "HABCHI", "M", 25, 1.73, 75, "hamza0habchi@gmail.com",
                "hamzahabchi", "sportif");
        User u2 = new User(2, "Amadou", "KANE", "F", 25, 1.80, 75, "amadoukane@gmail.com",
                "amadoukane", "sportif");
        User u3 = new User(3, "Hamza", "ZOUDANI", "M", 25, 1.70, 75, "hamzazoudani@gmail.com",
                "hamzazoudani", "sportif");
        User u4 = new User(4, "Mustapha", "FEKARI", "M", 25, 1.70, 75, "mustaphafekari@gmail.com",
                "mustaphafekari", "sportif");
        User u5 = new User(5, "Amal", "WESLATI", "M", 25, 1.50, 120, "amalweslati@gmail.com",
                "amalweslati", "boulangère");
        User u6 = new User(5, "Nourhane", "KHALED", "", 0, 0, 0, "", "", "");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
    }

    public void addUsers(View view) {
        for(User u: users){
            sqLiteDatabaseManager.insertUser(u);
        }
    }
}