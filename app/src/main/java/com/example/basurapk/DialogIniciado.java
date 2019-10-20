package com.example.basurapk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import java.security.AccessController;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogIniciado extends AppCompatDialogFragment {

    String HoraInicio;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder .setTitle("Aviso BasurapK").setMessage("Recorrido Iniciado")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {


                    final Date date = new Date();

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        SimpleDateFormat h = new SimpleDateFormat("h:mm a");
                        HoraInicio = h.format(date);


                        Intent j = new Intent(getContext(),chofer.class);
                        j.putExtra("HoraInicio",HoraInicio);
                        startActivity(j);


                    }
                });

        return builder.create();

    }

}
