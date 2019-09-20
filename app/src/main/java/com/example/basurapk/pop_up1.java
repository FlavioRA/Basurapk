package com.example.basurapk;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class pop_up1 extends Activity {



    ImageView exit;
    Dialog epicDialog;
    TextView titleTv, messageTv, diasTv;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_up1);

        epicDialog = new Dialog(this);


    }

    public void MostrarDialog(){
        epicDialog.setContentView(R.layout.pop_up1);
        exit = (ImageView) epicDialog.findViewById(R.id.exit);
        titleTv = (TextView) epicDialog.findViewById(R.id.Titulo);
        messageTv = (TextView) epicDialog.findViewById(R.id.Calles);
        diasTv = (TextView) epicDialog.findViewById(R.id.Dias);

        exit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }
}


