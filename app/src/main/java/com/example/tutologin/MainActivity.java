package com.example.tutologin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    public final static String LOGIN_DATA = "mLoginText";
    private EditText mLoginEditText,mEmailEditText,mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginEditText = findViewById(R.id.main_edittext_login);
        mEmailEditText = findViewById(R.id.main_edittext_email);
        mPasswordEditText = findViewById(R.id.main_edittext_password);
        mLoginButton = findViewById(R.id.main_button_log);

        mLoginButton.setOnClickListener(v -> {
            if (validateLogin()){
                callHome();
            }
        });
    }
    private boolean validateLogin(){
        if (mEmailEditText.getText().toString().equals("admin@admin.com") &&
                mPasswordEditText.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Login successful",Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Wrong login",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public void callHome(){
        Intent i = new Intent(MainActivity.this,HomeActivity.class);
        i.putExtra(LOGIN_DATA, mLoginEditText.getText().toString());
        startActivity(i);
    }
}