package com.example.stressmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CareGiverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root;
        root = inflater.inflate(R.layout.fragment_care_givers, container, false);

        ListView listViewCaregivers = root.findViewById(R.id.listViewCaregivers);


        ArrayList<Person> personArrayList = new ArrayList<>();
//        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari","200","5000","rheadhikari@gmail.com","caregiver"));
//        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal","300","7000","pranshul@gmail.com","caregiver"));
//        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta","100","9000","juhi@gmail.com","caregiver"));
//        personArrayList.add(new Person(R.drawable.girl,"ABC","100","9000","abc@gmail.com","patient"));

        ArrayList<Person> caregiversArrayList = new ArrayList<>();

        for(int i=0;i<personArrayList.size();i++){
            if(personArrayList.get(i).role == "caregiver" ) {
                caregiversArrayList.add(personArrayList.get(i));
//                Log.d("person i",caregiversArrayList.get(i).getName());
            }
        }


        PersonAdapter personAdapter2 = new PersonAdapter(root.getContext(),R.layout.list_row_admin,caregiversArrayList);
        listViewCaregivers.setAdapter(personAdapter2);

        listViewCaregivers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), Profile.class);
                TextView tv = (TextView)view.findViewById(R.id.txtCard1);
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

//                Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.id.imgLeft);
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
//                intent.putExtra("image", byteArray);


                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.list_row_admin, container, false);
    }
}