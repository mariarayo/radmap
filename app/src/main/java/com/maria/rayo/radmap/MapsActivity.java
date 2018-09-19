package com.maria.rayo.radmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.lang.*;
import android.R.*;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;


import java.util.ArrayList;




public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private Marker markerprueba;
    public ArrayList<Antena> misAntenas;
    public Antena currentAntena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Log.i("TEST", "HOLA ESTOY AQUI");
    }



    @Override
    public void onMapReady(final GoogleMap googleMap) {


        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        //genera permisos para la locacion con el if anterior
        mMap.setMyLocationEnabled(true);

        LatLng miUbicacion = new LatLng(4.751328, -74.029998);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbicacion, 15));

        Antut(googleMap);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if(mMap != null)
                    mMap.clear();

                Log.i("CENTRO: ", String.valueOf(mMap.getCameraPosition().target.latitude) + " , " + String.valueOf(mMap.getCameraPosition().target.longitude));

                drawSquares(latLng.latitude, latLng.longitude);
            }
        });
    }




    public String KEY_OPENCELLID = "90a214f0f9935d";




    public void Antut(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng miUbicacion =  new LatLng (4.751328,-74.029998);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miUbicacion, 15));

        double ubicacionX=4.751328;
        double ubicacionY=-74.029998;

        Mylatlng miposicion = new Mylatlng(ubicacionX, ubicacionY);
        Cuadrados miCuadrado = new Cuadrados(miposicion);


        //calculo del punto inicial
        // posicion del cuadro respecto a mi posicion

        Mylatlng puntoInicio = new Mylatlng(miposicion.getLatitud()+miCuadrado.getDiagonal()*11, miposicion.getLongitud()-miCuadrado.getDiagonal()*6);

        Mylatlng puntoReferencia = puntoInicio;

        //Instanciamos la clase que maneja los colores
        Colors colors = new Colors();


        for(double j = 0; j< 23; j++){

            for(double i = 0; i< 14; i++){
                //Establecer colores con una variable

                Cuadrados cuadradoActual = new Cuadrados(puntoReferencia);
                LatLng puntoReferenviaLatLon= new LatLng(puntoReferencia.getLatitud(),puntoReferencia.getLongitud());
                double potenciaCuadrado=potenciaTotalP(puntoReferenviaLatLon);
                Polygon polygon = mMap.addPolygon(cuadradoActual.getPolygonOptions());
                polygon.setStrokeWidth(0);
                polygon.setFillColor(colors.getColorCuadrado(potenciaCuadrado));

               // Log.i("potencia: ", String.valueOf(potenciaCuadrado));

                puntoReferencia = new Mylatlng(puntoReferencia.getLatitud(), puntoReferencia.getLongitud()+cuadradoActual.getDiagonal());
            }
            puntoReferencia = new Mylatlng(puntoReferencia.getLatitud()-(miCuadrado.getDiagonal()), puntoInicio.getLongitud());

        }

        // Creacion de los marcadores con las coordenadas de las antenas
        ArrayList<Antena> antenasList = getAntenas();

        pintarAntenas(getAntenas());
        googleMap.setOnMarkerClickListener(this);
    }

    public double calcularPotencia(LatLng posicion, LatLng locAntena) {
        double potencia = 0;
        int factor = new Integer(1000);




        //pasar latitudes y longitudes a metros

        double diferenciaLat = Math.abs(posicion.latitude - locAntena.latitude) ;
        double diferenciaLong =  Math.abs(posicion.longitude - locAntena.longitude);
        //Log.i(String.valueOf(diferenciaLat),String.valueOf(diferenciaLong));

        double sinLat=Math.sin(diferenciaLat/2);
        double sinLong=Math.sin(diferenciaLong/2);

        double radioTierra= 6371;

        //double Haversine=(sinLat*sinLat)+ (Math.cos(posicion.latitude)*Math.cos(posicion.latitude))*(sinLong*sinLong);
        //double constante= 2*Math.asin(Math.min(1.0, Math.sqrt(Haversine)));

        //double distanciaMetros=radioTierra*constante;
        //Log.i("Distancia M",String.valueOf(distanciaMetros));

        double distancia=Math.sqrt((diferenciaLat*diferenciaLat)+(diferenciaLong*diferenciaLong))*1000;
        //Log.i("Distancia ",String.valueOf(distancia));

        potencia=(1/(4*Math.PI*(distancia*distancia)))*factor;


        return potencia;
    }


    public double potenciaTotalP(LatLng posiscion){
        ArrayList<Antena> antenasList = getAntenas();

        double potenciaTotal=0;
        for(int i=0; i<antenasList.size(); i++ ){

            potenciaTotal= potenciaTotal+calcularPotencia(posiscion,antenasList.get(i).posicion());

        }

        return potenciaTotal;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(markerprueba)){

            String latitud, longitud;
            latitud = Double.toString(marker.getPosition().latitude);
            longitud = Double.toString(marker.getPosition().longitude);

            // Al tocar una marca aparecera la logitud y la latitud
            Toast.makeText(this, "Latitud " + latitud + ", " + "Longittud " + longitud, Toast.LENGTH_SHORT).show();
        }

        return false;
    }




    // Lista de antenas
    public ArrayList<Antena> getAntenas (){
        misAntenas = new ArrayList<Antena>();

        currentAntena = new Antena( -74.029701, "UMTS", 4.747425, 1000);
        misAntenas.add(currentAntena);
        currentAntena = new Antena( -74.036609, "UMTS", 4.756269, 40179);
        misAntenas.add(currentAntena);
        currentAntena = new Antena( -74.037845, "UMTS", 4.754475, 68302);
        misAntenas.add(currentAntena);
        currentAntena = new Antena( -74.027939, "GSM", 4.751587, 1164);
        misAntenas.add(currentAntena);


        return misAntenas;
    }

    public void pintarAntenas (ArrayList<Antena> antenas){

        for(int i=0; i<antenas.size(); i++ ){
            double miLat=antenas.get(i).lat;
            double milong=antenas.get(i).lon;
            mMap.addMarker(new MarkerOptions().position(new LatLng(miLat, milong)).title("antena").icon(BitmapDescriptorFactory.fromResource(R.drawable.antena)));


        }
    }

    public void drawSquares (Double LAT, Double LON){

        Mylatlng miposicion = new Mylatlng(LAT, LON);
        Log.i("AQUI3", String.valueOf( miposicion));

        Cuadrados miCuadrado = new Cuadrados(miposicion);

        Mylatlng puntoInicio = new Mylatlng(miposicion.getLatitud()+miCuadrado.getDiagonal()*11.5, miposicion.getLongitud()-miCuadrado.getDiagonal()*7);
        Mylatlng puntoReferencia = puntoInicio;

        Log.i("AQUI4", String.valueOf( puntoInicio));

        Colors colors = new Colors();
        Integer colorPosition =  0;

        //Pintar cuadrados
        for(double j = 0; j< 23; j++){
            for(double i = 0; i< 14; i++){
                //Establecer colores con una variable
                Cuadrados cuadradoActual = new Cuadrados(puntoReferencia);
                LatLng puntoReferenviaLatLon= new LatLng(puntoReferencia.getLatitud(),puntoReferencia.getLongitud());
                double potenciaCuadrado=potenciaTotalP(puntoReferenviaLatLon);
                Polygon polygon = mMap.addPolygon(cuadradoActual.getPolygonOptions());
                polygon.setStrokeWidth(0);
                polygon.setFillColor(colors.getColorCuadrado(potenciaCuadrado));

                puntoReferencia = new Mylatlng(puntoReferencia.getLatitud(), puntoReferencia.getLongitud()+cuadradoActual.getDiagonal());
            }
            puntoReferencia = new Mylatlng(puntoReferencia.getLatitud()-(miCuadrado.getDiagonal()), puntoInicio.getLongitud());

        }
    }
}