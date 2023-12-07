package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J \u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J \u0010\"\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/SensorService3;", "Landroid/app/Service;", "()V", "COLLISION_THRESHOLD_ACCELEROMETER", "", "COLLISION_THRESHOLD_GYROSCOPE", "accelerometerSensor", "Landroid/hardware/Sensor;", "gyroscopeSensor", "isDangerDetected", "", "sensorEventListener", "Landroid/hardware/SensorEventListener;", "sensorManager", "Landroid/hardware/SensorManager;", "tts", "Landroid/speech/tts/TextToSpeech;", "detectCollision", "", "accelerationValues", "", "detectCollisionWithGyroscope", "gyroscopeValues", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "sendAccelerationBroadcast", "x", "y", "z", "sendDangerDetectedBroadcast", "sendGyroscopeBroadcast", "speak", "text", "", "stopServiceForDelay", "delayMillis", "", "app_debug"})
public final class SensorService3 extends android.app.Service {
    private android.hardware.SensorManager sensorManager;
    private android.hardware.Sensor accelerometerSensor;
    private android.hardware.Sensor gyroscopeSensor;
    private android.speech.tts.TextToSpeech tts;
    private boolean isDangerDetected = false;
    private final android.hardware.SensorEventListener sensorEventListener = null;
    private final float COLLISION_THRESHOLD_ACCELEROMETER = 30.0F;
    private final float COLLISION_THRESHOLD_GYROSCOPE = 10.0F;
    
    public SensorService3() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void detectCollision(float[] accelerationValues) {
    }
    
    private final void sendDangerDetectedBroadcast() {
    }
    
    private final void stopServiceForDelay(long delayMillis) {
    }
    
    private final void detectCollisionWithGyroscope(float[] gyroscopeValues) {
    }
    
    private final void sendAccelerationBroadcast(float x, float y, float z) {
    }
    
    private final void sendGyroscopeBroadcast(float x, float y, float z) {
    }
    
    private final void speak(java.lang.String text) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
}