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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class chofer extends AppCompatActivity {

    EditText edtPrueba;
    String Equipo;
    String HoraInicio;
    boolean Verdad;
    boolean Falso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer);
        final Date date = new Date();

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



        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SimpleDateFormat h = new SimpleDateFormat("h:mm a");
                HoraInicio = h.format(date);

                String EquipoCan =extras.getString("EquipoAc");


                Intent j = new Intent(getApplication(),chofer.class);
                j.putExtra("HoraInicio",HoraInicio);
                j.putExtra("EquipoEnv",EquipoCan);
                startActivity(j);



            }
        });



        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String horaInicio =extras.getString("HoraInicio");
                String Equipos =extras.getString("EquipoEnv");

                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                j.putExtra("Equipo",Equipos);
                startActivity(j);

                btnIniciar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnFinalizar.setEnabled(true);
            }
        });



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String horaInicio =extras.getString("HoraInicio");
                String Equipos =extras.getString("EquipoEnv");

                Intent j = new Intent(chofer.this,Formulario.class);
                j.putExtra("HoraInicios",horaInicio);
                j.putExtra("Equipo",Equipos);
                startActivity(j);

                btnIniciar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnFinalizar.setEnabled(true);

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
