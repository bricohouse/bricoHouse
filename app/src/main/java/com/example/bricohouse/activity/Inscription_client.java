package com.example.bricohouse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.Client;
import com.example.bricohouse.bean.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Inscription_client extends AppCompatActivity {
    Client client = new Client();
    Button valider;
    DatabaseReference reff;
    EditText name;
    EditText last_name;
    EditText phone;
    EditText mail;
    EditText adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incription_client);
        //Toast.makeText(Inscription_client.this, "test  firebase", Toast.LENGTH_SHORT).show();\

        name= (EditText) findViewById(R.id.name);
        last_name= (EditText) findViewById(R.id.last_name);
        phone=(EditText) findViewById(R.id.phone);
        mail=(EditText) findViewById(R.id.mail);
        adress=(EditText) findViewById(R.id.adress);
        valider=(Button) findViewById(R.id.valider);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff= database.getInstance().getReference();





            //public void save(User utilisateur){
            // utilisateur.setLogin(utilisateur.getLogin());
        }


    public void save(View view) {
        String prenom= name.getText().toString();
        String nom= last_name.getText().toString();
        String tel=phone.getText().toString();
        String email=mail.getText().toString();
        String adr=adress.getText().toString();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setPhone(tel);
        client.setEmail(email);
        client.setAdresseComplement(adr);
        reff.push().setValue(client);
        Toast.makeText(Inscription_client.this, "test  firebase", Toast.LENGTH_SHORT).show();
    }


    }

