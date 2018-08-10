package com.maria.rayo.radmap;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class Colors {


    public Colors (){


    }

    public ArrayList<Integer> getColorList () {
        ArrayList<Integer> colorsList = new ArrayList<Integer>();


        colorsList.add(0xfffff00);//amarillo
        colorsList.add(0xf00ff00);// verde
        colorsList.add(0xfff0000); //rojo
        colorsList.add(0xfff0000); //rojo
        colorsList.add(0xff000000); //negro



      return colorsList;
    }
}



