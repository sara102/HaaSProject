package com.haas.mobile.utilites;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.haas.mobile.application.HaasApplication;


/**
 * Created by sara on 5/8/2016.
 */
public class NetworkUtility {

    public boolean isNetworkAvailable() {
        HaasApplication application=new HaasApplication();
        ConnectivityManager cm = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

}
