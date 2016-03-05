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
                user.put("lastName", u.getLastName());
                user.put("sex", u.getSex());
                user.put("age", u.getAge());
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

    public static String userToJSON(User u) throws JSONException {
        JSONObject user = new JSONObject();
        if(u != null){
            user.put("id", u.getId());
            user.put("name", u.getName());
            user.put("lastName", u.getLastName());
            user.put("sex", u.getSex());
            user.put("age", u.getAge());
            user.put("height", u.getHeight());
            user.put("weight", u.getWeight());
            user.put("email", u.getEmail());
            user.put("password", u.getPassword());
            user.put("status", u.getStatus());
        }
        return user.toString();
    }

    public static String programsToJSON(ArrayList<Program> list) throws JSONException {
        JSONObject programs = new JSONObject();
        JSONArray array = new JSONArray();
        if(!list.isEmpty()){
            for(Program p: list){
                JSONObject program = new JSONObject();
                program.put("id", p.getId());
                program.put("title", p.getTitle());
                program.put("objective", p.getObjective());
                program.put("type", p.getType());
                array.put(program);
            }
        }
        programs.put("programs", array);
        return programs.toString();
    }

    public static String programToJSON(Program p) throws JSONException {

        JSONObject program = new JSONObject();
        if(p != null){
            program.put("id", p.getId());
            program.put("title", p.getTitle());
            program.put("objective", p.getObjective());
            program.put("type", p.getType());
        }
        return program.toString();
    }
}
