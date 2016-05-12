package com.haas.mobile.viewsControllers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.haas.R;
import com.haas.mobile.utilites.Validation;

public class RegistrationActivity extends Activity {

    private EditText firstNameEditText ;
    private EditText lastNameEditText ;
    private EditText passwordEditText ;
    private EditText confirmPasswordEditText ;
    private EditText emailEditText ;
    private EditText mobileEditText ;
    private Button   registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firstNameEditText=(EditText) findViewById(R.id.registrationFirstNameEditText);
        lastNameEditText=(EditText) findViewById(R.id.registrationLastNameEditText);
        passwordEditText=(EditText) findViewById(R.id.registrationPasswordEditText);
        confirmPasswordEditText=(EditText) findViewById(R.id.registrationConfirmPasswordEditText);
        emailEditText=(EditText) findViewById(R.id.registrationEmailEditText);
        mobileEditText=(EditText) findViewById(R.id.registrationMobileEditText);
        registerButton=(Button) findViewById(R.id.registerButton);
        firstNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Validation.hasText(firstNameEditText);
            }
        });
        lastNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Validation.hasText(lastNameEditText);
            }
        });
        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Validation.hasText(passwordEditText);
            }
        });
        confirmPasswordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Validation.isPasswordMatched(passwordEditText,confirmPasswordEditText);

            }

        });
        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Validation.isEmailAddress(emailEditText,true);
            }
        });
        mobileEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Validation.isPhoneNumber(mobileEditText,true);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Validation.hasText(firstNameEditText) && Validation.hasText(lastNameEditText) && Validation.hasText(passwordEditText)
                        && Validation.hasText(confirmPasswordEditText) && Validation.hasText(mobileEditText) && Validation.isPasswordMatched(passwordEditText,confirmPasswordEditText) ){
                            Log.i("----------","pass");
                }
            }
        });


    }

}
