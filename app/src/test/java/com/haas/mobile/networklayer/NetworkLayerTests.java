package com.haas.mobile.networklayer;

import android.util.Log;

import com.haas.mobile.networklayer.NetworkHandler;import java.util.HashMap;
import java.util.Map;

import networklayer.NetworkHandler;

/**
 * Created by sara on 5/8/2016.
 */
public class NetworkLayerTests {
    public void httpGetMethodTest()
    {
        NetworkHandler networkHandler = new NetworkHandler();
        Map<String,String> map= new HashMap<>();
        map.put("name","sara");
        try {
           Log.i("------------", networkHandler.httpGet(map,"http://192.168.1.3:8084/Lab4Server/rest/hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void httpPostMethodTest(){
        NetworkHandler networkHandler = new NetworkHandler();
        Map<String,String> map= new HashMap<>();
        map.put("name","mazen");
        try {

            Log.i("------------",networkHandler.httpPost(map,"http://192.168.1.3:8084/Lab4Server/rest/hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
