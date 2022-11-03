package com.minor.cityguideplus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    String[] name,address;
    float[] rating;

    public PlaceAdapter(String[] name, String[] address, float[] rating) {
        this.name = name;
        this.address = address;
        this.rating = rating;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.places_card,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        holder.title.setText(name[position]);
        holder.address.setText(address[position]);
        holder.ratingBar.setRating(rating[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder{
        TextView title,address;
        RatingBar ratingBar;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            address = (TextView)itemView.findViewById(R.id.address);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
        }
    }
}
