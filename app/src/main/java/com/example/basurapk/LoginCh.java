package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LoginCh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ch);



        ImageView imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);

            }
        });


        Button btnEntrarCh = (Button)findViewById(R.id.btnEntrarCh);

        btnEntrarCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent8 = new Intent(view.getContext(),chofer.class);
                startActivityForResult(intent8, 0);

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



}
