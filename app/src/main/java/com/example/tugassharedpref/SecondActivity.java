package com.example.tugassharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;

    private final String sharedPrefFile = "com.example.sharedpreferenceapp";
    private SharedPreferences mSharedPref;
    private final String KEY_EMAIL = "email";
    private final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.text_email);

        mSharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        String email = mSharedPref.getString(KEY_EMAIL, null);
        String password = mSharedPref.getString(KEY_PASS, null);

        if (email != null || password != null){
            textView.setText(email);
        }


    }
}