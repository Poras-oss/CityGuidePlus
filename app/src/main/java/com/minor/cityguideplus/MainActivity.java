package com.minor.cityguideplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout Library, Restaurant, Gym, Doctor, Cinema, Cafe;
    static Loading l;
    FusedLocationProviderClient fusedLocationProviderClient;
    static final int req_code = 101, RESULT_SPEECH = 1;
    double lat, lng;

    ImageView voice_btn;

    private void getCurrentLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},req_code);
            return;
        }

        LocationRequest locationRequest =  LocationRequest.create();
        locationRequest.setInterval(60000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setFastestInterval(5000);

        LocationCallback locationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                if(locationResult == null){
                    Toast.makeText(getApplicationContext(),"Location not available", Toast.LENGTH_SHORT).show();
                    return;
                }

                for(Location location: locationResult.getLocations()){
                        lat = location.getLatitude();
                        lng = location.getLongitude();
                }

            }
        };

        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback,null);

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    //get lat log
                    lat = location.getLatitude();
                    lng = location.getLongitude();

                    LatLng latLng = new LatLng(lat,lng);
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = new Loading(this);
        l.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        voice_btn = (ImageView)findViewById(R.id.voice_search_btn);

        voice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"en-US");

                try{
                    startActivityForResult(i,RESULT_SPEECH);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(getApplicationContext(), "Speech Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        getCurrentLocation();





        Library = (RelativeLayout) findViewById(R.id.library);
        Restaurant = (RelativeLayout) findViewById(R.id.restaurant);
        Gym = (RelativeLayout) findViewById(R.id.gym);
        Doctor = (RelativeLayout) findViewById(R.id.doctor);
        Cinema = (RelativeLayout) findViewById(R.id.cinema);
        Cafe = (RelativeLayout) findViewById(R.id.cafe);


        Library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=10000");
                stringBuilder.append("&type=library");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&keyword=library");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this, "Librabry");
                fetchData.execute(url);

            }
        });
        Restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=10000");
                stringBuilder.append("&type=restaurant");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&keyword=restaurant");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this, "Restaurant");
                fetchData.execute(url);

            }
        });
        Gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=10000");
                stringBuilder.append("&type=gym");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&keyword=gym");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this,"Gym");
                fetchData.execute(url);

            }
        });
        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=10000");
                stringBuilder.append("&type=doctor");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&keyword=doctor");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this,"Doctor");
                fetchData.execute(url);

            }
        });
        Cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=10000");
                stringBuilder.append("&type=cinema");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&keyword=cinema");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this,"Cinema");
                fetchData.execute(url);

            }
        });
        Cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                stringBuilder.append("location="+lat+","+lng);
                stringBuilder.append("&radius=10000");
                stringBuilder.append("&type=cafe");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&keyword=cafe");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this, "Cafe");
                fetchData.execute(url);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case req_code:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                    getCurrentLocation();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    l.show();

                    StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                    stringBuilder.append("location="+lat+","+lng);
                    stringBuilder.append("&radius=50000");
                    stringBuilder.append("&type="+text.get(0).toLowerCase().trim());
                    stringBuilder.append("&sensor=true");
                    stringBuilder.append("&keyword="+text.get(0).toLowerCase().trim());
                    stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                    String url = stringBuilder.toString();

                    FetchData fetchData = new FetchData(MainActivity.this,text.get(0));
                    fetchData.execute(url);
                }
                break;

        }
    }
}