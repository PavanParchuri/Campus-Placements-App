package com.example.campusplacementsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link } factory method to
 * create an instance of this fragment.
 */
public class CTests extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    public CTests() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_c_tests, container, false);
        final Button buttonTest = (Button) v.findViewById(R.id.takeTest1);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make your toast here
                if (v == buttonTest) {
                    Intent intent = new Intent(getActivity(), TestActivity.class);
                    startActivity(intent);
                }
            }
        });
        return v;
        //return inflater.inflate(R.layout.fragment_c_tests, container, false);
    }


}
