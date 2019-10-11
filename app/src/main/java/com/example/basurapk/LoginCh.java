package com.example.basurapk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginCh extends AppCompatActivity {

    EditText edtRuta, edtContrasenas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ch);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);

            }
        });


        edtRuta = findViewById(R.id.edtRuta);
        edtContrasenas = findViewById(R.id.edtContrasena);


        Button btnEntrarCh = (Button)findViewById(R.id.btnEntrarCh);

        btnEntrarCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtRuta.getText().toString().isEmpty() || edtContrasenas.getText().toString().isEmpty()){

                    openDialogInicio2();

                }else{

                    AccesarUsuarioch();

                }


            }
        });



        Button btnSalirCh = (Button)findViewById(R.id.btnSalirCh);

        btnSalirCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent9 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent9, 0);


            }
        });


    }


    private void AccesarUsuarioch(){

        final  String User = edtRuta.getText().toString();
        final  String Pw = edtContrasenas.getText().toString();

        Response.Listener<String> respuesta = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonRespuesta = null;

                try {
                    jsonRespuesta = new JSONObject(response);
                    boolean ok = jsonRespuesta.getBoolean("success");
                    if (ok == true){
                        AccesoPerfilSinMantenerSesionIniciada();
                    }else{
                        //validaciodeusercontradb(User,username);
                        AlertDialog.Builder alerta = new AlertDialog.Builder(LoginCh.this);
                        alerta.setMessage("Usuario o Contraseña incorrecta").setNegativeButton("Reintentar", null).create().show();

                    }
                } catch (JSONException e) {
                    e.getMessage();
                }
            }
        };

        LoginUsuarioRequest2 r = new LoginUsuarioRequest2(User.trim(),Pw.trim(),respuesta);
        RequestQueue cola = Volley.newRequestQueue(LoginCh.this);
        cola.add(r);
    }

    private void AccesoPerfilSinMantenerSesionIniciada(){

        Intent intent3 = new Intent(getApplicationContext(),chofer.class);
        startActivityForResult(intent3, 0);

    }

    public void openDialogInicio2(){
        dialogoLogin exampleDialog = new dialogoLogin();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }



}
