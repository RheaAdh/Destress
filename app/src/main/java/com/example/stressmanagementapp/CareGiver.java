package com.example.stressmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CareGiver.this, Profile.class);
//                String product = ((TextView) view).getText().toString();
                TextView tv = (TextView)view.findViewById(R.id.txtCard);
                String name = tv.getText().toString();
                intent.putExtra("name",name);
//                String steps = view.findViewById(R.id.txtSteps).toString();
                TextView tv2 = (TextView)view.findViewById(R.id.txtCard);
                String email = tv.getText().toString();
                intent.putExtra("name",name);//                String time = view.findViewById(R.id.txtTime).toString();
//                intent.putExtra("steps",steps);
//                intent.putExtra("time",time);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
