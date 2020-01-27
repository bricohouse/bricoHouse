package com.example.bricohouse.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class tab4 extends Fragment {
    private TextView textView;
    private SeekBar seekBar;
    private Button next;
    int value=0;
    private DatabaseReference RootRef;
    private String currentUserID;
    public static final String EXTRA_PRICE_KEY = "com.example.android.bricohouse.activity.extra.PRICE";
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_tab4, container, false);
        textView=(TextView)v.findViewById(R.id.text4);
        next=(Button)v.findViewById(R.id.butt4);
        mAuth= FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference("Demande");
        seekBar=(SeekBar)v.findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {

                textView.setText(""+i+"DH");
                value=i;
                savedata();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        next.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity().getApplicationContext(), confActivity.class));

            }
        });

        return v;
    }


      private void savedata() {
        final HashMap<String, Object> donnee = new HashMap<>();
        final String price = textView.getText().toString();
        donnee.put("Price", price);
        currentUserID=mAuth.getUid();
        RootRef.child(currentUserID).child("D1").updateChildren(donnee);
        Toast.makeText(getActivity(), " data has been sent", Toast.LENGTH_SHORT).show();
    }
}
