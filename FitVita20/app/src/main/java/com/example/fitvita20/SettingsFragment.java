package com.example.fitvita20;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;


public class SettingsFragment extends Fragment {
    private Button sptfy,ytb;

    /*private SwitchCompat switch_btn;
    private SaveSharePreferences preference;*/

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        //Dark/Night Mode Toggle
        /*switch_btn = v.findViewById(R.id.switch_btn);
        preference = new SaveSharePreferences(getActivity());

        getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE); //Fullscreen view
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getActivity().setContentView(R.layout.fragment_settings);

        if(preference.getstate() == true){
            ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else{
            ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        if (preference.getstate() == true) {
            switch_btn.setChecked(true);
        }

        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    preference.setstate(true);
                    ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else{
                    preference.setstate(false);
                    ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });*/
        ytb = v.findViewById(R.id.youtube);
        ytb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent openYTB = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getActivity().getPackageManager();
                openYTB = managerclock.getLaunchIntentForPackage("com.google.android.youtube");
                openYTB.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(openYTB);
            }
        });

        sptfy = v.findViewById(R.id.spotify);
        sptfy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent openSPTFY = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getActivity().getPackageManager();
                openSPTFY = managerclock.getLaunchIntentForPackage("com.spotify.music");
                openSPTFY.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(openSPTFY);
            }
        });

        return v;
    }
}