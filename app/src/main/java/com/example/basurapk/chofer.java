package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Location;
import android.location.LocationManager;
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
import com.google.android.gms.dynamic.IFragmentWrapper;
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
    String longitudD;
    String latitudD;

    String EquipoCan;
    private CountDownTimer MapaCountDownTimerr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer);


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


                btnCancelar.setEnabled(true);
                btnFinalizar.setEnabled(true);
                btnIniciar.setEnabled(false);


                bajarCoordenadas();


            }
        });




        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnIniciar.setEnabled(false);

                Cancelar();

                if (EquipoCan.equals("9")) {

                    latitud=17.962654;
                    longitud=-102.198716;

                    ejecutarServicio("http://basurapk.com/WebServiceAplicacion/mandarUbicacion.php");
                }

                if (EquipoCan.equals("10")) {

                    latitud=17.962899;
                    longitud=-102.19832;

                    ejecutarServicio("http://basurapk.com/WebServiceAplicacion/mandarUbicacion.php");
                }

                if (EquipoCan.equals("11")) {

                    latitud=17.963150;
                    longitud=-102.197943;

                    ejecutarServicio("http://basurapk.com/WebServiceAplicacion/mandarUbicacion.php");
                }



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
                Cancelar();

                if (EquipoCan.equals("9")) {

                    latitud=17.962654;
                    longitud=-102.198716;

                    ejecutarServicio("http://basurapk.com/WebServiceAplicacion/mandarUbicacion.php");
                }

                if (EquipoCan.equals("10")) {

                    latitud=17.962899;
                    longitud=-102.19832;

                    ejecutarServicio("http://basurapk.com/WebServiceAplicacion/mandarUbicacion.php");
                }

                if (EquipoCan.equals("11")) {

                    latitud=17.963150;
                    longitud=-102.197943;

                    ejecutarServicio("http://basurapk.com/WebServiceAplicacion/mandarUbicacion.php");
                }


                String horaInicio =extras.getString("HoraInicio");


                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                j.putExtra("EquipoEnv",EquipoCan);

                startActivity(j);


            }
        });


    }



    public void bajarCoordenadas(){


        MapaCountDownTimerr = new CountDownTimer(99999999, 5000) {

            public void onTick(long millisUntilFinished) {



                Toast.makeText(getApplicationContext(),"Enviando Ubicación..!", Toast.LENGTH_SHORT).show();
            }

            public void onFinish() {


            }
        }.start();


    }



    public void Cancelar(){

        Toast.makeText(getApplicationContext(),"Dejando de transmitir", Toast.LENGTH_SHORT).show();
        MapaCountDownTimerr.cancel();

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

                parametros.put("longitud",longitudD);
                parametros.put("latitud",latitudD);
                parametros.put("camion",EquipoCan);

                return parametros;

            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(stringRequest);
    }





    @Override
    public void onBackPressed (){

        Intent intent2= new Intent(getApplicationContext(),MainActivity.class);
        startActivityForResult(intent2, 0);

    }


}
