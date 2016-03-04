package com.m2gl.testdbmysql;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hamza on 04/03/2016.
 */
public class JSONConverter  {

    public static String usersToJSON(ArrayList<User> list) throws JSONException {
        JSONObject users = new JSONObject();
        JSONArray array = new JSONArray();
        if(!list.isEmpty()){
            for(User u: list){
                JSONObject user = new JSONObject();
                user.put("id", u.getId());
                user.put("name", u.getName());
                user.put("lastName", u.getId());
                user.put("sex", u.getId());
                user.put("age", u.getId());
                user.put("height", u.getHeight());
                user.put("weight", u.getWeight());
                user.put("email", u.getEmail());
                user.put("password", u.getPassword());
                user.put("status", u.getStatus());
                array.put(user);
            }
        }

        users.put("users", array);
        return users.toString();
    }
}
