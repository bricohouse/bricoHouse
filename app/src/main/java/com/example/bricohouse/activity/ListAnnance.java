package com.example.bricohouse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.Agence;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListAnnance extends AppCompatActivity {

    private TextView service;
    private TextView selectionner;
    private ListView lvAnnance;
    private ArrayList<String> listOFAnnances=new ArrayList<>();
    private ArrayList<Agence> agences= new ArrayList<>();
    private ArrayAdapter arrayAdapter;
    private DatabaseReference RootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_annance);




            //_____________________________________
            Intent intent=getIntent();
            String serviceSelected=intent.getStringExtra("selected_topic");
            //______________________________________________
            service=(TextView)findViewById(R.id.service);
            service.setText(serviceSelected);
            selectionner=(TextView)findViewById(R.id.selectionner);
            selectionner.setText("Selectionnez Une Annance ");
            lvAnnance=(ListView)findViewById(R.id.lvAnnance);
            arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listOFAnnances);
             lvAnnance.setAdapter(arrayAdapter);
            //______________________filtrer la list________________________
            arrayAdapter.getFilter().filter(serviceSelected);
            arrayAdapter.notifyDataSetChanged();
              findListOfAnnances();
            //_____________________________________________________________
            RootRef = FirebaseDatabase.getInstance().getReference();
        }


        public void findListOfAnnances(){

            RootRef.child("Annance").addValueEventListener(new ValueEventListener( ) {

                @Override     public void onDataChange(DataSnapshot dataSnapshot) {
                    Set<String> set = new HashSet<String>();
                    Iterator i = dataSnapshot.getChildren().iterator();
                    while(i.hasNext()){
                        set.add(((DataSnapshot)i.next()).getKey());
                    }
                    arrayAdapter.clear();
                    arrayAdapter.addAll(set);
                    arrayAdapter.notifyDataSetChanged();     }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }

    }

