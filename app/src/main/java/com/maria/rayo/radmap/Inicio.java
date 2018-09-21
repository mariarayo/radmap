package com.maria.rayo.radmap;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Handler;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.R.*;
import android.view.WindowManager;

public class Inicio extends Activity {
    private final int DURACION_SPLASH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_inicio);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Inicio.this, MapsActivity.class);
                startActivity(intent);
                finish();
            }

            ;
        }, DURACION_SPLASH);
    }
}

