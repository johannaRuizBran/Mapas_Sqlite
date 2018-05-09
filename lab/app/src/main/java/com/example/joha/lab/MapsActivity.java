package com.example.joha.lab;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener , GoogleMap.OnInfoWindowClickListener{

    private GoogleMap mMap;
    private Marker tec1;
    private Marker tec2;
    private Marker tec3;
    private Marker tec4;
    private Marker tec5;
    ArrayList<TesSede> lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //insertarTECS();
        obtenerTEC();

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

        // Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(10.3621, -84.5099);
        mMap.addMarker(new MarkerOptions().position(sydney).title("TEC 1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        LatLng currentLatLng = new LatLng(Float.parseFloat(lista.get(0).getLatitud()),Float.parseFloat(lista.get(0).getLongitud()));
        CameraPosition cameraPosition1 = new CameraPosition.Builder()
                .target(currentLatLng)
                .tilt(90)
                .zoom(9)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition1));

        mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition1));


        LatLng tecMarq1 = new LatLng(Float.parseFloat(lista.get(0).getLatitud()),Float.parseFloat(lista.get(0).getLongitud()));
        tec1 = googleMap.addMarker(
                new MarkerOptions()
                        .position(tecMarq1)
                        .title(lista.get(0).getNombre()) //san carlos
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tecMarq1));
        googleMap.setOnInfoWindowClickListener(this);



        LatLng tecMarq2 = new LatLng(Float.parseFloat(lista.get(1).getLatitud()),Float.parseFloat(lista.get(1).getLongitud()));
        tec2 = googleMap.addMarker(
                new MarkerOptions()
                        .position(tecMarq2)
                        .title(lista.get(1).getNombre())//san jose
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tecMarq2));
        googleMap.setOnInfoWindowClickListener(this);



        LatLng tecMarq3 = new LatLng(Float.parseFloat(lista.get(2).getLatitud()),Float.parseFloat(lista.get(2).getLongitud()));
        tec3 = googleMap.addMarker(
                new MarkerOptions()
                        .position(tecMarq3)
                        .title(lista.get(2).getNombre())//alajuela
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tecMarq3));
        googleMap.setOnInfoWindowClickListener(this);



        LatLng tecMarq4 = new LatLng(Float.parseFloat(lista.get(3).getLatitud()),Float.parseFloat(lista.get(3).getLongitud()));
        tec4 = googleMap.addMarker(
                new MarkerOptions()
                        .position(tecMarq4)
                        .title(lista.get(3).getNombre())//limon
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tecMarq4));
        googleMap.setOnInfoWindowClickListener(this);



        LatLng tecMarq5 = new LatLng(Float.parseFloat(lista.get(4).getLatitud()),Float.parseFloat(lista.get(4).getLongitud()));
        tec5 = googleMap.addMarker(
                new MarkerOptions()
                        .position(tecMarq5)
                        .title(lista.get(4).getNombre())//cartago
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(tecMarq5));
        googleMap.setOnInfoWindowClickListener(this);

        UiSettings mapSettings;
        mapSettings = mMap.getUiSettings();
        mapSettings.setZoomControlsEnabled(true); //Set Zoom Controls
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return true;
    }

    public void obtenerTEC(){
        TesSede nueva = new TesSede("TEC San Carlos", "10.3652482", "-84.5057934",
                "","SC");
        lista= nueva.leer(getApplicationContext());
        Log.d("lista", lista.get(0).getNombre());
    }

    public void insertarTECS(){
        TesSede nueva = new TesSede("TEC San Carlos", "10.3652482", "-84.5057934",
                "Esta sede, ubicada en Santa Clara de San Carlos, vel del mar, con una temperatura media anual de 26ºC.\n",
                "SC");
        long newRowId = nueva.insertar(getApplicationContext());


        nueva = new TesSede("TEC San José", "9.9378868", "-84.0755203",
                "Esta sede, ubicada en San José.\n" ,"SJ");
        newRowId = nueva.insertar(getApplicationContext());


        nueva = new TesSede("TEC Alajuela", "10.0198026", "-84.1971997",
                "Esta sede, ubicada en Alajuela.\n" ,"AJ");
        newRowId = nueva.insertar(getApplicationContext());


        nueva = new TesSede("TEC Cartago", "9.8564963", "-83.9125516",
                "Esta sede, ubicada en Cartago.\n" ,"CA");
        newRowId = nueva.insertar(getApplicationContext());


        nueva = new TesSede("TEC Limón", "10.1026622", "-83.6893576",
                "Esta sede, ubicada en Limón.\n" ,"Li");
        newRowId = nueva.insertar(getApplicationContext());


        Toast.makeText(getApplicationContext(), "Insertar nuevo: " + newRowId +
                " n: " + nueva.getNombre() +
                " lat: " + nueva.getDescripcion() , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.equals(tec1)) {
            DialogFragment.newInstance(marker.getTitle(),
                    lista.get(0).getDescripcion())
                    .show(getSupportFragmentManager(), null);
        }
        else if (marker.equals(tec2)) {
            DialogFragment.newInstance(marker.getTitle(),
                    lista.get(1).getDescripcion())
                    .show(getSupportFragmentManager(), null);
        }
        else if (marker.equals(tec3)) {
            DialogFragment.newInstance(marker.getTitle(),
                    lista.get(2).getDescripcion())
                    .show(getSupportFragmentManager(), null);
        }
        else if (marker.equals(tec4)) {
            DialogFragment.newInstance(marker.getTitle(),
                    lista.get(3).getDescripcion())
                    .show(getSupportFragmentManager(), null);
        }
        else if (marker.equals(tec5)) {
            DialogFragment.newInstance(marker.getTitle(),
                    lista.get(4).getDescripcion())
                    .show(getSupportFragmentManager(), null);
        }
    }
}
