package com.example.bricohouse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bricohouse.MainActivity;
import com.example.bricohouse.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class listCategorie extends AppCompatActivity {
    DatabaseReference RootRef;
    private ArrayAdapter arrayAdpt;
    private ArrayList<String> listOFcategorie = new ArrayList<String>();
    private ListView lvCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_categorie);
        lvCategories = (ListView) findViewById(R.id.lvCategories);
        arrayAdpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listOFcategorie);
        lvCategories.setAdapter(arrayAdpt);
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.child("Categorie").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();
                while (i.hasNext()) {
                    set.add(((DataSnapshot) i.next()).getKey());
                }
                arrayAdpt.clear();
                arrayAdpt.addAll(set);
                arrayAdpt.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(listCategorie.this, listService.class);
                i.putExtra("selected_topic", ((TextView)view).getText().toString());
                startActivity(i);
            }
        });

    }
}

