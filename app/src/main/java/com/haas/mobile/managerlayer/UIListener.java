package com.haas.mobile.managerlayer;

/**
 * Created by islam on 5/8/16.
 */
public interface UIListener {

    public void onSuccess(String message);

    public void onFail(Exception ex);
}
