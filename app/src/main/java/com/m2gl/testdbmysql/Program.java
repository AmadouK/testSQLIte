package com.m2gl.testdbmysql;

import java.io.Serializable;

/**
 * Created by Hamza on 05/03/2016.
 */
public class Program implements Serializable {

    private int id;
    private String title;
    private String type;
    private String objective;

    public Program(int id, String title, String type, String objective) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.objective = objective;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
}
