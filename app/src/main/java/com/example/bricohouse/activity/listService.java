package com.example.bricohouse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.Categorie;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class listService extends AppCompatActivity {
    DatabaseReference RootRef;
    private ArrayAdapter arrayAdpt;
    private ArrayList<String> listOFservice = new ArrayList<String>();
    private ListView lvServices;
    private TextView categorie;
    private TextView selectionner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_service);
        categorie=(TextView) findViewById(R.id.categorie);

        Intent intent= getIntent();
        String categorieSelected = intent.getStringExtra("selected_topic");

        categorie.setText(categorieSelected);
        selectionner=(TextView) findViewById(R.id.selectionner);
        selectionner.setText("   Selectionnez une sous-catégorie");
        lvServices = (ListView) findViewById(R.id.lvServices);
        arrayAdpt = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listOFservice);
        lvServices.setAdapter(arrayAdpt);
        RootRef = FirebaseDatabase.getInstance().getReference();


        if("selected_topic".equals("Jardin et exterieur")){
            findServicesByCategorie("ServicesJardin");
        }

       else{
            findServicesByCategorie("ServicesTravaux");
        }
//___________________________________________________________________________________________________________
        lvServices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(listService.this, listAgence.class);
                i.putExtra("selected_topic", ((TextView)view).getText().toString());
                startActivity(i);
            }
        });
    }
public void findServicesByCategorie(String lServices){

    RootRef.child(lServices).addValueEventListener(new ValueEventListener( ) {

        @Override     public void onDataChange(DataSnapshot dataSnapshot) {
            Set<String> set = new HashSet<String>();
            Iterator i = dataSnapshot.getChildren().iterator();
            while(i.hasNext()){
                set.add(((DataSnapshot)i.next()).getKey());
            }
            arrayAdpt.clear();
            arrayAdpt.addAll(set);
            arrayAdpt.notifyDataSetChanged();     }
        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    });
}




}
