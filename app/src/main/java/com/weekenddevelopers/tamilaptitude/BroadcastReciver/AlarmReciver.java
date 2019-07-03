package com.weekenddevelopers.tamilaptitude.BroadcastReciver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.weekenddevelopers.tamilaptitude.MainActivity;
import com.weekenddevelopers.tamilaptitude.R;

public class AlarmReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long when =System.currentTimeMillis();
        NotificationManager notificationManager=  (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

        Intent notificationIntent= new Intent (context, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Uri  alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder= new NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_launcher_new)
                .setContentTitle("Tamil Apptitude")
                .setContentText("train your knowledge")
                .setSound(alarmSound)
                .setAutoCancel(true)
                .setWhen(when)
                .setContentIntent(pendingIntent);

        notificationManager.notify(0,builder.build());
    }
}
