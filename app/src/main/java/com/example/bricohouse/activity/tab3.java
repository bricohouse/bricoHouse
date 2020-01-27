package com.example.bricohouse.activity;


import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bricohouse.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.zip.DataFormatException;


public class tab3 extends Fragment {
    private Button next;
    private TextView text1;
    private DatabaseReference RootRef;
    private String currentUserID;
    public static final String EXTRA_DATE_KEY = "com.example.android.bricohouse.activity.extra.DATE";
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab3, container, false);
        next = (Button) v.findViewById(R.id.butt3);
        text1 = (TextView) v.findViewById(R.id.text1);
        mAuth= FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference("Demande");
        text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = "le" + day + "-" + month + "-" + year;
                        text1.setText(date);
                    }
                }, year, month, day);

                calendar.add(Calendar.DATE, 0);

                datePickerDialog.show();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
                ((demande_activty) (getActivity())).selectfragment(3);
            }
        });
        return v;
    }


    private void savedata() {

        final HashMap<String, Object> donnee = new HashMap<>();
        final String date = "le" + day + "-" + month + "-" + year;
        donnee.put("Date", date);
        currentUserID = mAuth.getUid();
        RootRef.child(currentUserID).child("D1").updateChildren(donnee);
        Toast.makeText(getActivity(), " data has been sent", Toast.LENGTH_SHORT).show();
    }
}
