package com.example.stressmanagementapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CareGiver extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver);
        ListView listView=findViewById(R.id.listView);
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari","200","5000","rheadhikari@gmail.com"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal","300","7000","pranshul@gmail.com"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta","100","9000","juhi@gmail.com"));


        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,personArrayList);
        listView.setAdapter(personAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CareGiver.this, Profile.class);
                TextView tv = (TextView)view.findViewById(R.id.txtCard);
                String name = tv.getText().toString();
                intent.putExtra("name",name);

                TextView tv2 = (TextView)view.findViewById(R.id.txtSteps);
                String steps = tv2.getText().toString();
                intent.putExtra("steps",steps);

                TextView tv3 = (TextView)view.findViewById(R.id.txtEmail);
                String email = tv3.getText().toString();
                intent.putExtra("email",email);

                TextView tv4 = (TextView)view.findViewById(R.id.txtTime);
                String time = tv4.getText().toString();
                intent.putExtra("time",time);

                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.imgLeft);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);


                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
