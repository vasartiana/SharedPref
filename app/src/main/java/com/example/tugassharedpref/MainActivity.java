package com.example.tugassharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editEmail, editPass;
    Button login;

    private final String sharedPrefFile = "com.example.sharedpreferenceapp";
    private SharedPreferences mSharedPref;
    private final String KEY_EMAIL = "email";
    private final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.email);
        editPass = findViewById(R.id.password);
        login = findViewById(R.id.login_btn);

        mSharedPref = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        String email = mSharedPref.getString(KEY_EMAIL, null);
        if (email != null){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = mSharedPref.edit();
                editor.putString(KEY_EMAIL, editEmail.getText().toString());
                editor.putString(KEY_PASS, editPass.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "login berhasil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}