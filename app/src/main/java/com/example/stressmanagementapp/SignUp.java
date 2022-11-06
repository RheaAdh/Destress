package com.example.stressmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUp extends AppCompatActivity {

    FirebaseFirestore db ;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_screen);
        mAuth = FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();

        TextView tv2 = findViewById(R.id.linkToLogin);

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SignUp.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });


        EditText etName = findViewById(R.id.etName);

        EditText etEmail = findViewById(R.id.etEmail);
        EditText etConfirmPassword = findViewById(R.id.etConfirmPassword);
        EditText etPassword = findViewById(R.id.etPassword);



        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String name =etName.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                RadioGroup radioGender = findViewById(R.id.radio_gender);
                CheckBox caregiverCheck = findViewById(R.id.caregiver_checkbox);
                if(!(password.equals(confirmPassword))){
                    Toast.makeText(SignUp.this, "Password and confirm password dont match", Toast.LENGTH_LONG).show();
                }
                else{
                    final String gender =
                            ((RadioButton)findViewById(radioGender.getCheckedRadioButtonId()))
                                    .getText().toString();
                    String role="patient";
                    if(caregiverCheck.isChecked()){
                        role="caregiver";
                    }
                    Person p = new Person(R.drawable.girl,name,email,role,password,gender);
                    Log.d("Username password", email + password);
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener((result)->{
                       if(result.isSuccessful()){
                           db.collection("persons")
                                   .add(p)
                                   .addOnSuccessListener(r->{
                                       Toast.makeText(SignUp.this, "User registered successfully", Toast.LENGTH_LONG).show();
                                       Intent intent = new Intent(SignUp.this, LoginActivity.class);
                                       startActivity(intent);
                                   })
                                   .addOnFailureListener(r->{
                                       Log.d("ERROR", r.toString());
                                       Toast.makeText(SignUp.this, "User couldn't be registered", Toast.LENGTH_LONG).show();
                                   });
                       }else{
                           Log.d("ERROR", "Firebase authentication error creating new user");
                           Toast.makeText(SignUp.this, "User couldn't be registered", Toast.LENGTH_LONG).show();

                       }
                    });




                }

            }
        });





    }
}
