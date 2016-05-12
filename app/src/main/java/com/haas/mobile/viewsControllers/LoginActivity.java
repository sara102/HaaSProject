package com.haas.mobile.viewsControllers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.haas.R;
import com.haas.mobile.utilites.Validation;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity  {

    private EditText emailEditText;
    private EditText passwordEditText;
    private CheckBox rememberMeCheckBox;
    private TextView forgetYourPasswordTextView;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    @Override
    protected void onStart() {
        super.onStart();
//        emailEditText = (EditText) findViewById(R.id.emailEditText);
//        passwordEditText=(EditText) findViewById(R.id.passwordEditText);
//        rememberMeCheckBox=(CheckBox) findViewById(R.id.rememberMeCheckBox);
//        forgetYourPasswordTextView=(TextView) findViewById(R.id.forget_your_password_link);
//        loginButton= (Button) findViewById(R.id.loginButton);
//
//        loginButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v){
//                if( Validation.isEmailAddress(emailEditText,true) && Validation.hasText(passwordEditText)){
//                        if(rememberMeCheckBox.isChecked())
//                        {
//
//                        }
//
//                }
//            }
//        });
//
//
//        forgetYourPasswordTextView.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//// call web service
//            }
//        });
//
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
//                INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//        return true;
    }
}

