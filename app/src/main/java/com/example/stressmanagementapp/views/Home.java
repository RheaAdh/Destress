package com.example.stressmanagementapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stressmanagementapp.R;
import com.example.stressmanagementapp.helpers.PatientDbAdapter;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    FirebaseAuth mAuth;
    PatientDbAdapter patientDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mAuth = FirebaseAuth.getInstance();
        TextView tv = (TextView) findViewById(R.id.profileName);
        tv.setText(mAuth.getCurrentUser().getEmail());
        TextView dateTime = (TextView) findViewById(R.id.dateTime);
        TextView stepCount = (TextView) findViewById(R.id.steps);
        TextView meditateTime = (TextView) findViewById(R.id.meditateTime);
        Button submitButton = (Button) findViewById(R.id.btnSubmit);
        patientDbAdapter = new PatientDbAdapter(this);
        submitButton.setOnClickListener(view->{

            patientDbAdapter.InsertRecord(mAuth.getCurrentUser().getEmail(),stepCount.toString(),
                    meditateTime.toString(),dateTime.toString());
//            Log.d(mAuth.getCurrentUser().getEmail(),"");
//            Toast.makeText(Home.this, "Details", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void nextPage(){
        Intent intent = new Intent(Home.this, Profile.class);
        startActivity(intent);
    }
    public void logout(){
        mAuth.signOut();
        Intent intent = new Intent(Home.this, LoginActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
        switch (item.getItemId()) {
            case R.id.activity:
                nextPage();
                return true;
            case R.id.signout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}