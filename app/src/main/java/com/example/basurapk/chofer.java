package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class chofer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chofer);

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


                openDialogInicio();
            }
        });



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openDialogInicio();
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
