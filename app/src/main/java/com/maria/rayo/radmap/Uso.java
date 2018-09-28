package com.maria.rayo.radmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Uso extends AppCompatActivity {

    public TextView text14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uso);
        text14 = (TextView) findViewById(R.id.text14);
        text14.setText(Html.fromHtml("<a href=\""+ "https://drive.google.com/file/d/1stVURsj9VO4lgxSkYSFieC3zxNiy8Umf/view?usp=sharing" + "\">" + "RadMap.pdf" + "</a>"));
        text14.setClickable(true);
        text14.setMovementMethod (LinkMovementMethod.getInstance());

        getSupportActionBar().hide();



    }
}
