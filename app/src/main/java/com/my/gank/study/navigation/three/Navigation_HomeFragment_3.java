package com.my.gank.study.navigation.three;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.Navigation;

import com.my.gank.R;


/**
 * Author: mengyuan
 * Date  : 2021/10/18/4:31 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class Navigation_HomeFragment_3 extends Fragment {


    private int notificationId;


    public Navigation_HomeFragment_3() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btSend = getView().findViewById(R.id.bt_send_notification);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();

            }
        });
    }


    private void sendNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel yt_myChannel = new NotificationChannel(getActivity().getPackageName(), "Yt_MyChannel", NotificationManager.IMPORTANCE_DEFAULT);

            yt_myChannel.setDescription("My notification channel");

            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(yt_myChannel);

        }

        Notification notification = new NotificationCompat.Builder(getActivity(), getActivity().getPackageName())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Deep Link")
                .setContentText("点击我试试")
                .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
                .setContentIntent(getPendingIntent())
                .build();

        NotificationManagerCompat from = NotificationManagerCompat.from(getActivity());
        from.notify(notificationId++, notification);
    }

    private PendingIntent getPendingIntent() {
        Bundle bundle = new Bundle();
        bundle.putString("user_name","XXXXX");

        NavController navController = Navigation.findNavController(getActivity(), R.id.bt_send_notification);
        NavDeepLinkBuilder deepLink = navController
                .createDeepLink()
                .setGraph(R.navigation.nav_3)
                .setArguments(bundle)
                .setDestination(R.id.detailFragment_3);
        return deepLink.createPendingIntent();

    }
}
