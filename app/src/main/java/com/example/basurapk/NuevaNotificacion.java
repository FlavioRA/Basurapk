package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
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

public class NuevaNotificacion extends AppCompatActivity {


    EditText edtFecha;
    EditText edtNuevaNoticia;
    String Encargados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_notificacion);


        final Bundle extras = getIntent().getExtras();

        Encargados =extras.getString("EncargadoIDs");



        edtFecha=findViewById(R.id.edtFecha);
        edtNuevaNoticia=findViewById(R.id.edtNuevaNoticia);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView13 = (ImageView)findViewById(R.id.imageView13);

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent4, 0);

            }
        });

        //inicio Captura de datos

        Button btnEnviarN = findViewById(R.id.btnEnviarN);

        btnEnviarN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (edtNuevaNoticia.getText().toString().isEmpty() || edtFecha.getText().toString().isEmpty()) {
                     CamposVacios();

            }else {
                ejecutarServicio("https://basurapp.000webhostapp.com/webss/crearNoticia.php");
            }
            }
        });

        //Fin Captura de datos

    }


    public void openDialog(){
        DialogNoticia dialognoticia = new DialogNoticia();
        dialognoticia.show(getSupportFragmentManager(),"Ejemplo Administrador");

        edtNuevaNoticia.setText("");
        edtFecha.setText("");

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

                parametros.put("Fecha",edtFecha.getText().toString());
                parametros.put("Noticia",edtNuevaNoticia.getText().toString());
                parametros.put("Encargado",Encargados);


                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this );
        requestQueue.add(stringRequest);
    }


}
