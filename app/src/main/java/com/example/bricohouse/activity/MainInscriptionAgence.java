package com.example.bricohouse.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.Agence;
import com.example.bricohouse.bean.User;

public class MainInscriptionAgence extends AppCompatActivity {
    com.example.bricohouse.activity.MainInscription MainInscription;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(R.layout.inscription_agence);
    }
    public void creatAgence (User utilisateur, Agence agence){
       // mainInscrition.save(utilisateur);

        agence.setEmail(agence.getEmail());
        agence.setNom(agence.getNom());
        agence.setNombreEmploye(agence.getNombreEmploye());
        agence.setSiteWeb(agence.getSiteWeb());
        agence.setPhone(agence.getPhone());
        agence.setDescription(agence.getDescription());
        agence.setAdresseComplement(agence.getAdresseComplement());
        agence.setVille(agence.getVille());
        agence.setSecteur(agence.getSecteur());

    }
}
