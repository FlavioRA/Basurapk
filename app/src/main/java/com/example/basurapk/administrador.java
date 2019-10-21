package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class administrador extends AppCompatActivity {

    ListView idLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        ImageView imgNotif = (ImageView)findViewById(R.id.imgNotif);
        imgNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent6= new Intent(view.getContext(),NuevaNotificacion.class);
                startActivityForResult(intent6, 0);

            }
        });



        ImageView imgBuzon = (ImageView)findViewById(R.id.imgBuzon);
        imgBuzon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent9= new Intent(view.getContext(),Buzon.class);
                startActivityForResult(intent9, 0);

            }
        });


        ImageView imageView5 = (ImageView)findViewById(R.id.imageView5);


        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2= new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent2, 0);

            }
        });




        ImageView imgActualiza =findViewById(R.id.imgActualiza);

        imgActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                openDialogRegresh();

            }
        });


        //Mandar a llamar los datos;

        idLista = findViewById(R.id.idLista);

        String consulta="http://192.168.23.3:8888/wsbasurapk/bajarRecorridos.php";

        EnviarRecibirDatos(consulta);



        Spinner spRutas=findViewById(R.id.spRutas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rutas, android.R.layout.simple_spinner_item);
        spRutas.setAdapter(adapter);





    }


    public void openDialogRegresh(){

        DialogoRefresh dialogoRefresh = new DialogoRefresh();

        dialogoRefresh.show(getSupportFragmentManager(),"Ejemplo Notificación");

    }



    public void EnviarRecibirDatos(String URL){


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        CargarListView(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }

    public void CargarListView(JSONArray ja){

        ArrayList<String> lista = new ArrayList<>();

        for(int i=0;i<ja.length();i+=7){

            try {

                lista.add("\n"+ja.getString(i)+"\n"+ja.getString(i+1)+"\n"+ja.getString(i+2)+"\n"+ja.getString(i+3)+"\n"
                +ja.getString(i+4)+"\n"+ja.getString(i+5)+"\n"+ja.getString(i+6));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        idLista.setAdapter(adaptador);



    }






}
