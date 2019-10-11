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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginAd extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ad);



        edtContrasena=findViewById(R.id.edtContrasena);
        edtUsuario=findViewById(R.id.edtUsuario);



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);
            }
        });

        //Boton Entrar

        Button btnEntrar = (Button)findViewById(R.id.btnEntrarCh);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtContrasena.getText().toString().isEmpty() || edtUsuario.getText().toString().isEmpty() ){

                    openDialogInicio2();

                }else{
                         AccesarUsuario();
                }
            }
        });

        //Fin Boton Entrar


        Button btnSalir = (Button)findViewById(R.id.btnSalirCh);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent5, 0);
            }
        });


    }

    //Medotodo de login

    private void AccesarUsuario(){

        final  String User = edtUsuario.getText().toString();
        final  String Pw = edtContrasena.getText().toString();

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
                        AlertDialog.Builder alerta = new AlertDialog.Builder(LoginAd.this);
                        alerta.setMessage("Usuario o Contraseña incorrecta").setNegativeButton("Reintentar", null).create().show();

                    }
                } catch (JSONException e) {
                    e.getMessage();
                }
            }
        };

        LoginUsuarioRequest r = new LoginUsuarioRequest(User.trim(),Pw.trim(),respuesta);
        RequestQueue cola = Volley.newRequestQueue(LoginAd.this);
        cola.add(r);
    }

    private void AccesoPerfilSinMantenerSesionIniciada(){

        Intent intent3 = new Intent(getApplicationContext(),administrador.class);
        startActivityForResult(intent3, 0);

    }

    public void openDialogInicio2(){
        dialogoLogin exampleDialog = new dialogoLogin();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }



}
