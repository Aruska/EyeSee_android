package org.tensorflow.lite.examples.objectdetection;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.ActivityCompat;

public class GPSService extends Service {

    private static final String TAG = GPSService.class.getSimpleName();

    private LocationManager locationManager;
    private LocationListener locationListener;
    private Location lastLocation; // Variable to store the last known location

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize LocationManager and LocationListener
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Handle location updates
                Log.d(TAG, "Latitude: " + location.getLatitude() + ", Longitude: " + location.getLongitude());

                // Update the last known location
                lastLocation = location;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // Handle location provider status changes
            }

            @Override
            public void onProviderEnabled(String provider) {
                // Handle location provider enabled
            }

            @Override
            public void onProviderDisabled(String provider) {
                // Handle location provider disabled
            }
        };

        // Request location updates (you can adjust parameters based on your needs)
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    1000,   // minimum time interval between updates (milliseconds)
                    10,     // minimum distance between updates (meters)
                    locationListener
            );

            // Get the last known location initially
            lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                Log.d(TAG, "Last Known Latitude: " + lastLocation.getLatitude() +
                        ", Longitude: " + lastLocation.getLongitude());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Remove location updates when the service is stopped
        if (locationManager != null && locationListener != null) {
            locationManager.removeUpdates(locationListener);
        }
    }

    // Provide a method to retrieve the last known location from other components
    public Location getLastLocation() {
        return lastLocation;
    }
}