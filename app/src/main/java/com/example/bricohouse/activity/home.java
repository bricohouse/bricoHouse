package com.example.bricohouse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bricohouse.R;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Intent i=new Intent(this, Inscription_client.class);
    }

    public void signin(View view) {
        Intent intent=new Intent(home.this,login_activity.class);
        startActivity(intent);
    }
}
