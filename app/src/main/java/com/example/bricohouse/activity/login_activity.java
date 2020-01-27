package com.example.bricohouse.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.example.bricohouse.bean.Categorie;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_activity extends AppCompatActivity {
    private EditText Usermail,Userpassword;
    private FirebaseAuth mAuth;
    private Button Login;
    private TextView ForgetPass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        mAuth=FirebaseAuth.getInstance();
        Usermail=(EditText)findViewById(R.id.edusername);
        Userpassword=(EditText)findViewById(R.id.edpassword);
        ForgetPass=(TextView)findViewById(R.id.textinfo);
        Login=(Button)findViewById(R.id.button);
        ForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                ShowRecoverPasswordDialog();
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AllowUserToLogin(); }
        });
    }

    private void ShowRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(login_activity.this);
        builder.setTitle("Recover Password");
        LinearLayout linearLayout=new LinearLayout(login_activity.this);
        final EditText emailrec=new EditText(login_activity.this);
        emailrec.setHint("your email please_________________");
        emailrec.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        linearLayout.addView(emailrec);
        linearLayout.setPadding(10,10,10,10);
        builder.setView(linearLayout);
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=emailrec.getText().toString().trim();
                beginRecovery(email);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();

    }
    //cote Firebase réitilisation du mot de pass
    private void beginRecovery(String email)
    {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(login_activity.this, "Email send to your email,check it please", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(login_activity.this, "Error ,try again!! ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //Autorisation des utilisateur
    private void AllowUserToLogin()
    {
        String email = Usermail.getText().toString();
        String password = Userpassword.getText().toString();
        if((email.isEmpty())&&(password.isEmpty()))
        {
            Toast.makeText(this, "Field are Empty!!!!", Toast.LENGTH_SHORT).show();
        }
        else if(password.isEmpty())
        { Toast.makeText(this, "Please Enter your password", Toast.LENGTH_SHORT).show(); }
        else if (email.isEmpty())
          { Toast.makeText(this, "Please Enter your email", Toast.LENGTH_SHORT).show(); }
        else if (!((email.isEmpty())&&(password.isEmpty()))) {
            mAuth.signInWithEmailAndPassword(email,password) .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        Toast.makeText(login_activity.this, "Logged in Successfully !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login_activity.this,demande_activty.class));
                         }
                    else{
                        String message = task.getException().toString();
                    Toast.makeText(login_activity.this, "Error : " + message, Toast.LENGTH_SHORT).show();
                    } } });
        }

    }




}


