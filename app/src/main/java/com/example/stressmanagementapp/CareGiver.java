package com.example.stressmanagementapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CareGiver extends AppCompatActivity {
    FirebaseFirestore db ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver);

        ListView listView=findViewById(R.id.listView);

        ArrayList<Person> personArrayList = new ArrayList<>();
        Log.d("Care giver", "hello ");
//
    // db = FirebaseFirestore.getInstance();
//
//        db.collection("persons")
//                .whereEqualTo("role","patient")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                                           @Override
//                                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                               if(task.isSuccessful()){
//                                                   Log.d("SUCCESSFUL RETRIEVE","");
//
//                                                   for(QueryDocumentSnapshot document : task.getResult()){
//                                                       Person p = document.toObject(Person.class);
//                                                       Person newp = new Person();
//                                                       newp.setName(p.getName());
//                                                       newp.setEmail(p.getEmail());
//                                                       newp.setGender(p.getGender());
//                                                       newp.setRole(p.getRole());
//                                                       newp.setImage(p.getImage());
//                                                       newp.setPassword(p.getPassword());
//                                                       for(Person x:personArrayList){
//                                                           Log.d("XXXXX",x.toString());
//                                                       }
//                                                       personArrayList.add(newp);
//                                                   }
//                                               }
//                                               else{
//                                                   Log.w("TAG","Error",task.getException());
//                                               }
//                                           }
//                                       });



        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari","200","5000","rheadhikari@gmail.com","caregiver"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal","300","7000","pranshul@gmail.com","caregiver"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta","100","9000","juhi@gmail.com","caregiver"));
        personArrayList.add(new Person(R.drawable.girl,"ABC","100","9000","abc@gmail.com","patient"));

        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,personArrayList);
        listView.setAdapter(personAdapter);


        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(CareGiver.this, Profile.class);
            //TextView tv = view.findViewById(R.id.txtCard);

            String name = "test";
            intent.putExtra("name",name);



         //   TextView tv3 = view.findViewById(R.id.txtEmail);
            String email = "email";
            intent.putExtra("email",email);



//                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.imgLeft);
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
//                intent.putExtra("image", byteArray);


            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
