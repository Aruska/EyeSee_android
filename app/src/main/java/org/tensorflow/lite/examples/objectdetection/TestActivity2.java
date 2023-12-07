package org.tensorflow.lite.examples.objectdetection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class TestActivity2 extends AppCompatActivity {

    private TextView accelerationTextView;
    private TextView gyroscopeTextView;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_2);

        accelerationTextView = findViewById(R.id.accelerationTextView);
        gyroscopeTextView = findViewById(R.id.gyroscopeTextView);

        // 앱이 시작될 때 서비스 시작
        startService(new Intent(TestActivity2.this, SensorService2.class));

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction() != null) {
                    switch (intent.getAction()) {
                        case "acceleration_data":
                            float xAccel = intent.getFloatExtra("x", 0.0f);
                            float yAccel = intent.getFloatExtra("y", 0.0f);
                            float zAccel = intent.getFloatExtra("z", 0.0f);

                            accelerationTextView.setText("Acceleration: X=" + xAccel + ", Y=" + yAccel + ", Z=" + zAccel);
                            break;

                        case "gyroscope_data":
                            float xGyro = intent.getFloatExtra("x", 0.0f);
                            float yGyro = intent.getFloatExtra("y", 0.0f);
                            float zGyro = intent.getFloatExtra("z", 0.0f);

                            gyroscopeTextView.setText("Gyroscope: X=" + xGyro + ", Y=" + yGyro + ", Z=" + zGyro);
                            break;
                    }
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("acceleration_data");
        intentFilter.addAction("gyroscope_data");

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        stopService(new Intent(this, SensorService2.class));
    }
}