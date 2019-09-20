package com.example.basurapk;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        int status= GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if(status == ConnectionResult.SUCCESS){


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        }else{

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);



        // Add a marker in Sydney and move the camera
        LatLng Contenedor2 = new LatLng(17.962325, -102.198053);
        mMap.addMarker(new MarkerOptions().position(Contenedor2).title("Ruta 1 Contenedor 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        float zoomlevelR1=16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Contenedor2,zoomlevelR1));

        LatLng Contenedor1 = new LatLng(17.961513, -102.203879);
        mMap.addMarker(new MarkerOptions().position(Contenedor1).title("Ruta 1 Contenedor 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        float zoomlevelR2=16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Contenedor1,zoomlevelR2));

        LatLng Contenedor3 = new LatLng(17.961420, -102.201770);
        mMap.addMarker(new MarkerOptions().position(Contenedor3).title("Ruta 1 Contenedor 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        float zoomlevelR3=16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Contenedor3,zoomlevelR3));



    }
}
