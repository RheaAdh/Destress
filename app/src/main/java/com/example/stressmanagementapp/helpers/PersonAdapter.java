package com.example.stressmanagementapp.helpers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.stressmanagementapp.R;
import com.example.stressmanagementapp.models.Person;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context mContext;
    private int mResource;
    FirebaseFirestore db ;


    public PersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        db = FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Log.d("SUP", "getView: sup");
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imgLeft);
        TextView txtName = convertView.findViewById(R.id.txtCard);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);

        imageView.setImageResource(getItem(position).getImage());
        txtName.setText(getItem(position).getName());
        //txtEmail.setText(getItem(position).getEmail());

        return convertView;
    }

    @Override
    public int getCount()
    {
         return 4;
    }
}
