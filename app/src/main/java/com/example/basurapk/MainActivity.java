package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

      Button btnInfoRuta=(Button)findViewById(R.id.btnInfoRuta);

      btnInfoRuta.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent intent = new Intent (view.getContext(), infoRutas.class);
              startActivityForResult(intent, 0);

          }
      });


        Button btnMapa=(Button)findViewById(R.id.btnMapa);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent (view.getContext(), mapa.class);
                startActivityForResult(intent2, 0);

            }
        });


        Button btnNotificacion = (Button)findViewById(R.id.btnNotificacion);

        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3= new Intent(view.getContext(),notificaciones.class);
                startActivityForResult(intent3, 0);

            }
        });



        Button btnContacto = (Button)findViewById(R.id.btnContacto);

        btnContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4= new Intent(view.getContext(),contacto.class);
                startActivityForResult(intent4, 0);

            }
        });



    }
}
