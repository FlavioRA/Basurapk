package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Buzon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzon);

        TextView textview;
        textview = (TextView) findViewById(R.id.textView26);


        textview.setMovementMethod(new ScrollingMovementMethod());




        ImageView imglogo=(ImageView)findViewById(R.id.imglogo);


        imglogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);

            }
        });


        Button idBorrarB = findViewById(R.id.idBorrarB);

        idBorrarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                openDialog();
            }
        });



    }

    public void openDialog(){
        DialogBorrar dialogoBorrar = new DialogBorrar();
        dialogoBorrar.show(getSupportFragmentManager(),"Ejemplo Administrador");

    }


}
