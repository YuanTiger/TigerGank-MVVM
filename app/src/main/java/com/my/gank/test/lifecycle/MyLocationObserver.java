package com.my.gank.test.lifecycle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import org.jetbrains.annotations.NotNull;

/**
 * Author: mengyuan
 * Date  : 2021/10/12/4:31 下午
 * E-Mail: mengyuanzz@126.com
 * -----------
 */
public class MyLocationObserver implements DefaultLifecycleObserver {


    private static final String TAG = "MyLocationObserver_";


    private Context context;

    private LocationManager locationManager;

    private MyLocationListener listener;

    public MyLocationObserver(Context context) {
        this.context = context;
    }


    @Override
    public void onCreate(@NonNull @NotNull LifecycleOwner owner) {
        Log.i(TAG, "MyLocationObserver-onCreate()");

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        listener = new MyLocationListener();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1, listener);
    }

    @Override
    public void onDestroy(@NonNull @NotNull LifecycleOwner owner) {
        Log.i(TAG, "MyLocationObserver-onDestroy()");

        locationManager.removeUpdates(listener);

    }

    static class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.i(TAG, "onLocationChanged：" + location.toString());
        }
    }
}
