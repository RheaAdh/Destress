package com.example.stressmanagementapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.stressmanagementapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mAuth = FirebaseAuth.getInstance();
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