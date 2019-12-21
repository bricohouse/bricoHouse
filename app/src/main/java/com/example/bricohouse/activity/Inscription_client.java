package com.example.bricohouse.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bricohouse.R;
import com.example.bricohouse.bean.Client;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;



public class Inscription_client extends AppCompatActivity {
    Client client = new Client();
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private String currentUserID;
    Button valider;
    EditText name;
    EditText last_name;
    EditText phone;
    EditText adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incription_client);
        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference();
        name = (EditText) findViewById(R.id.name);
        last_name = (EditText) findViewById(R.id.last_name);
        phone = (EditText) findViewById(R.id.phone);
        adress = (EditText) findViewById(R.id.adress);
        valider = (Button) findViewById(R.id.valider);

        valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SaveClient();

            }
        });

    }

    private void SaveClient() {
        final HashMap<String, Object> donnee = new HashMap<>();
        final String prenom = name.getText().toString();
        final String nom = last_name.getText().toString();
        final String tel = phone.getText().toString();
        final String adr = adress.getText().toString();


        donnee.put("user_id", currentUserID);
        donnee.put("nom", nom);
        donnee.put("prenom", prenom);
        donnee.put("phone", tel);
        donnee.put("adress", adr);

        if ((TextUtils.isEmpty(nom)) || (TextUtils.isEmpty(prenom))) {
            Toast.makeText(this, "Entrez votre nom complet, svp!", Toast.LENGTH_LONG).show();

        } else {
            RootRef.child("Users").child(currentUserID).child("TypeCompte").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue().equals("Client")) {

                        RootRef.child("Client").child(currentUserID).setValue(donnee)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(Inscription_client.this, "votre compte est bien cree", Toast.LENGTH_SHORT).show();
                                            SendUserToPrincipalActivity();
                                        } else {
                                            String message = task.getException().toString();
                                            Toast.makeText(Inscription_client.this, "Erreur: " + message, Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                    }else{
                        Toast.makeText(Inscription_client.this, "Veuillez Compléter votre profil!", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        }
    }

    private void SendUserToPrincipalActivity() {
        Intent principalIntent = new Intent(Inscription_client.this,Inscription_client.class);
        startActivity(principalIntent);
    }

}



