package com.minor.cityguideplus;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.Place;


import org.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class FetchData extends AsyncTask<String,String,String> {
    String nearbyPlaceData = "";
    String url;

    ArrayList<String> names = new ArrayList<>();
    ArrayList<LatLng> latlong = new ArrayList<>();
    ArrayList<Boolean> openOrNot = new ArrayList<>();
    ArrayList<Double> Rating = new ArrayList<>();
    ArrayList<Integer> total_user_rating = new ArrayList<>();
    ArrayList<String> address = new ArrayList<>();

    Context context;
    String type = "";



    public FetchData(MainActivity mainActivity, String type) {
        this.context = mainActivity;
        this.type = type;
    }


    @Override
    protected String doInBackground(String... strings) {
        // network call

      try {
            url = strings[0];
            DownloadUrl downloadUrl = new DownloadUrl();
            nearbyPlaceData = downloadUrl.retrieveUrl(url);


        } catch (IOException e) {
            e.printStackTrace();
        }



        return nearbyPlaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);






        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for(int i=0; i<jsonArray.length(); i++){

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                JSONObject getLocation = jsonObject1.getJSONObject("geometry").getJSONObject("location");

                JSONObject getName = jsonArray.getJSONObject(i);
               //coordinates
                Double lat = getLocation.getDouble("lat");;
                Double lng =  getLocation.getDouble("lng");
                latlong.add(new LatLng(lat,lng));
                LatLng latLng = new LatLng(lat,lng);
                String name = getName.getString("name");
                if (name == null){
                    name = "";
                }
                names.add(name);
                Boolean status = getName.getJSONObject("opening_hours").getBoolean("open_now");
                openOrNot.add(status);
                double rating = getName.getDouble("rating");
                Rating.add(rating);
                int totaluserrating = getName.getInt("user_ratings_total");
                total_user_rating.add(totaluserrating);
                String addr = getName.getString("vicinity");
                if(addr == null){
                    addr = "";
                }
                address.add(addr);



            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("error_response", "onPostExecute: "+e.toString());
        }
       // adding sample data to list




        Intent i = new Intent(context,PlaceViewer.class);
        i.putExtra("names",names);
        i.putExtra("address",address);
        i.putExtra("rating",Rating);
        i.putExtra("type",type);
        i.putExtra("tur",total_user_rating);
        i.putExtra("status",openOrNot);
        context.startActivity(i);


    }


}
