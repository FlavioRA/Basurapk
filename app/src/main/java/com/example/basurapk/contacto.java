package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.format.Time;
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

import java.util.HashMap;
import java.util.Map;

public class contacto extends AppCompatActivity {



    EditText edtNombre;
    EditText edtTelefono;
    EditText edtEmail;
    EditText edtMensaje;
    Button btnEnviar;
    String FechaHoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);



        edtNombre=findViewById(R.id.edtNombre);
        edtTelefono=findViewById(R.id.edtTelefono);
        edtEmail=findViewById(R.id.edtEmail);
        edtMensaje= findViewById(R.id.edtMensaje);
        btnEnviar=findViewById(R.id.btnEnviar);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//Envio de datos


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(edtNombre.getText().toString().isEmpty() || edtMensaje.getText().toString().isEmpty() || edtTelefono.getText().toString().isEmpty() || edtEmail.getText().toString().isEmpty() ){

                    CamposVacios();

                }else {

                    ejecutarServicio("https://basurapp.000webhostapp.com/webss/mandarMensaje.php");
                }
            }
        });


        //Fin envio de datos



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




        ImageView imageView10 = (ImageView)findViewById(R.id.imageView10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent(view.getContext(),contactoL.class);
                startActivityForResult(intent3, 0);

            }
        });



        ImageView imageView11 = (ImageView)findViewById(R.id.imageView11);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);

            }
        });

    }






public void openDialog(){

        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    edtNombre.setText("");
    edtTelefono.setText("");
    edtEmail.setText("");
    edtMensaje.setText("");

}


        public void CamposVacios(){

        dialogoCamposVacios dialogoCamposVacios = new dialogoCamposVacios();
        dialogoCamposVacios.show(getSupportFragmentManager(),"Ejemplo Administrador");

        }



    public void dialogonoEnvio(){

        MensajeNoEnviado mensajeNoEnviado = new MensajeNoEnviado();
        mensajeNoEnviado.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }




    private void ejecutarServicio(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                openDialog();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                dialogonoEnvio();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();

                parametros.put("Nombre",edtNombre.getText().toString());
                parametros.put("Telefono",edtTelefono.getText().toString());
                parametros.put("Email",edtEmail.getText().toString());
                parametros.put("Mensaje",edtMensaje.getText().toString());
                parametros.put("Fecha",FechaHoy);

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(stringRequest);
    }




}
