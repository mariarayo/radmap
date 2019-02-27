package com.maria.rayo.radmap;

import android.support.v4.app.ActivityCompat;

public class Permissions {

    private static final Permissions ourInstance = new Permissions();
    private android.app.Activity context;
    private final int REQUEST_PERMISSION = 200;

    public final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 77;
    public final int REQUEST_CHECK_SETTINGS = 78;
    public final int permissionCoarseLocation = 65;
    public final int permissionAccesFine = 66;
    public final int permissionWriteExternalStorage = 67;
    public final int permissionReadExternalStorage = 69;
    public final int permissionCamera = 68;


    public static Permissions getInstance() {

        return ourInstance;
    }



    public Permissions(android.app.Activity context){
        this.context = context;

    }

    private Permissions() {

    }


    public void setPermission(){
        ActivityCompat.requestPermissions( this.context,
                new String[]{android.Manifest.permission.READ_PHONE_STATE
                        ,android.Manifest.permission.ACCESS_FINE_LOCATION
                        ,android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ,android.Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_PERMISSION);
    }









}
