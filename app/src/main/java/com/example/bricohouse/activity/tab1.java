package com.example.bricohouse.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class tab1 extends Fragment {
    private EditText demexemple, demdescription;
    private Button next;
    private DatabaseReference RootRef;
    private String currentUserID;
    private FirebaseAuth mAuth;

    public static final String EXTRA_SERVICE_KEY = "com.example.android.bricohouse.activity.extra.SERVICE";
    public static final String EXTRA_DESCRIPTION_KEY = "com.example.android.bricohouse.activity.extra.DESCRIPTION";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        demexemple = (EditText) v.findViewById(R.id.edit1);
        demdescription = (EditText) v.findViewById(R.id.edit2);
        mAuth=FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference("Demande");
        next = (Button) v.findViewById(R.id.butt1);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dem = demexemple.getText().toString();
                if (dem.isEmpty()) {
                    Toast.makeText(getActivity(), " You should enter a service !!", Toast.LENGTH_SHORT).show();
                } else {
                    savedata();
                    ((demande_activty) (getActivity())).selectfragment(1);

                }
            }
        });
        return v;
    }


    private void savedata() {
        final HashMap<String, Object> donnee = new HashMap<>();
        final String service = demexemple.getText().toString();
        final String description = demdescription.getText().toString();
        donnee.put("service", service);
        donnee.put("description", description);
        //donnee.put("demande_id",currentUserID);
        //currentUserID=RootRef.push().getKey();
        currentUserID = mAuth.getUid();
        RootRef.child(currentUserID).child("D1").setValue(donnee);
        Toast.makeText(getActivity(), " data has been sent", Toast.LENGTH_SHORT).show();
    }


}