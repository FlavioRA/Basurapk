package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class infoRutas extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rutas2);

        Button r1 = (Button) findViewById(R.id.btnR1);
        Button r2 = (Button) findViewById(R.id.btnR2);
        Button r3 = (Button) findViewById(R.id.btnR3);
        Button r4 = (Button) findViewById(R.id.btnR4);
        Button r5 = (Button) findViewById(R.id.btnR2);

        r1.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v) {
                startActivity(new Intent(infoRutas.this,pop_up1.class));
            }
        });

        r2.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v) {
                startActivity(new Intent(infoRutas.this,pop_up1.class));
            }
        });

        r3.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v) {
                startActivity(new Intent(infoRutas.this,pop_up1.class));
            }
        });

        r4.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v) {
                startActivity(new Intent(infoRutas.this,pop_up1.class));
            }
        });

        r5.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v) {
                startActivity(new Intent(infoRutas.this,pop_up1.class));
            }
        });
    }

}


