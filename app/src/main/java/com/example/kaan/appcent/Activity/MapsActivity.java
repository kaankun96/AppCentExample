package com.example.kaan.appcent.Activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.kaan.appcent.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double lat, lng;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        name = getIntent().getExtras().getString("name");
        lat = getIntent().getExtras().getDouble("lat");
        lng = getIntent().getExtras().getDouble("lng");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        float zoomLevel = (float) 16.0; //This goes up to 21


        // Add a marker in Sydney and move the camera
        LatLng konumum = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(konumum).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konumum, zoomLevel));

    }
}
