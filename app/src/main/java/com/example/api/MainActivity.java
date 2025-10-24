package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;

    // Método para cargar y redimensionar fotos
    private Bitmap loadImageFromAssets(String fileName) {
        try {
            InputStream is = getAssets().open("images/" + fileName);
            Bitmap originalBitmap = BitmapFactory.decodeStream(is);
            is.close();
            
            // Redimensionar a 100x100 píxeles
            return Bitmap.createScaledBitmap(originalBitmap, 100, 100, true);
        } catch (IOException e) {
            // Si no encuentra la foto, usar icono por defecto
            return BitmapFactory.decodeResource(getResources(), R.drawable.ic_my_house);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        
        // Habilitar controles de zoom
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setZoomGesturesEnabled(true);
        myMap.getUiSettings().setScrollGesturesEnabled(true);
        myMap.getUiSettings().setTiltGesturesEnabled(true);
        myMap.getUiSettings().setRotateGesturesEnabled(true);
        
        // Configurar zoom mínimo y máximo
        myMap.setMinZoomPreference(8.0f);
        myMap.setMaxZoomPreference(20.0f);
        //MiCasa
        LatLng santaCruz=new LatLng(-17.74553875150383, -63.16746212197016);
        myMap.moveCamera(CameraUpdateFactory.newLatLng(santaCruz));
        MarkerOptions options = new MarkerOptions()
                .position(santaCruz)
                .title("MiCasita")
                .snippet("Mi hogar principal - Centro de operaciones")
                .icon(BitmapDescriptorFactory.fromBitmap(loadImageFromAssets("yo.png")));
        myMap.addMarker(options);
        
        // CasaPapá
        LatLng casaPapa = new LatLng(-17.81678509809685, -63.23627564794537);
        MarkerOptions markerPapa = new MarkerOptions()
                .position(casaPapa)
                .title("CasaPapá")
                .snippet("Residencia del papá - Hogar paterno")
                .icon(BitmapDescriptorFactory.fromBitmap(loadImageFromAssets("Papa.png")));
        myMap.addMarker(markerPapa);
        
        // CasaAbuela
        LatLng casaAbuela = new LatLng(-17.695966980615612, -63.154404967328865);
        MarkerOptions markerAbuela = new MarkerOptions()
                .position(casaAbuela)
                .title("CasaAbuela")
                .snippet("Hogar de la abuela - Lugar de reunión familiar")
                .icon(BitmapDescriptorFactory.fromBitmap(loadImageFromAssets("abuela.png")));
        myMap.addMarker(markerAbuela);
        
        // CasaTio
        LatLng casaTio = new LatLng(-17.76559306493827, -63.167822406799594);
        MarkerOptions markerTio = new MarkerOptions()
                .position(casaTio)
                .title("CasaTio")
                .snippet("Casa del tío - Familia")
                .icon(BitmapDescriptorFactory.fromBitmap(loadImageFromAssets("tio.png")));
        myMap.addMarker(markerTio);
        
        // CasaTia
        LatLng casaTia = new LatLng(-17.808550053909592, -63.18647571337914);
        MarkerOptions markerTia = new MarkerOptions()
                .position(casaTia)
                .title("CasaTia")
                .snippet("Casa de la tía - Familia")
                .icon(BitmapDescriptorFactory.fromBitmap(loadImageFromAssets("Tia.png")));
        myMap.addMarker(markerTia);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture){
        super.onPointerCaptureChanged(hasCapture);
    }
}