package com.example.stressmanagementapp.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stressmanagementapp.R;
import com.example.stressmanagementapp.helpers.PersonAdapter;
import com.example.stressmanagementapp.models.Person;

import java.util.ArrayList;

public class PatientFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_patients, container, false);

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(R.drawable.girl,"Rhea Adhikari","rheadhikari@gmail.com","caregiver","rhea","female"));
        personArrayList.add(new Person(R.drawable.boy,"Pranshul Goyal","pranshul@gmail.com","caregiver","rhea","male"));
        personArrayList.add(new Person(R.drawable.girl,"Juhi Mehta","juhi@gmail.com","caregiver","juhi","female"));
        personArrayList.add(new Person(R.drawable.girl,"ABC","abc@gmail.com","patient","abc","female"));

        ArrayList<Person> patientArrayList = new ArrayList<>();

        for(int i=0;i<personArrayList.size();i++){
            if(personArrayList.get(i).role == "patient" ) patientArrayList.add(personArrayList.get(i));
        }

        ListView listViewPatients = root.findViewById(R.id.listViewPatients);

        PersonAdapter personAdapter1 = new PersonAdapter(root.getContext(), R.layout.list_row_admin,patientArrayList);
        listViewPatients.setAdapter(personAdapter1);

        listViewPatients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(root.getContext(), Profile.class);
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