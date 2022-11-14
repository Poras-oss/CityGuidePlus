package com.minor.cityguideplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


public class PlaceViewer extends AppCompatActivity {

    RecyclerView recyclerView;
    PlaceAdapter adapter;



    ArrayList<String> names = new ArrayList<>();
    ArrayList<Double> rating = new ArrayList<>();
    ArrayList<String> address = new ArrayList<>();
    ArrayList<Boolean> status = new ArrayList<>();
    ArrayList<Integer> total_user_rating = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_viewer);
        String type = getIntent().getStringExtra("type");
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(type);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = (RecyclerView)findViewById(R.id.placeRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        names = getIntent().getStringArrayListExtra("names");
        address = getIntent().getStringArrayListExtra("address");
        rating = (ArrayList<Double>) getIntent().getSerializableExtra("rating");
        status = (ArrayList<Boolean>) getIntent().getSerializableExtra("status");
        total_user_rating = getIntent().getIntegerArrayListExtra("tur");




        adapter = new PlaceAdapter(names,address,rating,status,total_user_rating);
        recyclerView.setAdapter(adapter);


        MainActivity.l.dismiss();




    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}