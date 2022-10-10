package com.example.stressmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        String name= getIntent().getStringExtra("name");
        TextView err = (TextView) findViewById(R.id.textView);
        err.setText(name);
    }
}