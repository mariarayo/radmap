package com.maria.rayo.radmap;

import android.util.Log;

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
        Integer color=0x00000000;
        String Opcion = "";

        if ( potenciaTotal <2.50) {
            color=(0x1109ff1c); //verde
            Opcion = "1";
        }else{
            if ( potenciaTotal <=3.14) {
                color=(0x1125ff09);
                Opcion = "2";
            }else{
                if ( potenciaTotal <4.04) {
                    color=(0x1153ff08);
                    Opcion = "3";
                }else{
                    if ( potenciaTotal <4.97) {
                        color=(0x1181ff07);
                        Opcion = "4";
                    }else{
                        if ( potenciaTotal <6.8) {
                            color=(0x11b0ff06);
                            Opcion = "5";
                        }else{
                            if ( potenciaTotal <8.8) {
                                color=(0x11ffee04);
                                Opcion = "6";
                            }else{
                                if ( potenciaTotal <11.42) {
                                    color=(0x11ffbf03);
                                    Opcion = "7";
                                }else{
                                    if ( potenciaTotal <17.38) {
                                        color=(0x11ff8f02);
                                        Opcion = "8";
                                    }else{
                                        if ( potenciaTotal <32.78) {
                                            color=(0x11ff5e01);
                                            Opcion = "9";
                                        }else{
                                            if ( potenciaTotal >=32.78) {
                                                color=(0x11ff0002); //rojo
                                                Opcion = "10";
                                            }
                                        }

                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

      //  Log.i(Opcion + " ", String.valueOf(potenciaTotal));
        return color;
    }
}


