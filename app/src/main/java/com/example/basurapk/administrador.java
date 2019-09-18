package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);





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




    }
}
