package com.haas.mobile.datalayer.DTOS;


/**
 * Created by islam on 5/8/16.
 */
public class User extends BaseObject {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
