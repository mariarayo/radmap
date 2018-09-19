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
        Integer color=0x0000000;
        String Opcion = "";

        if ( potenciaTotal <2.50) {
            color=(0xf09ff1c); //verde
            Opcion = "1";
        }else{
            if ( potenciaTotal <=3.14) {
                color=(0xf25ff09);
                Opcion = "2";
            }else{
                if ( potenciaTotal <4.04) {
                    color=(0xf53ff08);
                    Opcion = "3";
                }else{
                    if ( potenciaTotal <4.97) {
                        color=(0xf81ff07);
                        Opcion = "4";
                    }else{
                        if ( potenciaTotal <6.8) {
                            color=(0xfb0ff06);
                            Opcion = "5";
                        }else{
                            if ( potenciaTotal <8.8) {
                                color=(0xfffee04);
                                Opcion = "6";
                            }else{
                                if ( potenciaTotal <11.42) {
                                    color=(0xfffbf03);
                                    Opcion = "7";
                                }else{
                                    if ( potenciaTotal <17.38) {
                                        color=(0xfff8f02);
                                        Opcion = "8";
                                    }else{
                                        if ( potenciaTotal <32.78) {
                                            color=(0xfff5e01);
                                            Opcion = "9";
                                        }else{
                                            if ( potenciaTotal >=32.78) {
                                                color=(0xfff0002); //rojo
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


