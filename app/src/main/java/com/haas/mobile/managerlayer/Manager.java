package com.haas.mobile.managerlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islam on 5/8/16.
 */
public abstract  class Manager {

    List<UIListener> uiListeners = new ArrayList<>();

    public void addListener(UIListener uiListener) {

        uiListeners.add(uiListener);
    }

    public void removeListener(UIListener uiListener) {

        uiListeners.remove(uiListener);
    }

    public List<UIListener> getListeners() {

        return uiListeners;
    }



}
