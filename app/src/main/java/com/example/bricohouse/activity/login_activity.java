package com.example.bricohouse.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bricohouse.R;

public class login_activity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        name = (EditText) findViewById(R.id.edusername);
        password = (EditText) findViewById(R.id.edpassword);
        //info=(TextView)findViewById(R.id.textinfo);
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());

            }
        });}
    private void validate(String Username,String Userpassword)
    {
        if((Username.equals("oumaima"))&&(Userpassword.equals("1234")))
        {
            Intent intent=new Intent(login_activity.this,home.class);
            startActivity(intent);
        }
        else if((Username!="oumaima")&&(Userpassword.equals("1234")))
        {
            name.setError("name error");
        }
        else
        {
            password.setError("password error");
        }
        if ((Username.length()==0))
        {
            //info.setText("Forgot your password ?");
            // msg.setError("somthing missed§!!!!");
            name.setError("enter name");
        }
        else if((Userpassword.length()==0))
        {
            password.setError("enter password");
        }

    }
}
