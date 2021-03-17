package com.sazal.sazalscafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, register;
    TextView skip;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Sazal's Cafe");
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Login Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ActivitySignIn.class);
                startActivity(intent);
            }
        });


        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Register Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ActivitySignUp.class);
                startActivity(intent);

            }
        });


        skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Skip", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ActivityHomepage.class);
                startActivity(intent);
            }
        });
    }
}