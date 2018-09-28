package com.maria.rayo.radmap;

public class Permissions {

    private static final Permissions ourInstance = new Permissions();
    public static Permissions getInstance() {
        return ourInstance;
    }

    private Permissions() {
    }


    public final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 77;
    public final int REQUEST_CHECK_SETTINGS = 78;
    public final int permissionCoarseLocation = 65;
    public final int permissionAccesFine = 66;
    public final int permissionWriteExternalStorage = 67;
    public final int permissionReadExternalStorage = 69;
    public final int permissionCamera = 68;

}
