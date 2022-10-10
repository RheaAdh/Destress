package com.example.stressmanagementapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CareGiver extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver);
        ListView listView=findViewById(R.id.listView);
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari",200,5000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal",300,7000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta",100,9000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari",200,5000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal",300,7000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta",100,9000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari",200,5000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal",300,7000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta",100,9000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari",200,5000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal",300,7000,"rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta",100,9000,"rheadhikari@gmail.com"));

        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,personArrayList);
        listView.setAdapter(personAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
