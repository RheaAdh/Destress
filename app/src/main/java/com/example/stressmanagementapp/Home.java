package com.example.stressmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void nextPage(){
        Intent intent = new Intent(Home.this,Profile.class);
        startActivity(intent);
        return;
    }
    public void logout(){
        Intent intent = new Intent(Home.this,LoginActivity.class);
        startActivity(intent);
        return;
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