package com.example.rumi.realstate.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rumi.realstate.R;
import com.example.rumi.realstate.adapter.PropertyRecyclerViewAdapter;
import com.example.rumi.realstate.interfaces.OnItemClickListener;
import com.example.rumi.realstate.model.Listing;
import com.example.rumi.realstate.network.ApiService;
import com.example.rumi.realstate.network.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private Unbinder unbinder;
    private List<Listing> listings = new ArrayList<Listing>();
    private ProgressDialog progressDialog;
    private RecyclerView listingRecyclerView;
    private PropertyRecyclerViewAdapter propertyRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        progressDialog = new ProgressDialog(getContext());

        listingRecyclerView = view.findViewById(R.id.listingRecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        listingRecyclerView.setLayoutManager(mLayoutManager);
        propertyRecyclerViewAdapter = new PropertyRecyclerViewAdapter(getContext(), listings, listing -> {

        });
        listingRecyclerView.setAdapter(propertyRecyclerViewAdapter);

        getListings();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void getListings() {
        listings.clear();
        progressDialog.setTitle("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiService service = RetrofitBuilder.buildRetrofit().create(ApiService.class);

        Call<List<Listing>> call = service.getListings();
        call.enqueue(new Callback<List<Listing>>() {
            @Override
            public void onResponse(Call<List<Listing>> call, Response<List<Listing>> response) {
                if (response.code() == 200) {
                    listings.clear();
                    progressDialog.dismiss();
                    Log.d("onResponse", response.body().toString());
                    listings.addAll(response.body());
                    propertyRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(getContext(), "Something wrong", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Listing>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "onFailure.." + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("HomeFragment", t.getMessage());
            }
        });
    }
}
