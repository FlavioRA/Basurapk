package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NuevaNotificacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_notificacion);

        ImageView imageView13 = (ImageView)findViewById(R.id.imageView13);

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent4, 0);

            }
        });


        Button btnEnviarN = findViewById(R.id.btnEnviarN);

        btnEnviarN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                openDialog();
            }
        });

    }


    public void openDialog(){
        DialogNoticia dialognoticia = new DialogNoticia();
        dialognoticia.show(getSupportFragmentManager(),"Ejemplo Administrador");

    }


}
