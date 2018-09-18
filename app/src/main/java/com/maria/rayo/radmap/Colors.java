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

    public Integer getColorCuadrado (double potenciaTotal) {
        Integer color=0x0000000;

        if ( potenciaTotal <50000) {
            color=(0xf09ff1c); //verde
        }
        if ( potenciaTotal <=45000) {
            color=(0xf25ff09);
        }
        if ( potenciaTotal <50000) {
            color=(0xf53ff08);
        }
        if ( potenciaTotal <55000) {
            color=(0xf81ff07);
        }
        if ( potenciaTotal <60000) {
            color=(0xfb0ff06);
        }
        if ( potenciaTotal <65000) {
            color=(0xfdfff05);
        }
        if ( potenciaTotal <70000) {
            color=(0xfffee04);
        }
        if ( potenciaTotal <75000) {
            color=(0xffbf03);
        }
        if ( potenciaTotal <80000) {
            color=(0xff8f02);
        }
        if ( potenciaTotal >=60000) {
            color=(0xf000000); //rojo
        }
        return color;
    }
}


