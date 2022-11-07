package com.example.stressmanagementapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stressmanagementapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        db = FirebaseFirestore.getInstance();
        TextView tv = findViewById(R.id.linkToSignup);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(myIntent);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        Button btnSubmit = findViewById(R.id.btnLogin);
        btnSubmit.setOnClickListener(view -> {
            EditText etName = findViewById(R.id.et1);
            EditText etPass = findViewById(R.id.et2);
            String username = etName.getText().toString();
            String password = etPass.getText().toString();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {
                CollectionReference persons = db.collection("persons");
                Query query = persons.whereEqualTo("email", currentUser.getEmail());
                query.get().addOnCompleteListener((u) -> {
                    if (u.isSuccessful()) {
                        for (QueryDocumentSnapshot snapshot : u.getResult()) {
                            if (Objects.equals((String) snapshot.getData().get("role"), "patient")) {
                                Toast.makeText(LoginActivity.this, (String) snapshot.getData().get("name") + " has logged in!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, Home.class);
                                intent.putExtra("username", (String) snapshot.getData().get("name"));
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, (String) snapshot.getData().get("name") + " has logged in!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, CareGiver.class);
                                intent.putExtra("username", (String) snapshot.getData().get("name"));
                                startActivity(intent);
                            }
                        }
                    }
                });
            } else {
                mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener((result) -> {
                    if (result.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();

                        if (user != null) {
                            CollectionReference persons = db.collection("persons");
                            Query query = persons.whereEqualTo("email", username);
                            query.get().addOnCompleteListener((u) -> {
                                if (u.isSuccessful()) {
                                    for (QueryDocumentSnapshot snapshot : u.getResult()) {
                                        if (Objects.equals((String) snapshot.getData().get("role"), "patient")) {
                                            Toast.makeText(LoginActivity.this, (String) snapshot.getData().get("name") + " has logged in!", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(LoginActivity.this, Home.class);
                                            intent.putExtra("username", (String) snapshot.getData().get("name"));
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(LoginActivity.this, (String) snapshot.getData().get("name") + " has logged in!", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(LoginActivity.this, CareGiver.class);
                                            intent.putExtra("username", (String) snapshot.getData().get("name"));
                                            startActivity(intent);
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            CollectionReference persons = db.collection("persons");
            Query query = persons.whereEqualTo("email", currentUser.getEmail());
            query.get().addOnCompleteListener((u) -> {
                if (u.isSuccessful()) {
                    for (QueryDocumentSnapshot snapshot : u.getResult()) {
                        if (Objects.equals((String) snapshot.getData().get("role"), "patient")) {
                            Toast.makeText(LoginActivity.this, (String) snapshot.getData().get("name") + " has logged in!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, Home.class);
                            intent.putExtra("username", (String) snapshot.getData().get("name"));
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, (String) snapshot.getData().get("name") + " has logged in!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, CareGiver.class);
                            intent.putExtra("username", (String) snapshot.getData().get("name"));
                            startActivity(intent);
                        }
                    }
                }
            });
        }
    }
}
