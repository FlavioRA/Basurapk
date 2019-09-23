package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class infoRutas extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rutas2);

        ImageView imageView = (ImageView)findViewById(R.id.imageView4);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent4, 0);

            }
        });
        Button r1 = (Button) findViewById(R.id.btnR1);
        Button r2 = (Button) findViewById(R.id.btnR2);
        Button r3 = (Button) findViewById(R.id.btnR3);
        Button r4 = (Button) findViewById(R.id.btnR4);
        Button r5 = (Button) findViewById(R.id.btnR2);






    }

}


