package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class info_rutas1 extends AppCompatActivity {

    String Horarios,Dias,Calles,Numero,Color;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rutas1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView = (ImageView)findViewById(R.id.imageView4);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent4, 0);
            }
        });





        Button btnRuta9 = (Button) findViewById(R.id.btnRuta9);
        Button btnRuta10 = (Button) findViewById(R.id.btnRuta10);
        Button btnRuta11 = (Button) findViewById(R.id.btnRuta11);



        //Guardar informacion para ser enviada

        btnRuta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buscarRutas("http://192.168.23.2:8888/wsbasurapk/informacionRutasDetail.php?numeroR=9");

                Intent intent3 = new Intent(view.getContext(),InfoRutasDetail.class);
                startActivityForResult(intent3, 0);

            }
        });


        btnRuta10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(),InfoRutasDetail.class);
                startActivityForResult(intent3, 0);



            }
        });

        btnRuta11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(),InfoRutasDetail.class);
                startActivityForResult(intent3, 0);


            }
        });


        //Guardar información para ser enviada FIN



    }


    //Metodo buscar datos

    private void buscarRutas(String URL){

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {

                    try {

                        Intent z = new Intent(info_rutas1.this , InfoRutasDetail.class);

                        jsonObject = response.getJSONObject(i);
                        Horarios = jsonObject.getString("RHorarios");
                        Color = jsonObject.getString("RColor");
                        Dias = jsonObject.getString("RDias");
                        Calles = jsonObject.getString("RCalles");
                        Numero = jsonObject.getString("Numero");

                        z.putExtra("Numero",Numero);




                    } catch (JSONException e) {

                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }//for
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de conexion", Toast.LENGTH_SHORT).show();
            }
        }

        );


        requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(jsonArrayRequest);

    }



}
