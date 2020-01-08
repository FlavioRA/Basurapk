package com.example.basurapk;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import static com.example.basurapk.notifi.CHANNEL_ID;

public class servicioChofer extends Service {


    private Context thisContext=this;

    private CountDownTimer MapaCountDownTimerr;

    Double latitud;
    Double longitud;
    String longitudD;
    String latitudD;
    String EquipoCan;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        EquipoCan = intent.getStringExtra("EquipoPP");

        locationStart();
        Coordenadas();


        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Servicio BasurapK")
                .setContentText("Ejecutando ruta " + EquipoCan)
                .setSmallIcon(R.drawable.logservices)
                .build();


        startForeground(1,notification);


        return START_NOT_STICKY;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        MapaCountDownTimerr.cancel();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Metoos


    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        servicioChofer.Localizacion Local = new Localizacion();
        Local.setMainActivity(thisContext);

        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) thisContext, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }

        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);



    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }

    public class Localizacion implements LocationListener {
        servicioChofer mainActivity;
        public servicioChofer getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(Context mainActivity) {
            this.mainActivity = (servicioChofer) mainActivity;
        }
        @Override
        public void onLocationChanged(Location loc) {



            latitud = loc.getLatitude();
            longitud= loc.getLongitude();




        }
        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            Toast.makeText(getApplicationContext(),"GPS Desactivado" ,Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            Toast.makeText(getApplicationContext(),"El GPS a vuelto a tener señal" ,Toast.LENGTH_LONG).show();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }

    public void Coordenadas(){



        MapaCountDownTimerr = new CountDownTimer(29999999, 7000) {



            public void onTick(long millisUntilFinished) {


                if (longitud==null || latitud ==null){

                    Toast.makeText(getApplicationContext(),"CARGANDO....!" ,Toast.LENGTH_LONG).show();

                }else{

                    ejecutarServicio("https://basurapk.com/webservices/mandarUbicacion.php");
                    Toast.makeText(getApplicationContext(),"Longitud " + latitud +"  Latitud  " + longitud,Toast.LENGTH_LONG).show();


                }
            }

            public void onFinish() {


            }
        }.start();

    }

    private void ejecutarServicio(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),"UPDATE INCORRECTO", Toast.LENGTH_SHORT).show();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();

                longitudD = Double.toString(longitud);
                latitudD = Double.toString(latitud);



                parametros.put("latitud",latitudD);
                parametros.put("longitud",longitudD);
                parametros.put("camion",EquipoCan);

                return parametros;

            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(stringRequest);
    }



}
