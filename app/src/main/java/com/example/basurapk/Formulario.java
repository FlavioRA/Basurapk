package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

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




                openDialogFormulario();
            }
        });








    }

    public void openDialogFormulario(){
        DialogFormulario exampleDialog = new DialogFormulario();
        exampleDialog.show(getSupportFragmentManager(),"Ejemplo Administrador");
    }


}
