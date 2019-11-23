package com.example.bricohouse.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.User;
import com.example.bricohouse.util.SessionUtil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainInscription extends AppCompatActivity {
    Spinner spinner;
    EditText login;
    EditText password;
    Spinner typeCompte;
    User utilisateur=new User();
    Button valider;
    DatabaseReference reff;
    User user;
    public static final  String SHARED_PREFS = "sharedPrefs";
    public static final  String USER_ID = "user_id" ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(R.layout.inscription);

        spinner =(Spinner) findViewById(R.id.typeCompte);
        List<String> list = new ArrayList<>();
        list.add("SELECT-ONE");
        list.add("Client");
        list.add("Agence");
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapt);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemValue =parent.getItemAtPosition(position).toString();
                Toast.makeText(MainInscription.this, "select:"+itemValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        login= (EditText) findViewById(R.id.login);
        password= (EditText) findViewById(R.id.password);
        typeCompte=(Spinner) spinner;
        valider=(Button) findViewById(R.id.valider);
        reff= FirebaseDatabase.getInstance().getReference();
    // valider.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   String log= login.getText().toString();
               // String pass= password.getText().toString();
               // String tyUser=typeUser.getSelectedItem().toString();
                //utilisateur.setLogin(log);
          //      utilisateur.setPassword(pass);
          //      utilisateur.setTypeUser(tyUser);
                // save(utilisateur);
         //       reff.push().setValue(utilisateur);
         //       Toast.makeText(MainInscription.this, "data inserted succesfully:", Toast.LENGTH_LONG).show();
        //   }
        //});




        //public void save(User utilisateur){
        // utilisateur.setLogin(utilisateur.getLogin());
    }




//  utilisateur.setPassword(utilisateur.getPassword());

    // }
     public void save(View view) {
      String log= login.getText().toString();
     String pass= password.getText().toString();
      String tyUser=typeCompte.getSelectedItem().toString();
     utilisateur.setLogin(log);
        utilisateur.setPassword(pass);
         utilisateur.setTypeCompte(tyUser);
         reff.push().setValue(utilisateur);
         System.out.println("haaaaahowaaaaa client =====>>   "+utilisateur);

         session(utilisateur);
     }

public void session(User utilisateur ){
    //SessionUtil.setAttribute("login", utilisateur);
    if(utilisateur.getTypeCompte().equalsIgnoreCase("Client")){
        Toast.makeText(MainInscription.this, "dakhal l'Client", Toast.LENGTH_LONG).show();

        final Intent i=new Intent(this, Inscription_client.class);
        SessionUtil.setAttribute("login", utilisateur);

        startActivity(i);
    }
    else {
        Intent i = new Intent(this, MainInscriptionAgence.class);
        startActivity(i);
    }
}





}

