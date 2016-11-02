package com.example.fool.mbu_sky;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Permission;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AddActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    EditText Vp1, Vs1, h1, p1, Vp2, Vs2, h2, p2, title;
    Entry entry;
    GoogleApiClient myApiClient;
    private Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (myApiClient == null) {
            myApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        FloatingActionButton save_btn = (FloatingActionButton) findViewById(R.id.save);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                title = (EditText)findViewById(R.id.title);
                Vp1 = (EditText) findViewById(R.id.Vp1);
                Vs1 = (EditText) findViewById(R.id.Vs1);
                h1 = (EditText) findViewById(R.id.h1);
                p1 = (EditText) findViewById(R.id.p1);

                Vp2 = (EditText) findViewById(R.id.Vp2);
                Vs2 = (EditText) findViewById(R.id.Vs2);
                h2 = (EditText) findViewById(R.id.h2);
                p2 = (EditText) findViewById(R.id.p2);

                //Toast.makeText(view.getContext(), , Toast.LENGTH_SHORT).show();

                //Toast.makeText(view.getContext(), String.valueOf(true)+"Hsn", Toast.LENGTH_LONG);

                if(mLastLocation!=null){
                    entry = new Entry(AddActivity.this, title.getText().toString(),mLastLocation.getLatitude(),mLastLocation.getLongitude(),
                            Double.valueOf(Vp1.getText().toString()), Double.valueOf(Vs1.getText().toString()), Double.valueOf(h1.getText().toString()), Double.valueOf(p1.getText().toString()),
                            Double.valueOf( Vp2.getText().toString()), Double.valueOf(Vs2.getText().toString()), Double.valueOf(h2.getText().toString()), Double.valueOf(p2.getText().toString()));

                    System.out.println(entry);

                    Boolean res = entry.save();
                    System.out.println(res);
                    System.out.println(entry);



                }else {
                    Toast.makeText(AddActivity.this, "Check Location Settings", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //mydb.insert("entries",null, contentValues);
    }


    @Override
    public void onConnected(Bundle connectionHint) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            System.out.println("Per");
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                myApiClient);
        if (mLastLocation != null) {
            System.out.println(String.valueOf(mLastLocation.getLatitude()));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    protected void onStart() {
        myApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        myApiClient.disconnect();
        super.onStop();
    }

}
