package com.minor.cityguideplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    RelativeLayout Library, Restaurant, Gym, Doctor, Cinema, Cafe;
    Loading l;
    FusedLocationProviderClient fusedLocationProviderClient;
    static final int req_code = 101;
    double lat, lng;

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
                    if(location != null){
                        Toast.makeText(getApplicationContext(),"lat:"+location.getLatitude()+" log:"+location.getLongitude(), Toast.LENGTH_SHORT).show();
                    }
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
                stringBuilder.append("&radius=1000");
                stringBuilder.append("&type=atm");
                stringBuilder.append("&sensor=true");
                stringBuilder.append("&key="+getResources().getString(R.string.places_key));

                String url = stringBuilder.toString();

                FetchData fetchData = new FetchData(MainActivity.this);
                fetchData.execute(url);


                l.dismiss();


            }
        });
        Restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        l.dismiss();
                        Intent i = new Intent(MainActivity.this, PlaceViewer.class);
                        i.putExtra("type","Restaurant");
                        startActivity(i);
                    }
                },2500);

            }
        });
        Gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        l.dismiss();
                        Intent i = new Intent(MainActivity.this, PlaceViewer.class);
                        i.putExtra("type","Gym");
                        startActivity(i);
                    }
                },2500);

            }
        });
        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        l.dismiss();
                        Intent i = new Intent(MainActivity.this, PlaceViewer.class);
                        i.putExtra("type","Doctor");
                        startActivity(i);
                    }
                },2500);

            }
        });
        Cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        l.dismiss();
                        Intent i = new Intent(MainActivity.this, PlaceViewer.class);
                        i.putExtra("type","Cinema");
                        startActivity(i);
                    }
                },2500);

            }
        });
        Cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        l.dismiss();
                        Intent i = new Intent(MainActivity.this, PlaceViewer.class);
                        i.putExtra("type","Cafe");
                        startActivity(i);
                    }
                },2500);

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



}