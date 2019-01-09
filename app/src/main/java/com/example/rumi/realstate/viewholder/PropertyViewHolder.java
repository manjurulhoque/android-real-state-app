package com.example.rumi.realstate.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rumi.realstate.R;
import com.example.rumi.realstate.interfaces.OnItemClickListener;
import com.example.rumi.realstate.model.Listing;
import com.squareup.picasso.Picasso;

public class PropertyViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView name;
    public TextView bed;
    public TextView bath;
    public TextView sqft;
    public CardView cardView;


    public PropertyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        name = itemView.findViewById(R.id.name);
        bed = itemView.findViewById(R.id.bed);
        bath = itemView.findViewById(R.id.bath);
        sqft = itemView.findViewById(R.id.sqft);
        cardView = itemView.findViewById(R.id.card_view);

    }

    public void bind(Listing listing, final OnItemClickListener listener) {
        Picasso.get().load(listing.getPhoto_main()).into(imageView);
        name.setText(listing.getTitle());
        bed.setText(listing.getBedrooms() + " bed");
        bath.setText(listing.getBathrooms() + " bath");
        sqft.setText(listing.getSqrt() + " sqft");

        itemView.setOnClickListener(v -> listener.onItemClick(listing));
    }
}
