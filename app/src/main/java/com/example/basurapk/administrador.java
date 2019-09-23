package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        TextView textview;
        textview = (TextView) findViewById(R.id.txtTabla);



        textview.setMovementMethod(new ScrollingMovementMethod());




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




        ImageView imgActualiza =findViewById(R.id.imgActualiza);

        imgActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                openDialogRegresh();

            }
        });


        Spinner spRutas=findViewById(R.id.spRutas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rutas, android.R.layout.simple_spinner_item);
        spRutas.setAdapter(adapter);





    }


    public void openDialogRegresh(){

        DialogoRefresh dialogoRefresh = new DialogoRefresh();

        dialogoRefresh.show(getSupportFragmentManager(),"Ejemplo Notificación");

    }


}
