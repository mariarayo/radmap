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

        if ( potenciaTotal >= 0.001 && potenciaTotal <=0.37 ) {
            color=(0xfff0000);// verde 0xf00ff00
        }else{
            if ( potenciaTotal == 0.38 && potenciaTotal <=0.74) {
                color=(0xfffff00);//amarillo
            }else{
                if ( potenciaTotal ==0.75 && potenciaTotal <=1.11) {
                    color=(0xfff0000); //rojo
                }else{
                    if ( potenciaTotal <1.48) {
                        color=(0xfff0000); //rojo
                    }
                }
            }
        }

        return color;
    }
}


