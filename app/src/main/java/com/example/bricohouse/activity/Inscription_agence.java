package com.example.bricohouse.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.Agence;
import com.example.bricohouse.bean.Secteur;
import com.example.bricohouse.bean.Service;
import com.example.bricohouse.bean.Ville;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Inscription_agence extends AppCompatActivity {

    Agence agence = new Agence();
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private String currentUserID;
    Spinner spinner;
    Spinner spinner1;
    Spinner cateSpinner;
    Spinner serviceSpinner;
    Spinner villeSpinner;
    ArrayList<String> listOFcategories= new ArrayList<>();
    ArrayList<String> listOFservices= new ArrayList<>();
    ArrayList<String> listOFvilles= new ArrayList<>();
    ArrayAdapter<String> adapt;
    ArrayAdapter<String> adaptVille;
    ArrayAdapter adaptServ;

    Spinner ville;
    EditText discription;


    Spinner service;
    Spinner catego;
    Button inscp;
    String login;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_agence);
        RootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
//        currentUserID = mAuth.getCurrentUser().getUid();
        //----------------------SpinnerCategorie------------------------------
        cateSpinner=(Spinner) findViewById(R.id.categorie);
         adapt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listOFcategories);
         //adapt = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listOFcategories);

        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cateSpinner.setAdapter(adapt);

        RootRef.child("Categorie").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();

                Iterator i = dataSnapshot.getChildren().iterator();
                while (i.hasNext()) {
                    set.add(((DataSnapshot) i.next()).getKey());
                }

                listOFcategories.clear();
                listOFcategories.addAll(set);
                adapt.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

         cateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemValue =parent.getItemAtPosition(position).toString();
                Toast.makeText(Inscription_agence.this, "select:"+itemValue, Toast.LENGTH_SHORT).show();
               // Intent intent = new Intent(Inscription_agence.this,Inscription_agence.class);
               // intent.putExtra("selected_categorie", itemValue );
                System.out.printf("hahowa categorie selectionner --------èèèè  %s%n", itemValue);
                if (("Jardin et exterieur").equals(itemValue) ) {
                    findSeviceByCategorie("ServicesJardin");
                }
                if (("Connected home and Comfort").equals(itemValue) ) {
                    findSeviceByCategorie("Service-Maison");
                }
                if (("Electricity and Lighting").equals(itemValue) ) {
                    findSeviceByCategorie("Service-electricity");
                }
                if (("Garden and Outdoor").equals(itemValue) ) {
                    findSeviceByCategorie("Service-Garden-and-outdoor");
                }
                if (("General Services").equals(itemValue) ) {
                    findSeviceByCategorie("Service-Generaux");
                }
                if (("Painting,Floor and Wall").equals(itemValue) ) {
                    findSeviceByCategorie("Service-Painting");
                }
                if (("Plumbing and Kitchen").equals(itemValue) ) {
                    findSeviceByCategorie("Service-Plumbing");
                }
                if (("Small Works").equals(itemValue) ) {
                    findSeviceByCategorie("service_Odd-jobs");
                }
                else{
                    findSeviceByCategorie("ServicesTravaux");
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


         });

        //---------------------------------------------------------------------
        //------------------------------------SPINNER_SERVICE------------------------------------------


        serviceSpinner=(Spinner) findViewById(R.id.sevice);
        adaptServ = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listOFservices);
        adaptServ.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceSpinner.setAdapter(adaptServ);


        serviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemValue =parent.getItemAtPosition(position).toString();
                Toast.makeText(Inscription_agence.this, "select:"+itemValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        //-----------------------------------------------------------------------------------

        villeSpinner =(Spinner) findViewById(R.id.ville);

        adaptVille = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listOFvilles);

        adaptVille.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        villeSpinner.setAdapter(adaptVille);

        RootRef.child("Ville").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();
                while (i.hasNext()) {
                    set.add(((DataSnapshot) i.next()).getKey());
                }
                listOFvilles.clear();
                listOFvilles.addAll(set);
                adaptVille.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        villeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemValue =parent.getItemAtPosition(position).toString();
                Toast.makeText(Inscription_agence.this, "select:"+itemValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ville= (Spinner) villeSpinner;
        discription= (EditText) findViewById(R.id.discription);

       // mail= (EditText) findViewById(R.id.email);
        service=(Spinner) serviceSpinner;
        catego=(Spinner) cateSpinner;
        inscp=(Button) findViewById(R.id.inscription);

        inscp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SaveClient();

            }
        });

    }



    private void SaveClient() {
        final HashMap<String, Object> annances = new HashMap<>();


        final String city= (String) ville.getSelectedItem();
        final String categorie= (String) catego.getSelectedItem();
        final String descr= discription.getText().toString();
        final String ser=(String) service.getSelectedItem();



        annances.put("ville", city);
        annances.put("description", descr);
        annances.put("service", ser);
        annances.put("categorie", categorie);

        RootRef.child("Annance").setValue(annances)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Inscription_agence.this, "votre compte est bien cree", Toast.LENGTH_SHORT).show();
                            SendUserToPrincipalActivity();
                        } else {
                            String message = task.getException().toString();
                            Toast.makeText(Inscription_agence.this, "Erreur: " + message, Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    private void SendUserToPrincipalActivity() {
        Intent principalIntent = new Intent(Inscription_agence.this,accueil.class);
        startActivity(principalIntent);
    }
    private void findSeviceByCategorie(String lServices){

        RootRef.child(lServices).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Set<String> set = new HashSet<String>();
                Iterator i = dataSnapshot.getChildren().iterator();
                while (i.hasNext()) {
                    set.add(((DataSnapshot) i.next()).getKey());
                }
                listOFservices.clear();
                listOFservices.addAll(set);
                adaptServ.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }


              public void categorieSelectedTest(View view){
   // Intent intent= getIntent();
    //String categorieSelected =intent.getStringExtra("selected_categorie");
    Spinner categorie=(Spinner) cateSpinner;
    final String categorieSelected = (String) categorie.getSelectedItem().toString();
    //String categorieSelected = (String) categorie.getSelectedItem();
    //String satSt =(String) categorieSelected.getNom();
    System.out.println("hahowa categorie selectionner --------èèèè  "+categorieSelected);

    if(RootRef.child("Categorie").child("Jardin et exterieur").child("nom").equals(categorieSelected)){
        findSeviceByCategorie("ServicesJardin");
    }
    else{
        findSeviceByCategorie("ServicesTravaux");
    }

}



}



