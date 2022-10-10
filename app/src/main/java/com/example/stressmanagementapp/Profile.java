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

        String email= getIntent().getStringExtra("email");
        TextView err1 = (TextView) findViewById(R.id.textView2);
        err1.setText(email);

        String steps= getIntent().getStringExtra("steps");
        TextView err2 = (TextView) findViewById(R.id.textView4);
        err2.setText(steps);

        String time= getIntent().getStringExtra("time");
        TextView err3 = (TextView) findViewById(R.id.textView5);
        err3.setText(time);
    }
}