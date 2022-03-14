package com.example.fitvita20;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveSharePreferences {

    Context context;
    SharedPreferences sharedPreferences;

    public  SaveSharePreferences(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("preferenced",Context.MODE_PRIVATE);
    }

    public void setstate(Boolean bool){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("editor",bool);
        editor.apply();
    }

    public boolean getstate(){
        return sharedPreferences.getBoolean("editor",false);
    }

}
