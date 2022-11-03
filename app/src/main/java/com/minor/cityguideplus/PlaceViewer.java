package com.minor.cityguideplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


public class PlaceViewer extends AppCompatActivity {

    RecyclerView recyclerView;
    PlaceAdapter adapter;


    ArrayList<String> names = new ArrayList<>();



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

        Toast.makeText(this, names.get(0), Toast.LENGTH_SHORT).show();



        switch (type){
            case "Library":
                library();
                break;
            case "Restaurant":
                restaurant();
                break;
            case "Gym":
                gym();
                break;
            case "Doctor":
                doctor();
                break;
            case "Cinema":
                cinema();
                break;
            case "Cafe":
                cafe();
                break;
        }


    }


    private void restaurant() {
        String[] name = new String[]{"PANCH TANTRA RESTAURANT","Day & Night Restaurant","Ethnic Restaurant","Take away"};
        String[] address = new String[]{"4VHC+PG3, In front of gyan ganga college, Sagra,Jabalpur, Madhya Pradesh 482003",
                "JDA Colony Shastri Nagar, Jabalpur, Madhya Pradesh 482003",
                "5V6P+PRP, 786 Ganga Nagar, Jabalpur, Madhya Pradesh 482004",
                "Shop No 7, Samarth Nilay Apartment Gupteshwar road, Madan Mahal, Jabalpur, Madhya Pradesh 482001"};
        float[] rating = new float[]{4.3f,4.2f,0f,5.0f};

        adapter = new PlaceAdapter(name,address,rating);
        recyclerView.setAdapter(adapter);
    }
    private void library() {
        String[] name = new String[]{"Readind Room","The study zone library","Library - Adhyayan study club","Unique Library & study point"
                ,"Pratiti Library the Study Zone","library Lucent's academy","Apni library"};
        String[] address = new String[]{"5V2J+HMQ, NSCB MEDICAL COLLEGE CAMPUS, near CENTRAL LIBRARY, Jabalpur",
                "Plot n.24 second flour new adarsh colony jay nagar Kala, Kamla Nehru Nagar, Yadav Colony, Jabalpur, Madhya Pradesh 482002",
                "Madan Mahal Railway Station Rd, opposite आशीष हॉस्पिटल, Napier Town, Jabalpur, Madhya Pradesh 482001",
                "Mehta Petrol pump, Near, 62 Nav Adarsh Colony, MR-4 Rd, Labour Chowk, Jabalpur, Madhya Pradesh 482002","1470, 1st floor, Madan Mahal Railway Station Rd, beside Bhatkhande sangeet mahavidyalaya, Jabalpur, Madhya Pradesh 482002",
                "Nove Adaresh Colony, Yadav Colony, Jabalpur, Madhya Pradesh 482002","3, Wright Town, Jabalpur, Madhya Pradesh 482002"};

        float[] rating = new float[]{0f,4.7f,4.8f,4.9f,4.4f,5.0f,0f};

        adapter = new PlaceAdapter(name,address,rating);
        recyclerView.setAdapter(adapter);
    }
    private void gym() {
        String[] name = new String[]{"Gymnasium Gym","Awasthi Fitness Club","Gym","Shivaay Fitness Unisex Gym","Royal Fitness gym",
                "Lakshya Fitness"};
        String[] address = new String[]{"Chandan Colony, Ganga Nagar, Jabalpur, Madhya Pradesh 482003","Shastri Nagar, Jabalpur, Madhya Pradesh 482003",
                "4VRJ+766, Bhairo Baba Mandir Road, Shastri Nagar, Jabalpur, Madhya Pradesh 482003", "Gulaua Chowk,Shukla Nagar Road, in front of Ram Nagar, Jabalpur, Madhya Pradesh 482003",
                "5W65+3WH, Satya niwas parisar ekta chowk, Gangasagar Rd, Garha, Jabalpur, Madhya Pradesh 482003","Garha, Jabalpur, Madhya Pradesh 482003",
                ""};
        float[] rating = new float[]{4.9f,4.4f,0f,5f,4.7f,4.5f};

        adapter = new PlaceAdapter(name,address,rating);
        recyclerView.setAdapter(adapter);
    }
    private void doctor() {
        String[] name = new String[]{"Dr. Vidya","Dr. Pragya Dhirawani Obstetrician-Gynecologist in Jabalpur","Badgaiyan Dental Clinic","Gayatri Dental Clinic"};
        String[] address = new String[]{"4VHG+W95, Swastik villa, near gyan ganga academy, Jabalpur, Madhya Pradesh 482003","Hospital and Research centre, Russel Chowk, Napier Town, Jabalpur, Madhya Pradesh 482001",
                "5V5V+P36, Panda Ki Madiya, Subhash Nagar, Garha, Jabalpur, Madhya Pradesh 482003","5V6X+HPP, Anand Kunj, Garha, Jabalpur, Madhya Pradesh 482003"};
        float[] rating = new float[]{0f,4.6f,0f,0f};

        adapter = new PlaceAdapter(name,address,rating);
        recyclerView.setAdapter(adapter);
    }
    private void cinema() {
        String[] name = new String[]{"Movie Magic","Samdariya Era Cinema","S R cinema"};
        String[] address = new String[]{"2nd Floor, South Avenue Mall, Narmada Rd, Polipather, Jabalpur, Madhya Pradesh 482008",
                "3, Malaviya Chowk, Awadhpuri, Marhatal, Jabalpur, Madhya Pradesh 482001","5WR6+QV3 infron of CBI, Unnamed Road, Vijay Nagar, Jabalpur, Madhya Pradesh 482002"};
        float[] rating = new float[]{4.2f,3.8f,3.8f};

        adapter = new PlaceAdapter(name,address,rating);
        recyclerView.setAdapter(adapter);
    }
    private void cafe() {
        String[] name = new String[]{"Nescafe gyan ganga","OLD IS GOLD CAFE","Sarv Cafe","Engineer's Cafe","Kulladh cafe","Cafe IT Park Jabalpur"};
        String[] address = new String[]{"4VHF+8XH, Bargi Hills, Jabalpur, Madhya Pradesh 482003","Tilwara road Sagra shastri nagar Front of satya rakhsa hotel, Madhya Pradesh 482003",
                "1st Floor, Aatri Estates, near Comunity Hall, Dhanvantari Nagar, Jabalpur, Madhya Pradesh 482003","Jabalpur - Nagpur Rd, near Sharda Chowk, Jabalpur, Madhya Pradesh 482001",
                "4VQG+MWH, New Shastri Nagar, Shastri Nagar, Jabalpur, Madhya Pradesh 482003","Plot No:1, IT Park, Bargi Hills, Jabalpur, Madhya Pradesh 482003"};
        float[] rating = new float[]{5f,4.7f,0f,4f,0f,4f};

        adapter = new PlaceAdapter(name,address,rating);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}