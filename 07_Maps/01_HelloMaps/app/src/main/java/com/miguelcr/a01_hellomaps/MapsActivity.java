package com.miguelcr.a01_hellomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener(this);

        // Add a marker in Centru Calarasi
        LatLng pos = new LatLng(44.192009,27.33201);

        mMap.addMarker(new MarkerOptions()
                .position(pos)
                .title("Marker in Calarasi")
                .snippet("The best city in Romania")
        );

        pos = new LatLng(37.380399,-6.006925);
        mMap.addMarker(new MarkerOptions()
                .position(pos)
                .title("Marker in Seville")
                .snippet("The best city in Spain")
        );

        mMap.moveCamera(
                CameraUpdateFactory.newLatLng(pos)
        );
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Marker "+counter)
                .snippet(latLng.latitude+","+latLng.longitude)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pink_marker))
                .draggable(true)
        );

        marker.showInfoWindow();

        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(latLng,5)
        );

        counter++;
    }
}
