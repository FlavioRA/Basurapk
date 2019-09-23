package com.example.basurapk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialogInicio();

            }
        });


    }


    public void openDialogInicio(){
        DialogCancelar exampleDialog = new DialogCancelar();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }




}
