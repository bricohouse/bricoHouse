package com.example.bricohouse.activity;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static android.content.Context.LOCATION_SERVICE;
import static androidx.core.content.ContextCompat.*;
import static androidx.core.content.ContextCompat.checkSelfPermission;


public class tab2 extends Fragment {
    private EditText add;
    private Button next;
    private TextView position;
    private DatabaseReference RootRef;
    private String currentUserID;
    public static final String EXTRA_ADDRESS_KEY = "com.example.android.bricohouse.activity.extra.ADDRESS";
    private FirebaseAuth mAuth;



   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    getLocation();
                break;
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        add = v.findViewById(R.id.edit3);
        next = v.findViewById(R.id.butt2);
        mAuth= FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference("Demande");
        position = v.findViewById(R.id.text2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savedata();
                ((demande_activty)(getActivity())).selectfragment(2);
            }
        });

        return v;

    }

        private void savedata() {
        final HashMap<String, Object> donnee = new HashMap<>();
        final String address = add.getText().toString();
        donnee.put("address", address);
        currentUserID=mAuth.getUid();
        RootRef.child(currentUserID).child("D1").updateChildren(donnee);
        Toast.makeText(getActivity(), " data has been sent", Toast.LENGTH_SHORT).show();
    }
}
