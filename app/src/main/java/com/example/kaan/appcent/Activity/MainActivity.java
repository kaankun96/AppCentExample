package com.example.kaan.appcent.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kaan.appcent.R;
import com.example.kaan.appcent.Services.GPSTracker;

public class MainActivity extends AppCompatActivity
{
    Button butonLoc;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butonLoc = (Button) findViewById(R.id.buttonLoc);

        butonLoc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if(gps.canGetLocation()) {
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Intent goToList = new Intent(MainActivity.this, ListActivity.class);
                    goToList.putExtra("lat", latitude);
                    goToList.putExtra("lng", longitude);
                    startActivity(goToList);


                } else {
                    gps.showSettingsAlert();
                }
            }
        });

    }

}
