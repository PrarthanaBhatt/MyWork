package com.prarthana.myworkapplication.components.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.prarthana.myworkapplication.MainActivity;
import com.prarthana.myworkapplication.R;

import static com.prarthana.myworkapplication.components.notification.App.CHANNEL_1_ID;
import static com.prarthana.myworkapplication.components.notification.App.CHANNEL_2_ID;

public class NotificationActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    Button oneBtn,twoBtn;
    EditText title,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationManagerCompat = NotificationManagerCompat.from(this);

        title = findViewById(R.id.title);
        msg = findViewById(R.id.msg);
        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);

    }

    public void sendOnChannel1(View view) {
        String strTitle = title.getText().toString();
        String strMessage = msg.getText().toString();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage",strMessage);

        PendingIntent actionIntent = PendingIntent.getBroadcast(this,0,broadcastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_looks_one_24)
                .setContentTitle(strTitle)
                .setContentText(strMessage)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .build();

        notificationManagerCompat.notify(1,notification);
    }

    public void sendOnChannel2(View view) {
        String strTitle = title.getText().toString();
        String strMessage = msg.getText().toString();

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_looks_two_24)
                .setContentTitle(strTitle)
                .setContentText(strMessage)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2,notification);
    }
}