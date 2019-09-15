package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class contacto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


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
}
