package com.haas.mobile.managerlayer;



import com.haas.mobile.viewsControllers.HomeActivity;

import java.util.List;

/**
 * Created by islam on 5/8/16.
 */
public class UserManager extends Manager {

    private String userName;
    private String password;
    private static UserManager instance = null;

    private UserManager() { }


    public static UserManager getInstance() {

        synchronized (UserManager.class) {

            if (instance == null) {
                instance = new UserManager();
            }
        }

        return instance;

    }

    public void signUp(String email, String password) {

        if (email.equals("islam") && password.equals("111111")) {

            List<UIListener> listeners = getListeners();

            for (UIListener listener : listeners) {

                System.out.println("search for right listener" + listener);


                if (listener instanceof HomeActivity) {

                    System.out.println("call onSuccess");
                    listener.onSuccess("username and password are correct");
                }
            }
        }

    }

}
