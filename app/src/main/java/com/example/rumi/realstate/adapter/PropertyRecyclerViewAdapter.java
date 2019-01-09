package com.example.rumi.realstate.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rumi.realstate.R;
import com.example.rumi.realstate.interfaces.OnItemClickListener;
import com.example.rumi.realstate.model.Listing;
import com.example.rumi.realstate.viewholder.PropertyViewHolder;

import java.util.List;

public class PropertyRecyclerViewAdapter extends RecyclerView.Adapter<PropertyViewHolder> {

    private Context context;
    private List<Listing> properties;
    private final OnItemClickListener mListener;

    public PropertyRecyclerViewAdapter(Context context, List<Listing> properties, OnItemClickListener listener) {
        this.properties = properties;
        this.context = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_property_single, viewGroup, false);
        return new PropertyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder propertyViewHolder, int position) {
        propertyViewHolder.bind(properties.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }
}
