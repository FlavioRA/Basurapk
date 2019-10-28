package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class chofer extends AppCompatActivity {



Double latitud;
Double longitud;
int i;
String EquipoCan;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer);


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        final Bundle extras = getIntent().getExtras();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ImageView imageView12 =(ImageView)findViewById(R.id.imageView12);

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);
            }
        });


        final Button btnIniciar=findViewById(R.id.btnIniciar);
        final Button btnCancelar=findViewById(R.id.btnCancelar);
        final Button btnFinalizar=findViewById(R.id.btnFinalizar);

        EquipoCan =extras.getString("EquipoAc");

        btnCancelar.setEnabled(false);
        btnFinalizar.setEnabled(false);

        //----------------

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnIniciar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnFinalizar.setEnabled(true);



            }
        });


        //---------------


        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(final Location location) {


                        new CountDownTimer(10000000, 10000) {

                            public void onTick(long millisUntilFinished) {

                                latitud = location.getLatitude();
                                longitud = location.getLongitude();
                                ejecutarServicio("http://192.168.23.3:8888/wsbasurapk/mandarUbicacion.php");
                                Toast.makeText(getApplicationContext(),"PUNTOS ACTUALIZADOS", Toast.LENGTH_SHORT).show();
                            }

                            public void onFinish() {

                                Toast.makeText(getApplicationContext(),"PUNTOS NO ACTUALIZADOS", Toast.LENGTH_SHORT).show();

                            }
                        }.start();

                        if (location != null) {

                        }
                    }
                });


        //---------------


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnIniciar.setEnabled(false);

                latitud=17.961404;
                longitud=-102.197151;

                ejecutarServicio("http://192.168.23.3:8888/wsbasurapk/mandarUbicacion.php");


                String horaInicio =extras.getString("HoraInicio");


                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                j.putExtra("EquipoEnv",EquipoCan);

                startActivity(j);

            }
        });


        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnIniciar.setEnabled(false);


                latitud=17.961404;
                longitud=-102.197151;

                ejecutarServicio("http://192.168.23.3:8888/wsbasurapk/mandarUbicacion.php");


                String horaInicio =extras.getString("HoraInicio");


                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                j.putExtra("EquipoEnv",EquipoCan);

                startActivity(j);


            }
        });





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

                String longitudD = Double.toString(longitud);
                String latitudD = Double.toString(latitud);

                parametros.put("longitud",longitudD);
                parametros.put("latitud",latitudD);
                parametros.put("camion",EquipoCan);


                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(stringRequest);
    }




}
