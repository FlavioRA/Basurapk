package com.example.basurapk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogoLogin extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder .setTitle("Aviso BasurapK").setMessage("Campo Vacio en el Usuario o Contraseña")
                .setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Intent intent4 = new Intent(getContext(), LoginAd.class);
                        startActivityForResult(intent4, 0);


                    }
                });

        return builder.create();

    }


}
