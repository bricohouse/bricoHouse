package com.example.bricohouse.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bricohouse.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class confActivity extends AppCompatActivity {
    private TextView service, description, address, Date, Price;
    private DatabaseReference ref;
    private DatabaseReference RootRef;
    private FirebaseAuth mAuth;


    private Button validate, go;
    public confActivity(TextView service,TextView description,TextView address,TextView Date,TextView Price) {
        this.service = service;
        this.description = description;
        this.address = address;
        this.Date = Date;
        this.Price = Price;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf);

        service = (TextView) findViewById(R.id.textView4);
        description = (TextView) findViewById(R.id.textView12);
        address = (TextView) findViewById(R.id.textView15);
        Date = (TextView) findViewById(R.id.textView16);
        Price = (TextView) findViewById(R.id.textView17);
        validate = (Button) findViewById(R.id.button2);


    }
    private void showData(DataSnapshot dataSnapshot) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        RootRef = FirebaseDatabase.getInstance().getReference("Demande");
        Query query = RootRef.orderByChild("service").equalTo(firebaseUser.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String ser = "" + ds.child("service").getValue();
                    String des = "" + ds.child("description").getValue();
                    String add = "" + ds.child("address").getValue();
                    String date = "" + ds.child("Date").getValue();
                    String prix = "" + ds.child("Price").getValue();

                    service.setText(ser);
                    description.setText(des);
                    address.setText(add);
                    Date.setText(date);
                    Price.setText(prix);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}
