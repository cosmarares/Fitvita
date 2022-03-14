package com.example.fitvita20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListdataActivity extends AppCompatActivity {

    TextView listdata;
    ImageView imageView;
    Button link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        listdata = findViewById(R.id.listdata);
        imageView = findViewById(R.id.imageView);
        Intent intent = getIntent();
        String receivedHTTP = intent.getStringExtra("link");
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        listdata.setText(receivedName);
        imageView.setImageResource(receivedImage);
        //Enable la butonul de back
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        link = (Button) findViewById(R.id.Link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webaddress = Uri.parse(receivedHTTP);

                Intent gotoLink = new Intent(Intent.ACTION_VIEW, webaddress);
                startActivity(gotoLink);

                /*if (gotoLink.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoLink);
                }*/
            }
        });
    }

    //Intoarcere la lista
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}