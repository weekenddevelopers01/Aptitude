package com.weekenddevelopers.tamilaptitude.BroadcastReciver;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class Network_Check {


    public static void isNetworkconnected(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Connectivity Lost !");

        builder.setMessage("Check Your internet connection")
                .setCancelable(true).setCancelable(true).setPositiveButton("retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();

        // show it
        alertDialog.show();
    }
}
