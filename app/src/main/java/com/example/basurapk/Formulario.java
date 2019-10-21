package com.example.basurapk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Formulario extends AppCompatActivity {

    String CamionDecide;
    String ChoferDecide;
    String FechaHoy;
    EditText edtComentarios;
    String Hora;
    String EquipoDios;
    String horaInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);





        final Date date = new Date();

        Button btnEnviar = findViewById(R.id.btnEnviar);
        edtComentarios = findViewById(R.id.edtComentarios);

       final RadioButton rbSiCamion = findViewById(R.id.rbSiCamion);
       final  RadioButton rbNoCamion = findViewById(R.id.rbNoCamion);

       final RadioButton rbSiChofer = findViewById(R.id.rbSiChofer);
       final RadioButton rbNoChofer = findViewById(R.id.rbNoChofer);


        Bundle extras = getIntent().getExtras();


        //Sacar Fecha


        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int monthDay = today.monthDay;
        int month = (today.month)+1;
        int Year = today.year;



        String dia =String.valueOf(monthDay);
        String mes=String.valueOf(month);
        String year=String.valueOf(Year);

        FechaHoy=year + "-" + mes +"-" + dia;

        //Fin Sacar Fecha
        //Sacar Horarios



        horaInicio =extras.getString("HoraInicios");

        SimpleDateFormat h = new SimpleDateFormat("h:mm a");
        Hora = h.format(date);

        //Sacar Fin Horarios


        EquipoDios=extras.getString("Equipo");

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (rbNoChofer.isChecked()){
                    ChoferDecide="No";
                }

                if (rbSiChofer.isChecked()){
                    ChoferDecide="Si";
                }

                if (rbNoCamion.isChecked()){
                    CamionDecide="No";
                }
                if(rbSiCamion.isChecked())
                {
                    CamionDecide="Si";
                }


                ejecutarServicio("http://192.168.1.67:8888/wsbasurapk/crearRecorrido.php");





            }
        });


    }


    public void openDialogInicio(){
        DialogCancelar exampleDialog = new DialogCancelar();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }




    private void ejecutarServicio(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(),"Se an eviado Correctamente", Toast.LENGTH_SHORT).show();
                Intent intent4= new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(intent4, 0);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),"FALLO SE APROXIMAN PROBLEMAS", Toast.LENGTH_SHORT).show();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();

                parametros.put("Fecha",FechaHoy);
                parametros.put("CamionSus",CamionDecide);
                parametros.put("PersonalSus",ChoferDecide);
                parametros.put("Comentario",edtComentarios.getText().toString());
                parametros.put("HoraFinal",Hora);
                parametros.put("HoraInicio",horaInicio);
                parametros.put("EquipoRT",EquipoDios);


                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(stringRequest);
    }



}
