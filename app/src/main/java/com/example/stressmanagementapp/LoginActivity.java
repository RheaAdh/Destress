package com.example.stressmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        TextView tv = findViewById(R.id.linkToSignup);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(myIntent);
            }
        });


        Button btnSubmit = findViewById(R.id.btnLogin);
        btnSubmit.setOnClickListener(view -> {
            EditText etName = findViewById(R.id.et1);
            EditText etPass = findViewById(R.id.et2);
            String username = etName.getText().toString();
            String password = etPass.getText().toString();

            Toast.makeText(LoginActivity.this, username + " has logged in!", Toast.LENGTH_LONG).show();
            //if user loggedin is caregiver then (uncomment)
//            Intent intent = new Intent(LoginActivity.this, CareGiver.class);
            //else (that means admin)
            Intent intent = new Intent(LoginActivity.this, Admin.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
    }
}
