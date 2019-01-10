package com.example.rumi.realstate.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rumi.realstate.R;
import com.example.rumi.realstate.model.Listing;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyDetailActivity extends AppCompatActivity {

    @BindView(R.id.mainImageView)
    public ImageView mainImageView;
    @BindView(R.id.sqftTextView)
    public TextView sqftTextView;
    @BindView(R.id.bedTextView)
    public TextView bedTextView;
    @BindView(R.id.bathTextView)
    public TextView bathTextView;
    @BindView(R.id.descriptionTextView)
    public TextView descriptionTextView;
    @BindView(R.id.titleTextView)
    public TextView titleTextView;
    @BindView(R.id.priceTextView)
    public TextView priceTextView;
    @BindView(R.id.garageTextView)
    public TextView garageTextView;
    @BindView(R.id.addressTextView)
    public TextView addressTextView;
    @BindView(R.id.zipCodeTextView)
    public TextView zipCodeTextView;
    @BindView(R.id.callButton)
    public Button callButton;
    @BindView(R.id.emailButton)
    public Button emailButton;

    private Listing listing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_detail);
        ButterKnife.bind(this);

        listing = (Listing) getIntent().getSerializableExtra("listing");

        setView();
    }

    private void setView() {
        Picasso
                .get()
                .load(listing.getPhoto_main())
                .into(mainImageView);

        zipCodeTextView.setText(listing.getZipCode());
        addressTextView.setText(listing.getAddress() + ", " + listing.getCity());
        garageTextView.setText(listing.getGarage() + " garages");
        priceTextView.setText("$ " + listing.getPrice());
        titleTextView.setText(listing.getTitle());
        sqftTextView.setText(listing.getSqrt() + " sqft");
        bedTextView.setText(listing.getBedrooms() + " bed");
        bathTextView.setText(listing.getBathrooms() + " bath");
        descriptionTextView.setText(listing.getDescription());
    }

    @OnClick(R.id.callButton)
    public void call() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            checkPermission();
        }
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + listing.getRealtor().getPhone()));
        startActivity(callIntent);
    }

    private void checkPermission() {
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.CALL_PHONE
        };

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
    }

    boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
