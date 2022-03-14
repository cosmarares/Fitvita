package com.example.fitvita20;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.HashMap;

public class HomeFragment extends Fragment {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    private static DecimalFormat nof = new DecimalFormat("#");

    /// Variabile calculator BMI
    private Button b1, button_calculate_BMI;
    private EditText edittext_weight_BMI, edittext_height_BMI;
    private TextView textview_result_BMI;
    ///

    /// Variabile calculator FFMI
    private Button b2,button_calculate_FFMI;
    private EditText edittext_weight_FFMI, edittext_height_FFMI, edittext_bodyfat_FFMI;
    private TextView textview_result_FFMI;
    ///

    /// Variabile calculator calorii
    private Button b3,button_calculate_CAL;
    private EditText edittext_weight_CAL, edittext_height_CAL, edittext_age_CAL;
    private TextView textview_result_MALE, textview_result_FEMALE;
    ///

    ///Add mancare baza
    private Button b4,button_add_food;
    private EditText edittext_food_name, edittext_calorii, edittext_proteins, edittext_carbs, edittext_fat, edittext_gram;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference root = database.getReference().child("Food Name");
    ///

    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        b1 = (Button) v.findViewById(R.id.BMI);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "TEST", Toast.LENGTH_SHORT).show();
                builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_bmi, null);

                builder.setView(view1);
                alertDialog = builder.create();
                alertDialog.show();
                initWidgetsAllert(view1);


                button_calculate_BMI.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //BMI = Weight in Kg / (Height in m)^2
                        Double rez = Double.parseDouble(edittext_weight_BMI.getText().toString())/
                                Math.pow(Double.parseDouble(edittext_height_BMI.getText().toString()), 2);

                        // Write a message to the database


                        rez *= 10000;

                        textview_result_BMI.setText(df2.format(rez));

                        Toast.makeText(getActivity(), "Incorect", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        b2 = (Button) v.findViewById(R.id.FFMI);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "TEST", Toast.LENGTH_SHORT).show();
                builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_ffmi, null);

                builder.setView(view1);
                alertDialog = builder.create();
                alertDialog.show();
                initWidgetsAllert(view1);


                button_calculate_FFMI.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Lean Weight = Weight in Kg * (1 - (body fat % / 100)
                        Double leanWeight = Double.parseDouble(edittext_weight_FFMI.getText().toString())
                                * (1-(Double.parseDouble(edittext_bodyfat_FFMI.getText().toString())/100));

                        //FFMI = (Lean Weight in Kg / 2.2) * 2.20462 / ((meters) 2

                        Double rez = (leanWeight/2.2) * 2.20462/(Math.pow(Double.parseDouble(edittext_height_FFMI.getText().toString()), 2));
                        rez *= 10000;

                        textview_result_FFMI.setText(df2.format(rez));

                        Toast.makeText(getActivity(), "Incorect", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        b3 = (Button) v.findViewById(R.id.CAL);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "TEST", Toast.LENGTH_SHORT).show();
                builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_calorie, null);

                builder.setView(view1);
                alertDialog = builder.create();
                alertDialog.show();
                initWidgetsAllert(view1);


                button_calculate_CAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //BMR = 10 x weight (kg) + 6.25 x height (cm) – 5 x age (years) + 5 (MALE)
                        Double rezM = 10 * Double.parseDouble(edittext_weight_CAL.getText().toString()) +
                                6.25 * Double.parseDouble(edittext_height_CAL.getText().toString()) -
                                5 * Double.parseDouble(edittext_age_CAL.getText().toString()) + 5;

                        //BMR = 10 x weight (kg) + 6.25 x height (cm) – 5 x age (years) – 161 (FEMALE)
                        Double rezF = 10 * Double.parseDouble(edittext_weight_CAL.getText().toString()) +
                                6.25 * Double.parseDouble(edittext_height_CAL.getText().toString()) -
                                5 * Double.parseDouble(edittext_age_CAL.getText().toString()) - 161;


                        textview_result_MALE.setText(nof.format(rezM));
                        textview_result_FEMALE.setText(nof.format(rezF));

                        Toast.makeText(getActivity(), "Incorect", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        b4 = (Button) v.findViewById(R.id.addfood);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "TEST", Toast.LENGTH_SHORT).show();
                builder = new AlertDialog.Builder(getActivity());
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.alert_food, null);

                builder.setView(view1);
                alertDialog = builder.create();
                alertDialog.show();
                initWidgetsAllert(view1);


                button_add_food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Declarare atribute baza de date
                        String  food_name = edittext_food_name.getText().toString();
                        String  calor = edittext_calorii.getText().toString();
                        String  prot = edittext_proteins.getText().toString();
                        String  fat = edittext_fat.getText().toString();
                        String  carb = edittext_carbs.getText().toString();
                        String  gramaj = edittext_gram.getText().toString();

                        HashMap<String, String> food_data = new HashMap<>();

                        food_data.put("food_name", food_name);
                        food_data.put("calorii", calor);
                        food_data.put("proteine", prot);
                        food_data.put("fat", fat);
                        food_data.put("carbs", carb);
                        food_data.put("gramaj", gramaj);

                        root.push().setValue(food_data);
                        Toast.makeText(getActivity(), "Food Added", Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });

        return v;
    }

    private void initWidgetsAllert(View v) {

        ///BMI
        button_calculate_BMI = (Button) v.findViewById(R.id.button_calculate_BMI);
        edittext_height_BMI = (EditText) v.findViewById(R.id.edittext_height_BMI);
        edittext_weight_BMI = (EditText) v.findViewById(R.id.edittext_weight_BMI);
        textview_result_BMI = (TextView) v.findViewById(R.id.textview_result_BMI);

        ///FFMI
        button_calculate_FFMI = (Button) v.findViewById(R.id.button_calculate_FFMI);
        edittext_height_FFMI = (EditText) v.findViewById(R.id.edittext_height_FFMI);
        edittext_weight_FFMI = (EditText) v.findViewById(R.id.edittext_weight_FFMI);
        edittext_bodyfat_FFMI = (EditText) v.findViewById(R.id.edittext_bodyfatt_FFMI);
        textview_result_FFMI = (TextView) v.findViewById(R.id.textview_result_FFMI);

        ///Calorie Intake
        button_calculate_CAL = (Button) v.findViewById(R.id.button_calculate_CAL);
        edittext_height_CAL = (EditText) v.findViewById(R.id.edittext_height_CAL);
        edittext_weight_CAL = (EditText) v.findViewById(R.id.edittext_weight_CAL);
        edittext_age_CAL = (EditText) v.findViewById(R.id.edittext_age_CAL);
        textview_result_FEMALE = (TextView) v.findViewById(R.id.textview_result_FEMALE);
        textview_result_MALE = (TextView) v.findViewById(R.id.textview_result_MALE);

        //Add food
        button_add_food = (Button) v.findViewById(R.id.button_add_food);
        edittext_food_name = (EditText) v.findViewById(R.id.edittext_food_name);
        edittext_calorii = (EditText) v.findViewById(R.id.edittext_calorii);
        edittext_carbs = (EditText) v.findViewById(R.id.edittext_carbs);
        edittext_fat = (EditText) v.findViewById(R.id.edittext_fat);
        edittext_proteins = (EditText) v.findViewById(R.id.edittext_proteins);
        edittext_gram = (EditText) v.findViewById(R.id.edittext_gram);
    }
}