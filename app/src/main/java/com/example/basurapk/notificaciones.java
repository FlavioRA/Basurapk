package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class notificaciones extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(view.getContext(),MainActivity.class);
                startActivityForResult(intent3, 0);

            }
        });



        ImageView imgRefresca =findViewById(R.id.imgRefresca);

        imgRefresca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                openDialogRegresh();

            }
        });



    }

    public void openDialogRegresh(){

        DialogoRefresh dialogoRefresh = new DialogoRefresh();

        dialogoRefresh.show(getSupportFragmentManager(),"Ejemplo Notificación");

    }





}
