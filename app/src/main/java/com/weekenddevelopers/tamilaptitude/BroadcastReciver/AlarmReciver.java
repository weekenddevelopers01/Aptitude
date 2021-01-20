package com.weekenddevelopers.tamilaptitude.BroadcastReciver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.weekenddevelopers.tamilaptitude.MainActivity;
import com.weekenddevelopers.tamilaptitude.R;

public class AlarmReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent in = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, in, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notification1")
                .setSmallIcon(R.drawable.ic_book_black_24dp)
                .setContentIntent(pendingIntent)
                .setContentTitle("Tamil Aptitude")
                .setContentText("train your knowledge")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(200, builder.build());
    }
}
