package com.example.fitvita20;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MuscleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MuscleFragment extends Fragment {

    ListView listView;
    String[] muscleNames = {"Bench Press","Chest Dips","Dumbbell Fly","Push-Ups","Deadlift","Pull-Ups","Barbell Rows","Lat Pulldown","Front Squat","Back Squat","Leg Extensions","Hamstring Curls",
    "Bicep Curl","EZ-Bar Curl","Hammer Curl","Trcep Pushdowns","Skull Crushers","Tricep Extension","Plank","Leg Raises","Crunches"};
    int[] muscleImages = {R.drawable.chest1,R.drawable.chest1,R.drawable.chest1,R.drawable.chest1,R.drawable.back1,R.drawable.back1,R.drawable.back1,R.drawable.back1,R.drawable.leg1,R.drawable.leg1,R.drawable.leg1,R.drawable.leg1,
            R.drawable.bicep1,R.drawable.bicep1,R.drawable.bicep1,R.drawable.tricep,R.drawable.tricep,R.drawable.tricep,R.drawable.abs,R.drawable.abs,R.drawable.abs};
    String[] muscleLinks = {"https://www.youtube.com/watch?v=SCVCLChPQFY","https://www.youtube.com/watch?v=dX_nSOOJIsE","https://www.youtube.com/watch?v=XuJ2OeoFIHI","https://www.youtube.com/watch?v=_l3ySVKYVJ8",
    "https://www.youtube.com/watch?v=1ZXobu7JvvE&list=PLdWvFCOAvyr3EWQhtfcEMd3DVM5sJdPL4","https://www.youtube.com/watch?v=aAggnpPyR6E","https://www.youtube.com/watch?v=VKFeB7ST830","https://www.youtube.com/watch?v=AOpi-p0cJkc",
    "https://www.youtube.com/watch?v=uYumuL_G_V0&list=PLdWvFCOAvyr3EWQhtfcEMd3DVM5sJdPL4&index=9","https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstleyVEVO","https://www.youtube.com/watch?v=YyvSfVjQeL0","https://www.youtube.com/watch?v=1Tq3QdYUuHs",
    "https://www.youtube.com/watch?v=Nkl8WnH6tDU","https://www.youtube.com/watch?v=S_i3SEVgKWU","https://www.youtube.com/watch?v=CFBZ4jN1CMI",
    "https://www.youtube.com/watch?v=GCa8Q4e7laU","https://www.youtube.com/watch?v=sDxcKjCqXAo","https://www.youtube.com/watch?v=_gsUck-7M74",
    "https://www.youtube.com/watch?v=WP0BFgeUQwA","https://www.youtube.com/watch?v=Wp4BlxcFTkE","https://www.youtube.com/watch?v=Xyd_fa5zoEU",};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MuscleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MuscleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MuscleFragment newInstance(String param1, String param2) {
        MuscleFragment fragment = new MuscleFragment();
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
        View v = inflater.inflate(R.layout.fragment_muscle, container, false);

        //finding listview
        listView = v.findViewById(R.id.list_view_data);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity().getApplicationContext(),ListdataActivity.class);
                intent.putExtra("name",muscleNames[i]);
                intent.putExtra("image",muscleImages[i]);
                intent.putExtra("link",muscleLinks[i]);
                startActivity(intent);

            }
        });

        return v;
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return muscleImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.muscles);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(muscleNames[i]);
            image.setImageResource(muscleImages[i]);
            return view1;
        }
    }
}