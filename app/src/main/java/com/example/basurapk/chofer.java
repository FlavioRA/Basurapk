package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class chofer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer);




        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ImageView imageView12 =(ImageView)findViewById(R.id.imageView12);

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);
            }
        });


        Button btnIniciar = findViewById(R.id.btnIniciar);
        Button btnCancelar=findViewById(R.id.btnCancelar);
        Button btnFinalizar=findViewById(R.id.btnFinalizar);


        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openDialogInicio2();

            }
        });



        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle extras = getIntent().getExtras();
                String horaInicio =extras.getString("HoraInicio");
                String Equipo=extras.getString("Equipo");

                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                j.putExtra("Equipo",Equipo);
                startActivity(j);


            }
        });



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle extras = getIntent().getExtras();
                String horaInicio =extras.getString("HoraInicio");


                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                startActivity(j);
            }
        });




    }

    public void openDialogInicio(){


        DialogCancelaFinaliza exampleDialog = new DialogCancelaFinaliza();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
 }


    public void openDialogInicio2(){
        DialogIniciado exampleDialog = new DialogIniciado();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }



}
