package com.example.stressmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        Button btnSubmit = findViewById(R.id.btnLogin);
        btnSubmit.setOnClickListener(view -> {
            EditText etName = findViewById(R.id.et1);
            EditText etPass = findViewById(R.id.et2);
            String username = etName.getText().toString();
            String password = etPass.getText().toString();

            Toast.makeText(LoginActivity.this, username + "has logged in!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(LoginActivity.this, CareGiver.class);
//            Intent intent = new Intent(LoginActivity.this, Admin.class);
//            Intent intent = new Intent(LoginActivity.this, Profile.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
    }
}
