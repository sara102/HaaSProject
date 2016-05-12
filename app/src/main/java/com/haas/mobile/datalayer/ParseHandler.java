package com.haas.mobile.datalayer;

import com.google.gson.Gson;
import com.haas.mobile.datalayer.DTOS.BaseObject;

/**
 * Created by islam on 5/8/16.
 */
public class ParseHandler {

    private static ParseHandler instance = null;

    private ParseHandler() {}

    public static ParseHandler getInstance() {

        synchronized (ParseHandler.class) {

            if (instance == null) {
                instance = new ParseHandler();
            }
        }
        return instance;
    }

    public BaseObject parseJson(String jsonString, Class<BaseObject> t) {

        Gson gson = new Gson();
        return  gson.fromJson(jsonString,t);
    }


}
