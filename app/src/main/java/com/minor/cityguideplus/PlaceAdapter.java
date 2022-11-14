package com.minor.cityguideplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    ArrayList<String> name,address;
    ArrayList<Double> rating;
    ArrayList<Boolean> status;
    ArrayList<Integer> total_user_rating;
    Context context;


    public PlaceAdapter(ArrayList<String> name, ArrayList<String> address, ArrayList<Double> rating, ArrayList<Boolean> status, ArrayList<Integer> total_user_rating) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.status = status;
        this.total_user_rating = total_user_rating;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        context = parent.getContext();
        View view = inflater.inflate(R.layout.places_card,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        holder.title.setText(name.get(position));
        if(address.size() > position){
            holder.address.setText(address.get(position));
        }else{
            holder.address.setText("");
        }

        if(rating.size() > position){
            double d = rating.get(position);
            float f = (float) d;
            holder.ratingBar.setRating(f);
        }else{
            holder.ratingBar.setRating(0f);
        }

        if(status.size() > position){
            holder.status.setAlpha(1f);
            if(status.get(position)){
                holder.status.setText("Open Now");
                holder.status.setTextColor(context.getResources().getColor(R.color.green));
            }else{
                holder.status.setText("Closed");
                holder.status.setTextColor(context.getResources().getColor(R.color.red));
            }
        }
        if(total_user_rating.size() > position){
            holder.tur.setText("("+total_user_rating.get(position)+")");
        }else{
            holder.tur.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder{
        TextView title,address,tur,status;
        RatingBar ratingBar;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            address = (TextView)itemView.findViewById(R.id.address);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            tur = (TextView) itemView.findViewById(R.id.total_user_rating);
            status = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
