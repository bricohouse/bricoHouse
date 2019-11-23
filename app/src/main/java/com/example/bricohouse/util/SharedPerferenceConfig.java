package com.example.bricohouse.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.example.bricohouse.R;

public class SharedPerferenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPerferenceConfig(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_perfernce), Context.MODE_PRIVATE);

    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_perfernce), status);
         editor.commit();
    }

    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_perfernce), false);
    return status;
    }

}
