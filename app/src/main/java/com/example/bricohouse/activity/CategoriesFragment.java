package com.example.bricohouse.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bricohouse.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment  {

    ImageView imageSmall_Works;
    TextView small_Works;

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        small_Works=view.findViewById(R.id.small_Works);
        imageSmall_Works= (ImageView) view.findViewById(R.id.small_Works1);
        imageSmall_Works.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToListServices();
                // catsmall_Works();

            }
        });
        return view;
    }
    public void catsmall_Works(){
        String small_Work = small_Works.getText().toString();
        Intent intent = new Intent(getActivity().getApplicationContext(),listService.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("selected_topic", small_Work );
        startActivity(intent);

        // Intent intent=new Intent(getActivity(),listService.class);
        // intent.putExtra("selected_topic", small_Work);

        //small_Works.setText("");
        // getActivity().startActivity(intent);

    }
    public void goToListServices(){
        Intent intent = new Intent(getActivity(), listService.class);
        startActivity(intent);
    }

}
