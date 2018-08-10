package com.maria.rayo.radmap;



public class Antena {
    double lon;
    double lat;
    String tipo;
    int rango;

    public Antena (){
        lon = 0;
        lat=0;
        tipo= "";
        rango = 0;
    }

    public Antena (double currentlon, String currenttipo,double currentlat, int currentrango){
        lon = currentlon;
        lat = currentlat;
        tipo = currenttipo;
        rango = currentrango;
    }




}
