package com.example.basurapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class contactoL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_l);


        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(intent3, 0);

            }
        });


        //----------------------------------------------------------



        Button lla = (Button) findViewById(R.id.btnAseo);
        lla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:4432848484"));
                if (ActivityCompat.checkSelfPermission(contactoL.this, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED)
                    return;
                startActivity(i);
            }

        });
    }
}
