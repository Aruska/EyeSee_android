package org.tensorflow.lite.examples.objectdetection;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.objectdetection.R;

public class TestActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gravitySensor;

    private TextView accelerationTextView;
    private TextView resultTextView;
    private float[] gravityValues = new float[3];
    private float[] linearAcceleration = new float[3];
    private static final float FALL_THRESHOLD = 9.8f; // 임계값 설정 (가속도)

    private boolean fallDetected = false;
    private float fallAcceleration = 0;
    private long fallTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // XML에서 정의한 텍스트뷰 가져오기
        accelerationTextView = findViewById(R.id.accelerationTextView);
        resultTextView = findViewById(R.id.resultTextView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
            gravityValues = event.values.clone();
        } else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            linearAcceleration = event.values.clone();
            displayAcceleration();
            checkFall();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 센서 정확도 변경 시 호출
    }

    private void displayAcceleration() {
        float magnitude = calculateMagnitude(linearAcceleration);
        accelerationTextView.setText("가속도: " + magnitude);
    }

    private void checkFall() {
        float magnitude = calculateMagnitude(linearAcceleration);
        if (magnitude > FALL_THRESHOLD && !fallDetected) {
            // 휴대폰이 떨어졌다는 조건 충족
            fallDetected = true;
            fallAcceleration = magnitude;
            fallTime = SystemClock.elapsedRealtime();

            // 결과를 텍스트뷰에 설정
            resultTextView.setText("휴대폰이 떨어졌습니다!\n가속도: " + fallAcceleration + "\n시간: " + fallTime);
        }
    }

    private float calculateMagnitude(float[] values) {
        float sum = 0;
        for (float value : values) {
            sum += value * value;
        }
        return (float) Math.sqrt(sum);
    }
}